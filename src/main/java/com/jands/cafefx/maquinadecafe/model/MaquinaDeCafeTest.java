package com.jands.cafefx.maquinadecafe.model;

import com.jands.cafefx.maquinadecafe.model.bebida.GerenciadorBebidas;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.AguaQuente;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.Cafe;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.CafeComLeite;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.Capuccino;
import com.jands.cafefx.maquinadecafe.model.processos.Processos;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.Cedulas;
import com.jands.cafefx.maquinadecafe.model.credito.GerenciadorDeCredito;

public class MaquinaDeCafeTest {

    public static void main(String[] args) {

        GerenciadorBebidas.prepararBebida(new Capuccino());

    }


}
