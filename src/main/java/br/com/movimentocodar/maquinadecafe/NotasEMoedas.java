package br.com.movimentocodar.maquinadecafe;

import java.math.BigDecimal;

public enum NotasEMoedas {
    NOTA_DE_200(0,"Nota de R$200", BigDecimal.valueOf(200.00), false, 0),
    NOTA_DE_100(1,"Nota de R$100", BigDecimal.valueOf(100.00),false, 0),
    NOTA_DE_50(2,"Nota de R$50", BigDecimal.valueOf(50.00),false,0),
    NOTA_DE_20(3,"Nota de R$20", BigDecimal.valueOf(20.00),false,0),
    NOTA_DE_10(4,"Nota de R$10", BigDecimal.valueOf(10.00),false,0),
    NOTA_DE_5(5,"Nota de R$5", BigDecimal.valueOf(5.00),false,0),
    NOTA_DE_2(6,"Nota de R$2", BigDecimal.valueOf(2.00),false,0),
    NOTA_DE_1(7,"Nota de R$1", BigDecimal.valueOf(1.00),false,0),
    MOEDA_DE_1(8,"Moeda de R$1", BigDecimal.valueOf(1.00),true,0),
    MOEDA_DE_050(9,"Moeda de R$0,50",  BigDecimal.valueOf(0.50),true,0),
    MOEDA_DE_025(10,"Moeda de R$0,25",  BigDecimal.valueOf(0.25),true,0),
    MOEDA_DE_010(11,"Moeda de R$0,10",  BigDecimal.valueOf(0.10),true,0),
    MOEDA_DE_005(12,"Moeda de R$0,05",  BigDecimal.valueOf(0.05),true,0),
    MOEDA_DE_001(13,"Moeda de R$0,01",  BigDecimal.valueOf(0.01),true,0);

    int quantidade;
    boolean moeda;
    int id;
    String nome;
    BigDecimal valor;

    NotasEMoedas(int id, String nome, BigDecimal valor, boolean moeda, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.moeda = moeda;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isMoeda() {
        return moeda;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void imprimir(){
        System.out.println(this.id + " - " + this.nome);
    }
}
