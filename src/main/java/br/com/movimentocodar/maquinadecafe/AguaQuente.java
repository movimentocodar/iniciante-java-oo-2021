package br.com.movimentocodar.maquinadecafe;

import java.math.BigDecimal;

public class AguaQuente extends Bebida {
    Receita Receita = new Receita(true, false);
    BigDecimal Preco = BigDecimal.ZERO;

    public AguaQuente() {
        super(4, "Água quente");
        this.preco = Preco;
        this.receita = Receita;
    }
}
