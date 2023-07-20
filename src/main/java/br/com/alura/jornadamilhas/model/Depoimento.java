package br.com.alura.jornadamilhas.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "depoimentos")
public class Depoimento {

    @Id
    private String id;

    private String foto;

    private String depoimento;

    private String cliente;

    public Depoimento() {
    }

    public Depoimento(String foto, String depoimento, String cliente) {
        this.foto = foto;
        this.depoimento = depoimento;
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }

    public String getDepoimento() {
        return depoimento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setDepoimento(String depoimento) {
        this.depoimento = depoimento;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
