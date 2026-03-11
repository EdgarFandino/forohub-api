package com.challenge.forohub.controller;

import com.challenge.forohub.domain.topico.Topico;
import com.challenge.forohub.dto.DatosActualizarTopico;
import com.challenge.forohub.dto.DatosListadoTopico;
import com.challenge.forohub.dto.DatosRegistroTopico;
import com.challenge.forohub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    // Crear tópico
    @PostMapping
    public Topico registrar(@RequestBody @Valid DatosRegistroTopico datos) {

        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new RuntimeException("El tópico ya existe");
        }

        Topico topico = new Topico(datos);

        return repository.save(topico);
    }

    // Listar tópicos con paginación
    @GetMapping
    public Page<DatosListadoTopico> listar(Pageable paginacion) {

        return repository
                .findAll(paginacion)
                .map(DatosListadoTopico::new);
    }

    // Actualizar tópico
    @PutMapping
    public Topico actualizar(@RequestBody @Valid DatosActualizarTopico datos) {

        Topico topico = repository.getReferenceById(datos.id());

        topico.actualizarDatos(datos);

        return repository.save(topico);
    }

    // Eliminar tópico
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {

        repository.deleteById(id);
    }

}
