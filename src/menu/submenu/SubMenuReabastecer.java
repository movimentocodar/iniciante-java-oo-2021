package menu.submenu;

import Validacao.*;
import menu.fabrica.FabricaMenuReabastecer;

import util.InputScanner;


public class SubMenuReabastecer {
    private static final InputScanner input = new InputScanner() {
        @Override
        public int entrada() {
            return super.entrada();
        }
    };
    private static final int INICIO = 1;
    private static final int FINAL = 2;
    static int opcao;

    public static void menu() {

        do {
            OpcaoSubMenuReabastecer.menu();
            opcao = input.entrada();
            ValidarOpcaoSimNao.valida(new OpcaoSimNaoValidator(), opcao, 1, 2);

        } while (opcao < INICIO || opcao > FINAL);
        switch (opcao) {
            case 1, 2 -> FabricaMenuReabastecer.getMenu(opcao);

        }

    }




}
