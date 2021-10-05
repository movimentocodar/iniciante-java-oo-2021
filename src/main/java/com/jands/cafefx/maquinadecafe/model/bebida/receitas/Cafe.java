package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

import com.jands.cafefx.maquinadecafe.model.bebida.StatusMensagemReceita;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.IIngrediente;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.PoDeCafe;

public class Cafe implements IIngrediente, IBebida {
    private String nome = "Café";
    private double preco = 0.50;

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public boolean isAcucaravel() {
        return true;
    }

    @Override
    public void prepararBebida() {
        StatusMensagemReceita.prepararBebida(getNome());
        new AguaQuente().usarIngrediente();
        new PoDeCafe().usarIngrediente();
    }

    @Override
    public boolean isFiltravel() {
        return true;
    }

    @Override
    public void usarIngrediente() {
        prepararBebida();
        StatusMensagemReceita.usarIngrediente(getNome());
    }

    @Override
    public String toString() {
        return getNome();
    }
}
