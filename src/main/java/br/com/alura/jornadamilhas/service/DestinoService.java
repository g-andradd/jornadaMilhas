package br.com.alura.jornadamilhas.service;

import br.com.alura.jornadamilhas.dto.DestinoDto;
import br.com.alura.jornadamilhas.exception.DatabaseException;
import br.com.alura.jornadamilhas.exception.ResourceNotFoundException;
import br.com.alura.jornadamilhas.form.DestinoForm;
import br.com.alura.jornadamilhas.mapper.DestinoMapper;
import br.com.alura.jornadamilhas.model.Destino;
import br.com.alura.jornadamilhas.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    private final DestinoRepository destinoRepository;

    public DestinoService(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

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

    public List<DestinoDto> buscarPorNome(String nome) {
        List<Destino> destinos = destinoRepository
                .findByNome(nome);

        return destinos.stream().map(DestinoDto::new).collect(Collectors.toList());
    }

    @Transactional
    public DestinoDto inserir(DestinoForm form) {
        Destino destino = new DestinoMapper().cadastrar(form);
        destinoRepository.save(destino);

        return new DestinoDto(destino);
    }

    @Transactional
    public DestinoDto atualizar(String id, DestinoForm form) {
        Destino destino = destinoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destino não encontrado: " + id));

        Destino atualizado = new DestinoMapper().atualizar(destino, form);

        return new DestinoDto(atualizado);
    }

    public void remover(String id) {
        try {
            destinoRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Depoimento não encontrado: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade");
        }
    }
}
