package com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes;

import com.jands.cafefx.maquinadecafe.model.bebida.StatusMensagemReceita;

public class PoDeCafe implements IIngrediente {
    private String nome = "Pó de Café";

    @Override
    public void usarIngrediente() {
        StatusMensagemReceita.usarIngrediente(getNome());
    }

    @Override
    public String getNome() {
        return nome;
    }

}
