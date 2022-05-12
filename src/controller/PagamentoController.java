package controller;


import interfaces.IPagamento;
public class PagamentoController {

    public void efetuarPagamento(double valor, IPagamento pagamento){
        pagamento.efetuarPagamento(valor);
    }

    public double coletarDetalheDoPagamento(IPagamento pagamento) {
       return pagamento.coletarDetalheDoPagamento();
    }
}
