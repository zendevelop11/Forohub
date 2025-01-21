package api.alura.forohub.domain.respuesta;
import api.alura.forohub.domain.topico.Topico;
import api.alura.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    private LocalDateTime fecha = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    public Respuesta() {}

    public Respuesta(Long id, String mensaje, Topico topico, LocalDateTime fecha, Usuario autor) {
        this.id = id;
        this.mensaje = mensaje;
        this.topico = topico;
        this.fecha = fecha;
        this.autor = autor;
    }

    public void actualizarDatos(Respuesta detalles) {
        if (detalles.getMensaje() != null) {
            this.mensaje = detalles.getMensaje();
        }
        if (detalles.getTopico() != null) {
            this.topico = detalles.getTopico();
        }
        if (detalles.getAutor() != null) {
            this.autor = detalles.getAutor();
        }
    }


    public Long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Topico getTopico() {
        return topico;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Usuario getAutor() {
        return autor;
    }
}
