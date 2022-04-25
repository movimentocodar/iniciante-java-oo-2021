package service;

import model.Estoque;
import model.Pedido;

import java.util.List;

public class MovimentoService {

    public  void atualizarEstoque(List<Pedido> pedidos, int quantidadeDeAcucar){

        pedidos.forEach(p -> Estoque.atualizarEstoque(p.getProduto().getCodigo(), p.getQuantidade()));

        Estoque.atualizarEstoque(8, quantidadeDeAcucar);
    }
}
