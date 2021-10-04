package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.CafeEmPo;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.ChocolateEmPo;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.LeiteEmPo;
import com.jands.cafefx.maquinadecafe.model.processos.Processos;

public class Capuccino implements IBebida {

    @Override
    public void prepararBebida() {
        new AguaQuente().usarIngrediente();
        new CafeEmPo().usarIngrediente();
        new LeiteEmPo().usarIngrediente();
        new ChocolateEmPo().usarIngrediente();
        System.out.println("Capuccino Pronto!!!");
    }

    @Override
    public boolean isFiltravel() {
        return true;
    }
}
