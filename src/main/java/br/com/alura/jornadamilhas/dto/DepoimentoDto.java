package br.com.alura.jornadamilhas.dto;

import br.com.alura.jornadamilhas.model.Depoimento;

public class DepoimentoDto {

    private final String id;
    private final String foto;
    private final String depoimento;
    private final String cliente;

    public DepoimentoDto(Depoimento depoimento) {
        this.id = depoimento.getId();
        this.foto = depoimento.getFoto();
        this.depoimento = depoimento.getDepoimento();
        this.cliente = depoimento.getCliente();
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
}
