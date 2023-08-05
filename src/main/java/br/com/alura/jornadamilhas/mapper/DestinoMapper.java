package br.com.alura.jornadamilhas.mapper;

import br.com.alura.jornadamilhas.form.DestinoForm;
import br.com.alura.jornadamilhas.model.Destino;

import java.util.ArrayList;
import java.util.List;

public class DestinoMapper {

    public Destino cadastrar(DestinoForm form) {
        List<String> fotos = new ArrayList<>();
        fotos.add(form.getFoto1());
        fotos.add(form.getFoto2());

        return new Destino(fotos, form.getNome(), form.getPreco(), form.getMeta(), form.getTextoDescritivo());

    }

    public Destino atualizar(Destino destino, DestinoForm form) {
        List<String> fotos = new ArrayList<>();
        fotos.add(form.getFoto1());
        fotos.add(form.getFoto2());

        destino.setFotos(fotos);
        destino.setNome(form.getNome());
        destino.setPreco(form.getPreco());

        return destino;
    }
}
