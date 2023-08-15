package br.com.alura.jornadamilhas.mapper;

import br.com.alura.jornadamilhas.dto.DepoimentoDto;
import br.com.alura.jornadamilhas.form.DepoimentoForm;
import br.com.alura.jornadamilhas.model.Depoimento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepoimentoMapper {

    private final ModelMapper modelMapper;

    public DepoimentoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Depoimento criar (DepoimentoForm form) {
        return modelMapper.map(form, Depoimento.class);
    }

    public Depoimento atualizar(Depoimento depoimento, DepoimentoForm form) {
        modelMapper.map(form, depoimento);
        return depoimento;
    }

    public DepoimentoDto criarDto(Depoimento depoimento) {
        return modelMapper.map(depoimento, DepoimentoDto.class);
    }
}
