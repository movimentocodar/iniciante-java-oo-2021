package mensagem;

import enumerator.ColorEnum;
import enumerator.QuantidadeEnum;
import menu.fabrica.Bebida;
import menu.submenu.SubMenuCompra;
import menu.submenu.SubMenuReabastecer;
import model.Produto;

import java.util.List;
import java.util.Map;

public class MensagemQuantidadeMaiorQueDisponivel {

    public void dados(Bebida bebida, Map.Entry<Produto, List<Double>> produto) {
        System.out.println("O Produto " + bebida.getClass().getName().substring(8) + " nao possui quantidade suficiente:");
        System.out.println(ColorEnum.GREEN.getColorCode() + "Quantidade disponivel: " + Math.abs(produto.getKey().getQuantidade() / produto.getValue().get(QuantidadeEnum.QUANTIDADEPADRAO.getvalor())) + " copos");
        System.out.println(ColorEnum.BLUE.getColorCode() + "Quantidade solicitada: " + Math.abs(produto.getValue().get(QuantidadeEnum.QUANTIDADETOTAL.getvalor()) / produto.getValue().get(QuantidadeEnum.QUANTIDADEPADRAO.getvalor())) + " copos");
        System.out.println(ColorEnum.RED.getColorCode() + "Quantidade maxima permitida: " + Math.abs(produto.getKey().getQuantidadeMaxima() / produto.getValue().get(QuantidadeEnum.QUANTIDADEPADRAO.getvalor())));

        System.out.println(ColorEnum.RESET.getColorCode() + "Reabastecer o produto: " + produto.getKey().getDescricao());
        System.out.println(ColorEnum.GREEN.getColorCode() + "Quantidade disponivel: " + produto.getKey().getQuantidade() + produto.getKey().getEmbalagem());
        System.out.println(ColorEnum.RED.getColorCode() + "Quantidade Maxima: " + produto.getKey().getQuantidadeMaxima() + produto.getKey().getEmbalagem() + "\n");
        new SubMenuReabastecer();
        new SubMenuCompra();

    }
}
