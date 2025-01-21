package api.alura.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso (
       @NotBlank
       String nombre,
       @NotBlank
       String categoria
) {}
