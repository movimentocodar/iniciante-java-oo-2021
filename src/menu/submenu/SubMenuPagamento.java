package menu.submenu;

import Validacao.OpcaoMenuValidator;
import Validacao.OpcaoPainelValidator;
import Validacao.ValidarOpcao;
import controller.VendaController;
import enumerator.ColorEnum;
import enumerator.MenuPagamentoEnum;
import menu.fabrica.Bebida;
import menu.fabrica.FabricaMenuPagamento;
import util.InputScanner;

import java.text.DecimalFormat;
import java.util.Arrays;

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

