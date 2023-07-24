package br.com.alura.jornadamilhas.service;

import br.com.alura.jornadamilhas.dto.DestinoDto;
import br.com.alura.jornadamilhas.exception.ResourceNotFoundException;
import br.com.alura.jornadamilhas.form.DestinoForm;
import br.com.alura.jornadamilhas.mapper.DestinoMapper;
import br.com.alura.jornadamilhas.model.Destino;
import br.com.alura.jornadamilhas.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    public List<DestinoDto> buscarTodos() {
        List<Destino> destinos = destinoRepository
                .findAll();

        return destinos.stream().map(DestinoDto::new).collect(Collectors.toList());
    }

    @Transactional
    public DestinoDto buscarPorId(String id) {
        Destino destino = destinoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destino não encontrado: " + id));

        return new DestinoDto(destino);
    }

    @Transactional
    public DestinoDto inserir(DestinoForm form) {
        Destino destino = new DestinoMapper().cadastrar(form);
        destinoRepository.save(destino);

        return new DestinoDto(destino);
    }

    public DestinoDto atualizar(String id, DestinoForm form) {
        Destino destino = destinoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destino não encontrado: " + id));

        Destino atualizado = new DestinoMapper().atualizar(destino, form);

        return new DestinoDto(atualizado);
    }
}
