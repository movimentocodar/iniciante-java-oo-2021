package br.com.hugoogle.menu.submenu;

import br.com.hugoogle.Validacao.OpcaoSimNaoValidator;
import br.com.hugoogle.Validacao.ValidarOpcaoSimNao;
import br.com.hugoogle.controller.AbastecimentoController;

import br.com.hugoogle.menu.MenuPrincipal;

import br.com.hugoogle.model.Produto;
import br.com.hugoogle.service.AbastecimentoService;
import br.com.hugoogle.util.InputScanner;
import br.com.hugoogle.util.PopularProdutos;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubMenuAbastecer {
    public static final int ABASTECER = 1;
    public static final int MENUPRINCIPAL = 2;
    public static final int SIM = 1;
    public static final int NAO = 2;
    private final AbastecimentoController abastecimentoController = new AbastecimentoController();
    private final InputScanner input = new InputScanner();
    static int opcao;
    Map<Produto, List<Double>> produtoListMap = new HashMap<>();
    public SubMenuAbastecer() {
        abastecer();
    }

    public void abastecer() {

        PopularProdutos.getListaDeProdutos().forEach(p -> produtoListMap.put(p, Collections.singletonList(p.getQuantidade())));
        int INICIO = 1;
        int FINAL = 2;
        do {
            OpcaoSubMenuReabastecer.menu();
            opcao = input.entrada();
            ValidarOpcaoSimNao.valida(new OpcaoSimNaoValidator(), opcao, SIM, NAO);

        } while (opcao < INICIO || opcao > FINAL);
        switch (opcao) {
            case ABASTECER -> abastecimentoController.abastecer(produtoListMap);
            case MENUPRINCIPAL -> new MenuPrincipal();
        }
        new SubMenuCompra();

    }


}
