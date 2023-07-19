package br.com.alura.jornadamilhas.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DepoimentoForm {

    @NotBlank(message = "A foto não pode estar em branco")
    private String foto;

    @NotBlank(message = "O depoimento não pode estar em branco")
    @Size(max = 500, message = "O depoimento deve ter no máximo 500 caracteres")
    private String depoimento;

    @NotBlank(message = "O cliente não pode estar em branco")
    @Size(max = 100, message = "O cliente deve ter no máximo 100 caracteres")
    private String cliente;

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
