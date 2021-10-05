package com.jands.cafefx.maquinadecafe.model.credito;

import com.jands.cafefx.maquinadecafe.model.bebida.receitas.IBebida;
import com.jands.cafefx.maquinadecafe.model.credito.modelocredito.AdicionarCreditoNaMaquina;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;
import com.jands.cafefx.maquinadecafe.model.credito.modelocredito.CreditoInvalidoException;
import com.jands.cafefx.maquinadecafe.model.credito.modelocredito.SubtrairCreditoDaMaquina;
import com.jands.cafefx.maquinadecafe.model.credito.modelocredito.VerificarCredito;

public class GerenciadorDeCredito {
    private static double creditoDaMaquina;

    public static boolean adicionarCredito(ICreditavel formaDePagamento, double valor) {
        try {
            creditoDaMaquina += AdicionarCreditoNaMaquina.adicionar(formaDePagamento, valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean verificarCredito(IBebida bebida) {
        if (!VerificarCredito.verificar(bebida)) {
            throw new CreditoInvalidoException("Saldo Insuficiente!");
        }
        System.out.println("Saldo suficiente! " + bebida.getNome() + " Irá Custar: " + bebida.getPreco());
        return true;
    }

    public static boolean removerCredito(double valor) {
        try {
            creditoDaMaquina -= SubtrairCreditoDaMaquina.sacar(valor, creditoDaMaquina);
            System.out.println("Usando Crédito, Atual: " + getCreditoDaMaquina());
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean sacarCredito() {
        try {
            System.out.println("Sacando " + getCreditoDaMaquina());
            creditoDaMaquina = 0.0;
            System.out.println("Crédito Sacado, Atual: " + getCreditoDaMaquina());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static double getCreditoDaMaquina() {
        return creditoDaMaquina;
    }
}
