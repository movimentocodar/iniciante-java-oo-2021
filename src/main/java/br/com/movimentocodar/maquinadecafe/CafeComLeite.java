package br.com.movimentocodar.maquinadecafe;

import java.math.BigDecimal;

public class CafeComLeite extends Bebida {
    Receita Receita = new Receita(true, true);
    BigDecimal Preco = new BigDecimal("1.00");

    public CafeComLeite() {
        super(1, "Café com leite");
        Receita.setQuantidadeDePoCafe(5);
        Receita.setQuantidadeDeLeite(10);
        this.preco = Preco;
        this.receita = Receita;
    }
}
