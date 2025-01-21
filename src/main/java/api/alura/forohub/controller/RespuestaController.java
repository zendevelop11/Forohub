package api.alura.forohub.controller;

import api.alura.forohub.domain.respuesta.IRespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class RespuestaController {

    @Autowired
    IRespuestaRepository respuestaRepository;


}
