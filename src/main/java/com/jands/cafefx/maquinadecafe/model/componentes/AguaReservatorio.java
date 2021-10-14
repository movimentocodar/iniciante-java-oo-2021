package com.jands.cafefx.maquinadecafe.model.componentes;

public class AguaReservatorio {
    private CapacidadeReservatorio capacidadeReservatorio;
    private double aguaDoReservatorio = 0;

    public double getAguaDoReservatorio() {
        return aguaDoReservatorio;
    }

    AguaReservatorio(CapacidadeReservatorio capacidadeReservatorio) {
        this.capacidadeReservatorio = capacidadeReservatorio;
    }

    public void abastecer(double valorDeAguaParaAbastecer) {
        if (naoDaPraAbastecer(valorDeAguaParaAbastecer)) {
            throw new IllegalArgumentException("Valor Invalido!");
        }
        this.aguaDoReservatorio += valorDeAguaParaAbastecer;
    }

    public void usarAgua(double qnt) {
        if (naoDaPraUsarAgua(qnt)) {
            throw new IllegalArgumentException("Valor Invalido");
        }
        this.aguaDoReservatorio -= qnt;
    }

    public void esvaziarAgua() {
        this.aguaDoReservatorio = 0;
    }

    private boolean naoDaPraAbastecer(double valorDaQuantidaDeAguaQueQuerAbastecer) {
        double quantidadeQueAindaDaPraAbastecer =
                capacidadeReservatorio.getCapacidade() - getAguaDoReservatorio() - valorDaQuantidaDeAguaQueQuerAbastecer;

        if (quantidadeQueAindaDaPraAbastecer < 0 || valorDaQuantidaDeAguaQueQuerAbastecer <= 0) {
            return true;
        }
        return false;
    }

    private boolean naoDaPraUsarAgua(double qnt) {
        double quantidadeQueAindaDaPraUsar = getAguaDoReservatorio();
        if (quantidadeQueAindaDaPraUsar < qnt || qnt <= 0) {
            return true;
        }
        return false;
    }
}
