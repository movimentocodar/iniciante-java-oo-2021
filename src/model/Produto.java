package model;

public class Produto {

    private final int produtoKey;

    private final String descricao;

    private double quantidade;

    private final double quantidadeMaxima;

    private final String embalagem;


    public Produto(int produtoKey, String descricao, double quantidade, double quantidadeMaxima, String embalagem) {
        this.produtoKey = produtoKey;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.quantidadeMaxima = quantidadeMaxima;
        this.embalagem = embalagem;
    }

    public int getProdutoKey() {
        return produtoKey;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getQuantidadeMaxima() {
        return quantidadeMaxima;

    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
