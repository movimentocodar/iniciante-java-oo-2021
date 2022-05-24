package menu;

import Validacao.OpcaoPainelValidator;
import Validacao.ValidarOpcao;
import menu.fabrica.FabricaMenu;
import util.InputScanner;

public class MenuPrincipal {

    private static final FabricaMenu fabricaMenu = new FabricaMenu();
    private static final InputScanner inputScanner = new InputScanner();
    private static final int INICIO = 1;
    private static final int FIM = 3;

    public MenuPrincipal() {
        menu();
    }


    private static void menuInicial() {
        int opcao;

        OpcaoMenuPrincipal.descricaoMenu();

        do {
            opcao = inputScanner.entrada();
            ValidarOpcao.valida(new OpcaoPainelValidator(), opcao, INICIO, FIM);

        } while (opcao < INICIO || opcao > FIM);

        switch (opcao) {
            case 1, 2, 3 -> fabricaMenu.getMenu(opcao);

        }

    }

    public static void menu(){
        menuInicial();
    }

}