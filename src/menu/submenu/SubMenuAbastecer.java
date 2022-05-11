package menu.submenu;

import controller.AbastecimentoController;

import model.Produto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubMenuAbastecer {
    private static final AbastecimentoController abastecimentoController = new AbastecimentoController();

    public static void abastecer(){

        Map<Produto, List<Double>> produtoListMap = new HashMap<>();
        Produto.getListaDeProdutos().forEach(p-> produtoListMap.put(p, Collections.singletonList(p.getQuantidade())));

        abastecimentoController.abastecer(produtoListMap);
        SubMenuCompra.menu();

    }


}
