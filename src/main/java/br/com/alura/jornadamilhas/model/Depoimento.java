package br.com.alura.jornadamilhas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "depoimentos")
public class Depoimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Long id;

    @Lob
    @Column(nullable=false, columnDefinition = "TEXT")
    private String foto;

    @Column(nullable=false)
    private String depoimento;

    @Column(nullable=false, length = 100)
    private String cliente;

    public Depoimento() {
    }

    public Depoimento(String foto, String depoimento, String cliente) {
        this.foto = foto;
        this.depoimento = depoimento;
        this.cliente = cliente;
    }

    public Long getId() {
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
