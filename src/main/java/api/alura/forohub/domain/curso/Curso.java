package api.alura.forohub.domain.curso;

import api.alura.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topico> topicos = new ArrayList<>();

    public Curso() {
    }

    public Curso(Long id, String nombre, String categoria, List<Topico> topicos) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.topicos = topicos;
    }

    public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.nombre = datosRegistroCurso.nombre();
        this.categoria = datosRegistroCurso.categoria();
        this.topicos = new ArrayList<>();
    }

    public void actulizarDatos(Curso curso) {
        if (curso.getNombre() != null) {
            this.nombre = curso.getNombre();
        }
        if (curso.getCategoria() != null) {
            this.categoria = curso.getCategoria();
        }
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }
}
