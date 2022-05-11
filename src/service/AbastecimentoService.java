package service;


import enumerator.ColorEnum;
import model.Produto;

import java.util.List;
import java.util.Map;

import static mensagem.MensagemMaquinaAbastecida.maquinaAbastecida;

public class AbastecimentoService {

    public void abastecer(Map<Produto, List<Double>> produtoEQuantidade) {
        boolean abastecida = true;
        for (Map.Entry<Produto, List<Double>> produto : produtoEQuantidade.entrySet()){
            if (produto.getKey().getQuantidade() < 1000){
                double quantidadeAnterior = produto.getKey().getQuantidade();
                int ESTOQUEPADRAO = 1000;
                produto.getKey().setQuantidade(ESTOQUEPADRAO);
                produtoReabastecido(produto, quantidadeAnterior);
                abastecida = false;
            }

        }
        maquinaAbastecida(abastecida);

    }

    private void produtoReabastecido(Map.Entry<Produto, List<Double>> produtoEQuantidade, double quantidadeAnterior){
        System.out.println(ColorEnum.GREEN.getColorCode() + "*** Item reabastecido  *** " + ColorEnum.RESET.getColorCode()
                + "\n" + produtoEQuantidade.getKey().getDescricao()
                + "\n Quantidade atualizada: de "
                + ColorEnum.RED.getColorCode() +  quantidadeAnterior
                + ColorEnum.RESET.getColorCode() + " para " + ColorEnum.GREEN.getColorCode() + produtoEQuantidade.getKey().getQuantidadeMaxima()
                + ColorEnum.RESET.getColorCode() + "\n"
        );
    }
}
