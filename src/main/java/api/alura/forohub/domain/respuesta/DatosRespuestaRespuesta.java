package api.alura.forohub.domain.respuesta;

public record DatosRespuestaRespuesta(
        String mensaje,
        String titulo,
        Long autorId,
        Long topicoId
) {
}
