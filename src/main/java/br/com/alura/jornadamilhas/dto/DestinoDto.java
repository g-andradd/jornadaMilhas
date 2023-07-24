package br.com.alura.jornadamilhas.dto;

import br.com.alura.jornadamilhas.model.Destino;

import java.math.BigDecimal;

public class DestinoDto {


    private final String id;
    private final String foto;
    private final String nome;
    private final BigDecimal preco;

    public DestinoDto(Destino destino) {
        this.id = destino.getId();
        this.foto = destino.getFoto();
        this.nome = destino.getNome();
        this.preco = destino.getPreco();
    }

    public String getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

}
