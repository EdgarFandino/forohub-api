package com.challenge.forohub.dto;

import com.challenge.forohub.domain.topico.StatusTopico;
import com.challenge.forohub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status,
        String autor,
        String curso

) {

    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }

}
