package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

import com.jands.cafefx.maquinadecafe.model.bebida.StatusMensagemReceita;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.LeiteEmPo;

public class CafeComLeite implements IBebida {
    private String nome = "Café com Leite";
    private double preco = 1.00;

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
        new Cafe().usarIngrediente();
        new LeiteEmPo().usarIngrediente();
    }

    @Override
    public boolean isFiltravel() {
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
