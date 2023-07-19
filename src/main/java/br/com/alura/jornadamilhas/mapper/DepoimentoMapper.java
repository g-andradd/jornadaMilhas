package br.com.alura.jornadamilhas.mapper;

import br.com.alura.jornadamilhas.form.DepoimentoForm;
import br.com.alura.jornadamilhas.model.Depoimento;

public class DepoimentoMapper {
    public Depoimento cadastrar(DepoimentoForm form) {
        return new Depoimento(form.getFoto(), form.getDepoimento(), form.getCliente());
    }

    public Depoimento atualizar(Depoimento depoimento, DepoimentoForm form) {
        depoimento.setDepoimento(form.getDepoimento());
        depoimento.setFoto(form.getFoto());
        depoimento.setCliente(form.getCliente());

        return depoimento;
    }
}
