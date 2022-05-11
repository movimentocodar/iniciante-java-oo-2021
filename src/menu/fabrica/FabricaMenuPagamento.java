package menu.fabrica;

import interfaces.IPagamento;

import pagamento.CartaoDeDebito;
import pagamento.Dinheiro;
import pagamento.Pagamento;

import util.InputScanner;


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

