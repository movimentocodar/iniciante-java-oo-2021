package com.github.movimentocodar.maquinadecafe.maquinadecafe.creditos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum FormaDePagamento {
    CEDULA {
        @Override
        boolean isValid(BigDecimal valorDoPagamento) {
            List<BigDecimal> notasValidas;
            notasValidas = Arrays.asList(
                    new BigDecimal("2"),
                    new BigDecimal("5"),
                    new BigDecimal("10"),
                    new BigDecimal("20"),
                    new BigDecimal("50"),
                    new BigDecimal("100"),
                    new BigDecimal("200"));
            if (!notasValidas.contains(valorDoPagamento)){
                throw new IllegalArgumentException("Forma de Pagamento Invalida!");
            }
            return true;
        }

        @Override
        public String toString() {
            return "Cédula";
        }
    },
    DEBITO {
        @Override
        boolean isValid(BigDecimal valorDoPagamento) {
            return true;
        }

        @Override
        public String toString() {
            return "Débito";
        }
    };

    abstract boolean isValid(BigDecimal valorDoPagamento);

    @Override
    public abstract String toString();
}
