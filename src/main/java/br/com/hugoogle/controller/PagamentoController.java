package br.com.hugoogle.controller;


import br.com.hugoogle.interfaces.IPagamento;
public class PagamentoController {

    public void efetuarPagamento(double valor, IPagamento pagamento){
        pagamento.efetuarPagamento(valor);
    }

    public double coletarDetalheDoPagamento(IPagamento pagamento) {
       return pagamento.coletarDetalheDoPagamento();
    }
}
