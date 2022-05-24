package br.com.hugoogle.pagamento;

import br.com.hugoogle.controller.VendaController;
import br.com.hugoogle.enumerator.ColorEnum;
import br.com.hugoogle.interfaces.IPagamento;
import br.com.hugoogle.util.InputScanner;

public class CartaoDeDebito implements IPagamento {
    private final InputScanner inputScanner = new InputScanner();
    private final VendaController vendaController = new VendaController();


    @Override
    public String efetuarPagamento(double valor) {
        return "Pagamento efetuado com de Debito no valor de R$" + valor;
    }

    @Override
    public double coletarDetalheDoPagamento() {
        return inserirSenha();
    }

    public double inserirSenha() {
        System.out.print(ColorEnum.RESET.getColorCode() + "*** Dados do cartao ***");
        int senha;
        do {
            System.out.print(ColorEnum.YELLOW.getColorCode() + "\nDigite sua senha: " + ColorEnum.RESET.getColorCode());
            senha = inputScanner.entrada();
            System.out.println((senha != 8437) ? ColorEnum.RED.getColorCode()  + "\nSenha invalida"  :  "" );

        } while (senha != 8437);
        return vendaController.obterValorTotalAPagar();
    }


}
