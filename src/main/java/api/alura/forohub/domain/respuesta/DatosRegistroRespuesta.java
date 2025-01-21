package api.alura.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotBlank String mensaje,
        @NotBlank String titulo,
        @NotNull Long autorId,
        @NotNull Long topicoId) {
}