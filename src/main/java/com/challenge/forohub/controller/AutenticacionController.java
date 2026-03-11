package com.challenge.forohub.controller;

import com.challenge.forohub.domain.usuario.Usuario;
import com.challenge.forohub.dto.DatosAutenticacionUsuario;
import com.challenge.forohub.dto.DatosJWTToken;
import com.challenge.forohub.repository.UsuarioRepository;
import com.challenge.forohub.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public DatosJWTToken login(@RequestBody @Valid DatosAutenticacionUsuario datos){

        Usuario usuario = repository.findByLogin(datos.login())
                .orElseThrow();

        String token = tokenService.generarToken(usuario);

        return new DatosJWTToken(token);
    }

}
