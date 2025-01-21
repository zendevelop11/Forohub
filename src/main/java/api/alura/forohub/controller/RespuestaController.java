package api.alura.forohub.controller;

import api.alura.forohub.domain.respuesta.IRespuestaRepository;
import api.alura.forohub.domain.respuesta.Respuesta;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private IRespuestaRepository respuestaRepository;

    @GetMapping
    public List<Respuesta> obtenerTodas() {
        return respuestaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable Long id) {
        Optional<Respuesta> respuesta = respuestaRepository.findById(id);
        return respuesta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Respuesta> crear(@RequestBody Respuesta nuevaRespuesta) {
        Respuesta respuestaGuardada = respuestaRepository.save(nuevaRespuesta);
        return ResponseEntity.ok(respuestaGuardada);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Respuesta> actualizar(@PathVariable Long id, @RequestBody Respuesta detallesRespuesta) {
        Respuesta respuestaExistente = respuestaRepository.getReferenceById(id);
        respuestaExistente.actualizarDatos(detallesRespuesta);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (respuestaRepository.existsById(id)) {
            respuestaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}