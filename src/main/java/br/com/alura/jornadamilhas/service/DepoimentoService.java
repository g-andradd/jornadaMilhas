package br.com.alura.jornadamilhas.service;

import br.com.alura.jornadamilhas.dto.DepoimentoDto;
import br.com.alura.jornadamilhas.exception.DatabaseException;
import br.com.alura.jornadamilhas.exception.ResourceNotFoundException;
import br.com.alura.jornadamilhas.form.DepoimentoForm;
import br.com.alura.jornadamilhas.mapper.DepoimentoMapper;
import br.com.alura.jornadamilhas.model.Depoimento;
import br.com.alura.jornadamilhas.repository.DepoimentoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepoimentoService {

    private final DepoimentoRepository depoimentoRepository;

    public DepoimentoService(DepoimentoRepository depoimentoRepository) {
        this.depoimentoRepository = depoimentoRepository;
    }

    public List<DepoimentoDto> listar() {
        List<Depoimento> depoimentos = depoimentoRepository.findAll();

        return depoimentos.stream().map(DepoimentoDto::new).collect(Collectors.toList());
    }

    @Transactional
    public DepoimentoDto inserir(DepoimentoForm form) {
        Depoimento depoimento = new DepoimentoMapper().cadastrar(form);
        depoimentoRepository.save(depoimento);

        return new DepoimentoDto(depoimento);
    }

    @Transactional
    public DepoimentoDto atualizar(Long id, DepoimentoForm form) {
        Depoimento depoimento = depoimentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id not found: " + id));

        Depoimento atualizado = new DepoimentoMapper().atualizar(depoimento, form);
        return new DepoimentoDto(atualizado);
    }

    public void remover(Long id) {
        try {
            depoimentoRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id do depoimento não encontrado: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade");
        }
    }
}
