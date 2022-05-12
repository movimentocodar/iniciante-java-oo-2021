package service;

import interfaces.IVenda;

public class VendaService implements IVenda {

    static double valorTortalAPagar;

    public void calcularValorAPagar(double valor, int quantidade) {
        valorTortalAPagar = valor * quantidade;
    }

    public double getValorTotalApagar() {
        return this.valorTortalAPagar;
    }
}

