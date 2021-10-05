package com.jands.cafefx.maquinadecafe.model.credito.modelocredito;

import com.jands.cafefx.maquinadecafe.model.bebida.receitas.IBebida;
import com.jands.cafefx.maquinadecafe.model.credito.GerenciadorDeCredito;

public class VerificarCredito {

    public static boolean verificar(IBebida bebida) {
        if (GerenciadorDeCredito.getCreditoDaMaquina() < bebida.getPreco()) {
            System.out.println(
                    "Saldo Insuficiente "
                            + bebida.getNome()
                            + " Custa "
                            + bebida.getPreco()
                            + "\nSaldo Atual: "
                            + GerenciadorDeCredito.getCreditoDaMaquina());
            return false;
        }
        return true;
    }
}
