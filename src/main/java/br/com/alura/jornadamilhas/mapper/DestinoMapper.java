package br.com.alura.jornadamilhas.mapper;

import br.com.alura.jornadamilhas.form.DestinoForm;
import br.com.alura.jornadamilhas.model.Destino;

public class DestinoMapper {

    public Destino cadastrar(DestinoForm form) {

        return new Destino(form.getFoto(), form.getNome(), form.getPreco());

    }

    public Destino atualizar(Destino destino, DestinoForm form) {
        destino.setFoto(form.getFoto());
        destino.setNome(form.getNome());
        destino.setPreco(form.getPreco());

        return destino;
    }
}
