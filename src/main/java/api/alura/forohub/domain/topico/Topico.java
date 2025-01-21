package api.alura.forohub.domain.topico;

import api.alura.forohub.domain.curso.Curso;
import api.alura.forohub.domain.respuesta.Respuesta;
import api.alura.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha = LocalDateTime.now();
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico() {

    }

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fecha, Boolean status, Usuario autor, Curso curso, List<Respuesta> respuestas) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.respuestas = respuestas;
    }

    public void actualizarDatos(Topico detalles) {
        if (detalles.getTitulo() != null) {
            this.titulo = detalles.getTitulo();
        }
        if (detalles.getMensaje() != null) {
            this.mensaje = detalles.getMensaje();
        }
        if (detalles.getStatus() != null) {
            this.status = detalles.getStatus();
        }
        if (detalles.getAutor() != null) {
            this.autor = detalles.getAutor();
        }
        if (detalles.getCurso() != null) {
            this.curso = detalles.getCurso();
        }
    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Boolean getStatus() {
        return status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }
}
