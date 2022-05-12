package pagamento;

import controller.PagamentoController;
import controller.VendaController;
import enumerator.ColorEnum;
import interfaces.IPagamento;

public class Pagamento {
    private final PagamentoController pagamentoController = new PagamentoController();
    private final VendaController vendaController = new VendaController();
    double valorInformado;

    public void realizarPagamento(IPagamento pagamento) {
        double valorTotalPago = 0;
        do {

            valorInformado = pagamentoController.coletarDetalheDoPagamento(pagamento);
            valorTotalPago += valorInformado;
            pagamentoController.efetuarPagamento(valorInformado, pagamento);

            totalPago(valorTotalPago);

        } while (vendaController.obterValorTotalAPagar() > valorTotalPago);
        dadosDePagamento(ColorEnum.GREEN.getColorCode()  + "Troco: R$", Math.abs(vendaController.obterValorTotalAPagar() - valorTotalPago),  "\n");
    }

    private void totalPago(double valorTotalPago) {
        dadosDePagamento(ColorEnum.BLUE.getColorCode() +"Total a pagar : R$", vendaController.obterValorTotalAPagar(), "\n" );
        dadosDePagamento(ColorEnum.RESET.getColorCode() +  "Total pago : R$", valorTotalPago, "");
        dadosDePagamento(ColorEnum.RED.getColorCode()+ "Total restante : R$", Math.abs(vendaController.obterValorTotalAPagar() - valorTotalPago), "");

    }

    private void dadosDePagamento(String descricao, double vendaController, String linha) {
        System.out.println(descricao + vendaController + linha);
    }


}
