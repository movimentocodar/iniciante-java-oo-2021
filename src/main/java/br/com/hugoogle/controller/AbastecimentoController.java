package controller;


import mensagem.MensagemMaquinaAbastecida;
import mensagem.MensagemProdutoReabastecido;
import model.Produto;
import service.AbastecimentoService;

import java.util.List;
import java.util.Map;

public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService = new AbastecimentoService(
            new MensagemMaquinaAbastecida(), new MensagemProdutoReabastecido());

    public void abastecer( Map<Produto, List<Double>> produtoEQuantidade) {
        abastecimentoService.abastecer(produtoEQuantidade);
    }


}
