package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido{

    private final int quantidade;
    private final Produto produto;
    private  static  final List<Pedido> listaPedido = new ArrayList<>();

    public Pedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;

    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "quantidade=" + quantidade +
                ", produto=" + produto +
                '}';
    }

    public static void addPedido(Produto produto, int quantidade) {
        Pedido pedido = new Pedido (produto, quantidade);
        listaPedido.add(pedido);
    }

    public static List<Pedido> getListaDePedidos() {
        return listaPedido;
    }

    public static void resetListaPedida(){
        listaPedido.clear();
    }

}
