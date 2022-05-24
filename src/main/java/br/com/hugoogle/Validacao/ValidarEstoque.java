package br.com.hugoogle.Validacao;

import br.com.hugoogle.enumerator.QuantidadeEnum;
import br.com.hugoogle.mensagem.MensagemQuantidadeMaiorQueMaxima;
import br.com.hugoogle.menu.fabrica.Bebida;
import br.com.hugoogle.model.Produto;

import java.util.List;
import java.util.Map;

public class ValidarEstoque {
    private final MensagemQuantidadeMaiorQueMaxima mensagemQuantidadeMaiorQueMaxima = new MensagemQuantidadeMaiorQueMaxima();

    public void calcular(Bebida bebida, Map<Produto, List<Double>> produtoEQuantidade) {
        for (Map.Entry<Produto, List<Double>> produto : produtoEQuantidade.entrySet()) {
            if (produto.getValue().get(QuantidadeEnum.QUANTIDADETOTAL.getvalor()) > produto.getKey().getQuantidadeMaxima()) {
                mensagemQuantidadeMaiorQueMaxima.dados(bebida, produto);
            } else if (produto.getValue().get(QuantidadeEnum.QUANTIDADETOTAL.getvalor()) > produto.getKey().getQuantidade() && (produto.getKey().getQuantidade() < produto.getKey().getQuantidadeMaxima())) {
                mensagemQuantidadeMaiorQueMaxima.dados(bebida, produto);
            }
        }
    }
}
