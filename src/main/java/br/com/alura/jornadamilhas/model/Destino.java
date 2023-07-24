package br.com.alura.jornadamilhas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "destinos")
public class Destino {

    @Id
    private String id;
    private String foto;
    private String nome;
    private BigDecimal preco;

    public Destino() {
    }

    public Destino(String foto, String nome, BigDecimal preco) {
        this.foto = foto;
        this.nome = nome;
        this.preco = preco;
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

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
