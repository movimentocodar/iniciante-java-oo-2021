package service;


import mensagem.MensagemProdutoReabastecido;
import model.Produto;

import java.util.List;
import java.util.Map;

import static mensagem.MensagemMaquinaAbastecida.maquinaAbastecida;

public class AbastecimentoService {

    public void abastecer(Map<Produto, List<Double>> produtoEQuantidade) {
        boolean abastecida = true;
        for (Map.Entry<Produto, List<Double>> produto : produtoEQuantidade.entrySet()) {
            if (produto.getKey().getQuantidade() < 1000) {
                double quantidadeAnterior = produto.getKey().getQuantidade();
                int ESTOQUEPADRAO = 1000;
                produto.getKey().setQuantidade(ESTOQUEPADRAO);
                MensagemProdutoReabastecido.listaDeProdutos(
                        produto.getKey().getDescricao(), quantidadeAnterior, produto.getKey().getQuantidadeMaxima()
                );
                abastecida = false;
            }

        }
        maquinaAbastecida(abastecida);

    }
}
