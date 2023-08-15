package br.com.alura.jornadamilhas.mapper;

import br.com.alura.jornadamilhas.dto.DestinoDto;
import br.com.alura.jornadamilhas.form.DestinoForm;
import br.com.alura.jornadamilhas.model.Destino;
import br.com.alura.jornadamilhas.util.ChatGPTClient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DestinoMapper {

    private final ModelMapper modelMapper;
    private final ChatGPTClient gptClient;

    public DestinoMapper(ModelMapper modelMapper, ChatGPTClient gptClient) {
        this.modelMapper = modelMapper;
        this.gptClient = gptClient;
    }

    public Destino criar(DestinoForm form) {
        String textoDescritivo = form.getTextoDescritivo();
        if (textoDescritivo == null || textoDescritivo.trim().isEmpty()) {
            textoDescritivo = gptClient.gerarTextoDescritivo(form.getNome());

            form.setTextoDescritivo(textoDescritivo);
        }

        return modelMapper.map(form, Destino.class);
    }

    public void atualizar(DestinoForm form, Destino destino) {
        modelMapper.map(form, destino);
    }

    public DestinoDto criarDto(Destino destino) {
        return modelMapper.map(destino, DestinoDto.class);
    }
}
