package br.com.alura.jornadamilhas.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class DestinoForm {

    @NotBlank(message = "A foto 1 não pode estar em branco")
    private String foto1;

    @NotBlank(message = "A foto 2 não pode estar em branco")
    private String foto2;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotNull(message = "O preço não pode estar nulo")
    @Positive(message = "O preço deve estar positivo")
    private BigDecimal preco;

    @Size(max = 160)
    @NotNull(message = "A meta não pode estar nula")
    private String meta;

    @Size(max = 1000)
    private String textoDescritivo;

    public String getFoto1() {
        return foto1;
    }

    public String getFoto2() {
        return foto2;
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

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
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
