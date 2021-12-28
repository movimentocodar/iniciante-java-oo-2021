package com.github.movimentocodar.maquinadecafe.maquinadecafe.creditos;

import java.math.BigDecimal;

public class GerenciadorCredito {
    private BigDecimal creditos = BigDecimal.ZERO;

    public void adicionarCredito(BigDecimal valorCredito, FormaDePagamento formaDePagamento) {
        if (!valorIsValid(valorCredito) || !formaDePagamento.isValid(valorCredito))
            throw new IllegalArgumentException("valorCredito não pode ser <=0");
        creditos = creditos.add(valorCredito);
    }

    public void sacarCredito(BigDecimal valorCredito) {
        if (!valorIsValid(valorCredito))
            throw new IllegalArgumentException("valorCredito não pode ser <=0");
        creditos = creditos.subtract(valorCredito);
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    private boolean valorIsValid(BigDecimal valorCredito){
        return valorCredito.compareTo(BigDecimal.ZERO) > 0;
    }
}
