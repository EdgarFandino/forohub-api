package com.challenge.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(

        @NotBlank
        String login,

        @NotBlank
        String password

) {
}
