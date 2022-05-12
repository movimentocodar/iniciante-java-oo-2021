package menu.submenu;

import Validacao.OpcaoSimNaoValidator;
import Validacao.ValidarOpcaoSimNao;
import controller.AbastecimentoController;

import menu.MenuPrincipal;

import model.Produto;
import util.InputScanner;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubMenuAbastecer {
    private static final AbastecimentoController abastecimentoController = new AbastecimentoController();
    private static final InputScanner input = new InputScanner() {
        @Override
        public int entrada() {
            return super.entrada();
        }
    };
    private static final int INICIO = 1;
    private static final int FINAL = 2;
    static int opcao;

    public static void abastecer() {

        Map<Produto, List<Double>> produtoListMap = new HashMap<>();
        Produto.getListaDeProdutos().forEach(p -> produtoListMap.put(p, Collections.singletonList(p.getQuantidade())));

        do {
            OpcaoSubMenuReabastecer.menu();
            opcao = input.entrada();
            ValidarOpcaoSimNao.valida(new OpcaoSimNaoValidator(), opcao, 1, 2);

        } while (opcao < INICIO || opcao > FINAL);
        switch (opcao) {
            case 1 -> abastecimentoController.abastecer(produtoListMap);
            case 2 -> MenuPrincipal.menuPrincipal();
        }
        SubMenuCompra.menu();

    }


}
