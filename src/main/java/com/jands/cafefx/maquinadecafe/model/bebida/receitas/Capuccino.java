package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

import com.jands.cafefx.maquinadecafe.model.bebida.StatusMensagemReceita;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.CafeEmPo;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.ChocolateEmPo;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.LeiteEmPo;

public class Capuccino implements IBebida {
    private String nome = "Capuccino";
    private double preco = 1.50;

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
        new CafeEmPo().usarIngrediente();
        new LeiteEmPo().usarIngrediente();
        new ChocolateEmPo().usarIngrediente();
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
