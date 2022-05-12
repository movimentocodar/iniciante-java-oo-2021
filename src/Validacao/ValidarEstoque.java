package Validacao;

import enumerator.QuantidadeEnum;
import mensagem.MensagemQuantidadeMaiorQueDisponivel;
import mensagem.MensagemQuantidadeMaiorQueMaxima;
import menu.fabrica.Bebida;
import model.Produto;

import java.util.List;
import java.util.Map;

public class ValidarEstoque {

    public void calcular(Bebida bebida, Map<Produto, List<Double>> produtoEQuantidade) {
        for (Map.Entry<Produto, List<Double>> produto : produtoEQuantidade.entrySet()) {
            if (produto.getValue().get(QuantidadeEnum.QUANTIDADETOTAL.getvalor()) > produto.getKey().getQuantidadeMaxima()) {
                MensagemQuantidadeMaiorQueMaxima.dados(bebida, produto);
            } else if (produto.getValue().get(QuantidadeEnum.QUANTIDADETOTAL.getvalor()) > produto.getKey().getQuantidade() && (produto.getKey().getQuantidade() < produto.getKey().getQuantidadeMaxima())) {
                MensagemQuantidadeMaiorQueDisponivel.dados(bebida, produto);
            }
        }
    }
}
