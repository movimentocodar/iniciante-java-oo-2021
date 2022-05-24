package br.com.hugoogle.model;

import br.com.hugoogle.util.PopularProdutos;

import java.util.List;

public class Estoque {

    public List<Produto> getEstoqueListaDeProduto() {
        return PopularProdutos.getListaDeProdutos();
    }
}
