package br.com.alura.jornadamilhas.dto;

import br.com.alura.jornadamilhas.model.Destino;

import java.math.BigDecimal;
import java.util.List;

public record DestinoDto (String id, List<String> fotos, String nome, BigDecimal preco) {

    public DestinoDto(Destino destino) {
        this(destino.getId(), destino.getFotos(), destino.getNome(), destino.getPreco());
    }
}
