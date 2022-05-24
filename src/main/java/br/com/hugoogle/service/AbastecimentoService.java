package br.com.hugoogle.service;


import br.com.hugoogle.mensagem.MensagemMaquinaAbastecida;
import br.com.hugoogle.mensagem.MensagemProdutoReabastecido;
import br.com.hugoogle.model.Produto;

import java.util.List;
import java.util.Map;


public class AbastecimentoService {
    private MensagemMaquinaAbastecida mensagemMaquinaAbastecida  = new MensagemMaquinaAbastecida();
    private MensagemProdutoReabastecido mensagemProdutoReabastecido = new MensagemProdutoReabastecido();

    public void abastecer(Map<Produto, List<Double>> produtoEQuantidade) {

        for (Map.Entry<Produto, List<Double>> produto : produtoEQuantidade.entrySet()) {
            if (produto.getKey().getQuantidade() < 1000) {
                mensagemMaquinaAbastecida.maquinaDesabastecida();

                double quantidadeAnterior = produto.getKey().getQuantidade();
                int ESTOQUEPADRAO = 1000;
                produto.getKey().setQuantidade(ESTOQUEPADRAO);
                mensagemProdutoReabastecido.listaDeProdutos(
                        produto.getKey().getDescricao(), quantidadeAnterior, produto.getKey().getQuantidadeMaxima()
                );
            }

        }
        mensagemMaquinaAbastecida.maquinaAbastecida();

    }
}
