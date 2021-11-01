package br.com.movimentocodar.maquinadecafe;

import java.math.BigDecimal;

public class Bebida {
    private int id;
    private String nome;
    Receita receita;
    protected BigDecimal preco;

    public Bebida(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Bebida() {
    }

    @Override
    public String toString() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

}
