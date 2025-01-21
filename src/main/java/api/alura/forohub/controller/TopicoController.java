package api.alura.forohub.controller;

import api.alura.forohub.domain.topico.ITopicoRepository;
import api.alura.forohub.domain.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private ITopicoRepository topicoRepository;

    @GetMapping
    public List<Topico> obtenerTodos() {
        return topicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Topico> crear(@RequestBody Topico nuevoTopico) {
        Topico topicoGuardado = topicoRepository.save(nuevoTopico);
        return ResponseEntity.ok(topicoGuardado);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Topico> actualizar(@PathVariable Long id, @RequestBody Topico detallesTopico) {
        Topico topicoExistente = topicoRepository.getReferenceById(id);
        topicoExistente.actualizarDatos(detallesTopico);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

