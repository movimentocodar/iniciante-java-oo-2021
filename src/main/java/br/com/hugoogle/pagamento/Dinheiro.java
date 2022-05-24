package br.com.hugoogle.pagamento;

import br.com.hugoogle.interfaces.IPagamento;

public class Dinheiro  implements IPagamento {

    private final AdicionarCredito adicionarCredito = new AdicionarCredito();

    @Override
    public String efetuarPagamento(double valor) {
        return "Pagamento efetuado com dinheiro no valor de R$" + valor;
    }

    @Override
    public double coletarDetalheDoPagamento() {
        return adicionarCredito.inserirValor();

    }



}
