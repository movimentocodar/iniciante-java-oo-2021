package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

import com.jands.cafefx.maquinadecafe.model.bebida.StatusMensagemReceita;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.ChaEmPo;

public class ChaDeLimao implements IBebida {
    private String nome = "Chá de Limão";
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
        new AguaQuente().usarIngrediente();
        new ChaEmPo().usarIngrediente();
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
