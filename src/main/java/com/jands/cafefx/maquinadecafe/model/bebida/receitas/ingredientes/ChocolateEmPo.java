package com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes;

import com.jands.cafefx.maquinadecafe.model.bebida.StatusMensagemReceita;

public class ChocolateEmPo implements IIngrediente {
    private String nome = "Chocolate em Pó";

    @Override
    public void usarIngrediente() {
        StatusMensagemReceita.usarIngrediente(getNome());
    }

    @Override
    public String getNome() {
        return nome;
    }

}
