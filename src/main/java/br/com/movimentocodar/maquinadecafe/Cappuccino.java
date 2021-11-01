package br.com.movimentocodar.maquinadecafe;

import java.math.BigDecimal;

public class Cappuccino  extends Bebida {
    Receita Receita = new Receita(true, true);
    BigDecimal Preco = new BigDecimal("1.50");


    public Cappuccino() {
        super(2, "Cappuccino");
        Receita.setQuantidadeDePoCafe(5);
        Receita.setQuantidadeDeLeite(5);
        Receita.setQuantidadeDeChocolate(5);
        this.preco = Preco;
        this.receita = Receita;
    }
}
