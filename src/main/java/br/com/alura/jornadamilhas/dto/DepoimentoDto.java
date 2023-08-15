package br.com.alura.jornadamilhas.dto;

import br.com.alura.jornadamilhas.model.Depoimento;

public record DepoimentoDto (String id,String foto, String depoimento, String cliente){

    public DepoimentoDto(Depoimento depoimento) {
        this(depoimento.getId(), depoimento.getFoto(), depoimento.getDepoimento(), depoimento.getCliente());
    }
}
