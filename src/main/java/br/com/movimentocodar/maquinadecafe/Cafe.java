package br.com.movimentocodar.maquinadecafe;

import java.math.BigDecimal;

public class Cafe extends Bebida{
    Receita Receita = new Receita(true, true);
    BigDecimal Preco = new BigDecimal("0.50");

    public Cafe() {
        super(0, "Café");
        Receita.setQuantidadeDePoCafe(10);
        this.preco = Preco;
        this.receita = Receita;
    }
}
