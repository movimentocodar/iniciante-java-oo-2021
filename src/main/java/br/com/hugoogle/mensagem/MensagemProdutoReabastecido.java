package br.com.hugoogle.mensagem;

import br.com.hugoogle.enumerator.ColorEnum;

public class MensagemProdutoReabastecido {

    public void listaDeProdutos(String decricao, double quantidadeAnterior, double quantidaedMaxima){
        System.out.println(ColorEnum.GREEN.getColorCode() + "*** Item reabastecido  *** " + ColorEnum.RESET.getColorCode()
                + "\n" + decricao
                + "\n Quantidade atualizada: de "
                + ColorEnum.RED.getColorCode() +  quantidadeAnterior
                + ColorEnum.RESET.getColorCode() + " para " + ColorEnum.GREEN.getColorCode() + quantidaedMaxima
                + ColorEnum.RESET.getColorCode() + "\n"
        );
    }
}
