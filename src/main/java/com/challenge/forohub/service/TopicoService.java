package com.challenge.forohub.service;

import com.challenge.forohub.domain.topico.Topico;
import com.challenge.forohub.dto.DatosActualizarTopico;
import com.challenge.forohub.dto.DatosRegistroTopico;
import com.challenge.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public Topico registrar(DatosRegistroTopico datos) {

        if(repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())){
            throw new RuntimeException("El tópico ya existe");
        }

        Topico topico = new Topico(datos);

        return repository.save(topico);
    }

    public Topico actualizar(DatosActualizarTopico datos) {

        Topico topico = repository.getReferenceById(datos.id());

        topico.actualizarDatos(datos);

        return repository.save(topico);
    }

    public void eliminar(Long id) {

        repository.deleteById(id);
    }

}
