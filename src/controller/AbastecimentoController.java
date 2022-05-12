package controller;


import model.Produto;
import service.AbastecimentoService;

import java.util.List;
import java.util.Map;

public class AbastecimentoController {
    private final AbastecimentoService abastecimentoService = new AbastecimentoService();

    public void abastecer( Map<Produto, List<Double>> produtoEQuantidade) {
        abastecimentoService.abastecer(produtoEQuantidade);
    }


}
