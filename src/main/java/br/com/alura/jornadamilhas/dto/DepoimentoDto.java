package br.com.alura.jornadamilhas.dto;

import br.com.alura.jornadamilhas.model.Depoimento;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class DepoimentoDto {

    private final Long id;
    private final String foto;
    private final String depoimento;
    private final String cliente;

    public DepoimentoDto(Depoimento depoimento) {
        this.id = depoimento.getId();
        this.foto = depoimento.getFoto();
        this.depoimento = depoimento.getDepoimento();
        this.cliente = depoimento.getCliente();
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
}
