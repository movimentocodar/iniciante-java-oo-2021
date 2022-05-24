package br.com.hugoogle.menu.submenu;

import br.com.hugoogle.Validacao.OpcaoSimNaoValidator;
import br.com.hugoogle.Validacao.ValidarOpcaoSimNao;
import br.com.hugoogle.menu.fabrica.FabricaMenuReabastecer;

import br.com.hugoogle.util.InputScanner;


public class SubMenuReabastecer {
    private final FabricaMenuReabastecer fabricaMenuReabastecer = new FabricaMenuReabastecer();
    private final InputScanner input = new InputScanner();
    private static final int INICIO = 1;
    private static final int FINAL = 2;
    static int opcao;

    public void menu() {

        do {
            OpcaoSubMenuReabastecer.menu();
            opcao = input.entrada();
            ValidarOpcaoSimNao.valida(new OpcaoSimNaoValidator(), opcao, 1, 2);

        } while (opcao < INICIO || opcao > FINAL);
        switch (opcao) {
            case 1, 2 -> fabricaMenuReabastecer.getMenu(opcao);

        }

    }




}
