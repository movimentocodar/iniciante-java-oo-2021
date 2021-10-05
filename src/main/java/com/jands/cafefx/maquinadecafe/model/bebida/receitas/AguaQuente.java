package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

import com.jands.cafefx.maquinadecafe.model.bebida.StatusMensagemReceita;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.IIngrediente;
import com.jands.cafefx.maquinadecafe.model.processos.Processos;

public class AguaQuente implements IIngrediente, IBebida {
    private String nome = "Água Quente";
    private double preco = 0.0;

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
        return false;
    }

    @Override
    public void usarIngrediente() {
        prepararBebida();
        StatusMensagemReceita.usarIngrediente(getNome());
    }

    @Override
    public void prepararBebida() {
        StatusMensagemReceita.prepararBebida(getNome());
        Processos.ferverAgua();
    }

    @Override
    public boolean isFiltravel() {
        return false;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
