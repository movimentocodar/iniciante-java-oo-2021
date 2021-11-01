package br.com.movimentocodar.maquinadecafe;

import java.math.BigDecimal;

public class ChaDeLimao extends Bebida {
    Receita Receita = new Receita(true, true);
    BigDecimal Preco = new BigDecimal("1.00");

    public ChaDeLimao() {
        super(3, "Chá de limão");
        Receita.setQuantidadeDeLimao(10);
        this.preco = Preco;
        this.receita = Receita;
    }
}
