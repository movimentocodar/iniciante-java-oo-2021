package com.jands.cafefx.maquinadecafe.model;

import com.jands.cafefx.maquinadecafe.model.bebida.GerenciadorBebidas;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.IBebida;
import com.jands.cafefx.maquinadecafe.model.componentes.ReservatorioDeAgua;
import com.jands.cafefx.maquinadecafe.model.credito.GerenciadorDeCredito;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;
import javafx.scene.control.Slider;

public class MaquinaDeCafe {

    public boolean prepararBebida(IBebida bebida, Slider sliderAcucar) {
        return GerenciadorBebidas.prepararBebida(bebida, sliderAcucar);
    }

    public boolean adicionarCreditoNaMaquina(ICreditavel formaDePagamento, double valor) {
        return GerenciadorDeCredito.adicionarCredito(formaDePagamento, valor);
    }

    public boolean sacarCreditoDaMaquina() {
        return GerenciadorDeCredito.sacarCredito();
    }

    public boolean reabastecerMaquina() {
        return ReservatorioDeAgua.abastercerAgua();
    }
}
