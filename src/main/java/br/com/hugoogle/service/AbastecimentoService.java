package service;


import mensagem.MensagemMaquinaAbastecida;
import mensagem.MensagemProdutoReabastecido;
import model.Produto;

import java.util.List;
import java.util.Map;


public class AbastecimentoService {
    MensagemMaquinaAbastecida mensagemMaquinaAbastecida ;

    public AbastecimentoService(MensagemMaquinaAbastecida mensagemMaquinaAbastecida, MensagemProdutoReabastecido mensagemProdutoReabastecido) {
        this.mensagemMaquinaAbastecida = mensagemMaquinaAbastecida;
        this.mensagemProdutoReabastecido = mensagemProdutoReabastecido;
    }

    MensagemProdutoReabastecido mensagemProdutoReabastecido;






    public void abastecer(Map<Produto, List<Double>> produtoEQuantidade) {
        boolean abastecida = true;
        for (Map.Entry<Produto, List<Double>> produto : produtoEQuantidade.entrySet()) {
            if (produto.getKey().getQuantidade() < 1000) {
                double quantidadeAnterior = produto.getKey().getQuantidade();
                int ESTOQUEPADRAO = 1000;
                produto.getKey().setQuantidade(ESTOQUEPADRAO);
                mensagemProdutoReabastecido.listaDeProdutos(
                        produto.getKey().getDescricao(), quantidadeAnterior, produto.getKey().getQuantidadeMaxima()
                );
                abastecida = false;
            }

        }
      mensagemMaquinaAbastecida.maquinaAbastecida(abastecida);

    }
}
