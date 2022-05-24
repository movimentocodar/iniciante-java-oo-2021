package br.com.hugoogle.model;

public class Ingrediente {

    private final int produtoKey;
    private final int quantidade;

    public Ingrediente(int produtoKey, int quantidade) {
        this.produtoKey = produtoKey;
        this.quantidade = quantidade;
    }


    public int getProdutoKey() {
        return produtoKey;
    }

    public int getQuantidade() {
        return quantidade;
    }


}
