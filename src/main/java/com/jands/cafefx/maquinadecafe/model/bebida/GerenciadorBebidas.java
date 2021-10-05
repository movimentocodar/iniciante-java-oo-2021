package com.jands.cafefx.maquinadecafe.model.bebida;

import com.jands.cafefx.maquinadecafe.model.bebida.receitas.IBebida;
import com.jands.cafefx.maquinadecafe.model.credito.GerenciadorDeCredito;
import com.jands.cafefx.maquinadecafe.model.processos.Processos;
import javafx.scene.control.Slider;

public class GerenciadorBebidas {

    public static boolean prepararBebida(IBebida bebida, Slider sliderAcucar) {
        try {
            GerenciadorDeCredito.verificarCredito(bebida);

            bebida.prepararBebida();
            if (bebida.isFiltravel()) {
                Processos.filtrar();
            }

            if (bebida.isAcucaravel()) {
                Processos.adicionarAcucar(sliderAcucar);
            }

            GerenciadorDeCredito.removerCredito(bebida.getPreco());
            System.out.println(bebida.getNome() + " Pronto(a)!!!");
            System.out.println("────────────────────────────────────────────");

            return true;

        } catch (Exception e) {
            System.out.println("Não foi Possivel Preparar o(a) " + bebida.getNome());
            System.out.println("────────────────────────────────────────────");
            return false;
        }
    }

}
