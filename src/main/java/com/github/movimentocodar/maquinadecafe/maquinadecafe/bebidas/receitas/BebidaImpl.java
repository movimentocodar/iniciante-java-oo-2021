package com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas;

import java.math.BigDecimal;
import java.util.List;

public interface BebidaImpl {
    String nome();
    BigDecimal preco();
    boolean isAcucaravel();
    void preparar();
}
