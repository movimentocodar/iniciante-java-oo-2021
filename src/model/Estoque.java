package model;

import java.util.List;

public class Estoque {

    public List<Produto> getEstoqueListaDeProduto() {
        return Produto.getListaDeProdutos();
    }
}
