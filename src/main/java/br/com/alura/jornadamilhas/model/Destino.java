package br.com.alura.jornadamilhas.model;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "destinos")
public class Destino {

    @Id
    private String id;
    private List<String> fotos = new ArrayList<>();
    private String nome;
    private BigDecimal preco;
    private String meta;
    private String textoDescritivo;

    public Destino() {
    }

    public Destino(List<String> fotos, String nome, BigDecimal preco, String meta, String textoDescritivo) {
        this.fotos = fotos;
        this.nome = nome;
        this.preco = preco;
        this.meta = meta;
        this.textoDescritivo = textoDescritivo;
    }

    public String getId() {
        return id;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getMeta() {
        return meta;
    }

    public String getTextoDescritivo() {
        return textoDescritivo;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public void setTextoDescritivo(String textoDescritivo) {
        this.textoDescritivo = textoDescritivo;
    }
}
