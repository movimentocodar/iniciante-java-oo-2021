package controller;

import model.Color;
import service.AbastecimentoService;

public class ControlerReabastecer {
    private final AbastecimentoService abastecimentoService = new AbastecimentoService();

    public void consultarEstoque() {
        int necessidade = abastecimentoService.consultarSaldoDeEstoquePorProduto();
        if (necessidade != 0) {
            abastecimentoService.reabastecerAMaquina();
        } else {
            System.out.println(Color.GREEN.getColorCode() + "\nMaquina se encontra abastecida!" + Color.RESET.getColorCode());
        }
    }
}