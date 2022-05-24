package mensagem;

import enumerator.ColorEnum;
import enumerator.QuantidadeEnum;
import menu.fabrica.Bebida;
import menu.submenu.SubMenuCompra;
import menu.submenu.SubMenuReabastecer;
import model.Produto;

import java.util.List;
import java.util.Map;

public class MensagemQuantidadeMaiorQueMaxima {

    public void dados (Bebida bebida, Map.Entry<Produto, List<Double>> produto){
        System.out.println("O Produto " + bebida.getClass().getName().replace("bebidas.", "") + " nao possui quantidade suficiente:");
        System.out.println(ColorEnum.GREEN.getColorCode() + "Quantidade disponivel: " + Math.abs(produto.getKey().getQuantidade() / produto.getValue().get(QuantidadeEnum.QUANTIDADEPADRAO.getvalor()))  + " copos");
        System.out.println(ColorEnum.BLUE.getColorCode() + "Quantidade solicitada: " + Math.abs(produto.getValue().get(QuantidadeEnum.QUANTIDADETOTAL.getvalor()) / produto.getValue().get(QuantidadeEnum.QUANTIDADEPADRAO.getvalor()))  + " copos");
        System.out.println(ColorEnum.RED.getColorCode() + "Quantidade maxima permitida: " + Math.abs(produto.getKey().getQuantidadeMaxima() / produto.getValue().get(QuantidadeEnum.QUANTIDADEPADRAO.getvalor()) ) + "\n");

        if(produto.getKey().getQuantidade() < produto.getKey().getQuantidadeMaxima()){
           new SubMenuReabastecer();
        }
        new SubMenuCompra();
    }
}
