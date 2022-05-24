package br.com.hugoogle.menu.submenu;

import br.com.hugoogle.Validacao.OpcaoMenuValidator;

import br.com.hugoogle.Validacao.ValidarOpcao;

import br.com.hugoogle.menu.fabrica.Bebida;
import br.com.hugoogle.menu.fabrica.FabricaMenuPagamento;
import br.com.hugoogle.util.InputScanner;


public class SubMenuPagamento {
    private static final InputScanner inputScanner = new InputScanner();
    private static final int INICIO = 1;
    private static final int FINAL = 3;


    public static void menu(Bebida bebida) {
        if (bebida.isNotGratis()) {
            int opcao;
            do {
                OpcaoSubMenuPagamento.menu();
                opcao = inputScanner.entrada();
                ValidarOpcao.valida(new OpcaoMenuValidator(), opcao, INICIO, FINAL);
            } while (opcao < INICIO || opcao > FINAL);

            switch (opcao) {
                case 1, 2, 3 -> FabricaMenuPagamento.getMenu(opcao);

            }
        }
    }


}

