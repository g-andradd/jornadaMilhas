package br.com.alura.jornadamilhas.dto;

import br.com.alura.jornadamilhas.model.Destino;

import java.math.BigDecimal;

public record DestinoDto (String id, String foto, String nome, BigDecimal preco) {

    public DestinoDto(Destino destino) {
        this(destino.getId(), destino.getFoto(), destino.getNome(), destino.getPreco());
    }
}
