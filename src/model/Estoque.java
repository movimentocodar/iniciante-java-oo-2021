package model;

import util.PopularProdutos;

import java.util.List;

public class Estoque {

    public List<Produto> getEstoqueListaDeProduto() {
        return PopularProdutos.getListaDeProdutos();
    }
}
