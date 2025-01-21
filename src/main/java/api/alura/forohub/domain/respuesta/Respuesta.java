package api.alura.forohub.domain.respuesta;
import api.alura.forohub.domain.topico.Topico;
import api.alura.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
