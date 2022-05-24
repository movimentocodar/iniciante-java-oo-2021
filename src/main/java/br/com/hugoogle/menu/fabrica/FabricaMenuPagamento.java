package br.com.hugoogle.menu.fabrica;

import br.com.hugoogle.interfaces.IPagamento;

import br.com.hugoogle.pagamento.CartaoDeDebito;
import br.com.hugoogle.pagamento.Dinheiro;
import br.com.hugoogle.pagamento.Pagamento;

import br.com.hugoogle.util.InputScanner;


public class FabricaMenuPagamento {
    private static final InputScanner fechar = new InputScanner();

    private static final int DINHEIRO = 1;
    private static final int DEBITO = 2;
    private static final int SAIR = 3;

   private static final Pagamento pagamento = new Pagamento();

    public static void getMenu(int opcaoMenu) {
        switch (opcaoMenu) {
            case DINHEIRO -> pagamento(new Dinheiro());
            case DEBITO -> pagamento(new CartaoDeDebito());
            case SAIR -> fechar.sair();
            default -> {
            }
        }
    }

    private static void pagamento(IPagamento tipoDoPagamento) {
        pagamento.realizarPagamento(tipoDoPagamento);
    }


}

