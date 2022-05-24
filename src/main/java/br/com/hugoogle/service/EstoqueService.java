package br.com.hugoogle.service;

import br.com.hugoogle.enumerator.QuantidadeEnum;
import br.com.hugoogle.model.Produto;

import java.util.List;
import java.util.Map;

public class EstoqueService {

    public void atualizarEstoque(Map<Produto, List<Double>> produtoEQuantidade) {
        for (Map.Entry<Produto, List<Double>> produto : produtoEQuantidade.entrySet()) {
            produto.getKey().setQuantidade(
                    produto.getKey().getQuantidade() - produto.getValue().get(QuantidadeEnum.QUANTIDADETOTAL.getvalor())
            );
        }
    }
}