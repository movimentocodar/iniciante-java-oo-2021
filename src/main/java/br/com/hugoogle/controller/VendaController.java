package controller;

import service.VendaService;

public class VendaController {

    private final VendaService vendaService = new VendaService();

    public void calcularValorAPagar(double valor, int quantidade) {
        vendaService.calcularValorAPagar(valor, quantidade);
    }

    public double obterValorTotalAPagar() {
        return vendaService.getValorTotalApagar();
    }

}
