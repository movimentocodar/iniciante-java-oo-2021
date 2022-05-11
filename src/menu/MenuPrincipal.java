package menu;

import Validacao.OpcaoPainelValidator;
import Validacao.ValidarOpcao;
import menu.fabrica.FabricaMenu;
import util.InputScanner;

public class MenuPrincipal {

    private static final InputScanner inputScanner = new InputScanner() {
        @Override
        public int entrada() {
            return super.entrada();
        }
    };
    private static final int INICIO = 1;
    private static final int FIM = 4;

    private static void menu() {
        int opcao;

        OpcaoMenuPrincipal.descricaoMenu();

        do {
            opcao = inputScanner.entrada();
            ValidarOpcao.valida(new OpcaoPainelValidator(), opcao, INICIO, FIM);

        } while (opcao < INICIO || opcao > FIM);

        switch (opcao) {
            case 1, 2, 3 -> FabricaMenu.getMenu(opcao);

        }

    }

    public static void menuPrincipal() {
        menu();
    }


}