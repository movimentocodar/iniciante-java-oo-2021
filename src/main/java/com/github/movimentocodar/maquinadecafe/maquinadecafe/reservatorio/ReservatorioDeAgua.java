package com.github.movimentocodar.maquinadecafe.maquinadecafe.reservatorio;

public class ReservatorioDeAgua {
    private CapacidadeReservatorio capacidade = new CapacidadeReservatorio();
    private AguaReservatorio aguaReservatorio = new AguaReservatorio(capacidade);

    public ReservatorioDeAgua() {
    }

    public ReservatorioDeAgua(double capacidade) {
        this.capacidade.setCapacidade(capacidade);
    }

    public ReservatorioDeAgua(double capacidade, double litrosDeAguaIniciais) {
        this.aguaReservatorio.esvaziarAgua();
        this.capacidade.setCapacidade(capacidade);
        this.aguaReservatorio.abastecer(litrosDeAguaIniciais);
    }

    public void abastecerReservatorio(double valor) {
        aguaReservatorio.abastecer(valor);
    }

    public double getAguaDoReservatorio() {
        return aguaReservatorio.getAguaDoReservatorio();
    }

    public double getCapacidadeDoReservatorio(){
        return capacidade.getCapacidade();
    }

    public void mudarCapacidadeDoReservatorio(double novaCapacidade){
        aguaReservatorio.esvaziarAgua();
        capacidade.setCapacidade(novaCapacidade);
    }

    public void usarAgua(double qnt) {
        aguaReservatorio.usarAgua(qnt);
    }


}
