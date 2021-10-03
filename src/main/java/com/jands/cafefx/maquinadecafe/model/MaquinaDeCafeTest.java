package com.jands.cafefx.maquinadecafe.model;

import com.jands.cafefx.maquinadecafe.model.credito.creditavel.Debito;
import com.jands.cafefx.maquinadecafe.model.credito.GerenciadorDeCredito;

public class MaquinaDeCafeTest {

    public static void main(String[] args) {
        GerenciadorDeCredito.adicionarCredito(new Debito(), 50);

        System.out.println(GerenciadorDeCredito.getCreditoDaMaquina());
    }


}
