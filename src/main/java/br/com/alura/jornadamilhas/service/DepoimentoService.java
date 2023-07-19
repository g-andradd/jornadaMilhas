package br.com.alura.jornadamilhas.service;

import br.com.alura.jornadamilhas.dto.DepoimentoDto;
import br.com.alura.jornadamilhas.form.DepoimentoForm;
import br.com.alura.jornadamilhas.mapper.DepoimentoMapper;
import br.com.alura.jornadamilhas.model.Depoimento;
import br.com.alura.jornadamilhas.repository.DepoimentoRepository;
import org.springframework.stereotype.Service;

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

    public DepoimentoDto inserir(DepoimentoForm form) {
        Depoimento depoimento = new DepoimentoMapper().cadastrar(form);
        depoimentoRepository.save(depoimento);

        return new DepoimentoDto(depoimento);
    }

}
