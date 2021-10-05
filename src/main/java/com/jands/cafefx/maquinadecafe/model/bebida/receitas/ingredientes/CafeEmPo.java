package com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes;

import com.jands.cafefx.maquinadecafe.model.bebida.StatusMensagemReceita;

public class CafeEmPo implements IIngrediente {
    private String nome = "Café em Pó";

    @Override
    public void usarIngrediente() {
        StatusMensagemReceita.usarIngrediente(getNome());
    }

    @Override
    public String getNome() {
        return nome;
    }

}
