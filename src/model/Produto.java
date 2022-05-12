package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Produto {

    private final int produtoKey;

    private final String descricao;

    private double quantidade;

    private final double quantidadeMaxima;

    private final String embalagem;

    private static final List<Produto> listaDeProdutos = new ArrayList<>();

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

    public static void criarProduto() {

        Produto agua = new Produto(1, "Agua", 500, 1000, "ml");
        Produto poDeCafe = new Produto(2, "Po de Cafe", 1000, 1000, "g");
        Produto filtro = new Produto(3, "Filtro", 1000, 1000, "un");
        Produto leiteEmPo = new Produto(4, "Leite em Po", 1000, 1000, "g");
        Produto chocolateEmPo = new Produto(5, "Chocolate em Po", 1000, 1000, "g");
        Produto chaDeLimao = new Produto(6, "Cha em po Limao", 1000, 1000, "g");
        Produto copo = new Produto(7, "Copo", 1000, 1000, "un");
        Produto acucar = new Produto(8, "Acucar", 1000, 1000, "g");
        listaDeProdutos.add(agua);
        listaDeProdutos.add(poDeCafe);
        listaDeProdutos.add(filtro);
        listaDeProdutos.add(leiteEmPo);
        listaDeProdutos.add(chocolateEmPo);
        listaDeProdutos.add(chaDeLimao);
        listaDeProdutos.add(copo);
        listaDeProdutos.add(acucar);
    }


    public static List<Produto> getListaDeProdutos() {
        return Collections.unmodifiableList(listaDeProdutos);
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
