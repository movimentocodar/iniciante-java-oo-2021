package service;

import model.Color;
import util.InputScanner;

import java.text.DecimalFormat;

public class PagamentoService {


    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static boolean pagamentoEfetuado;
    private static double valorPago;
    private static double valorTotalPago = 0;
    private static double troco;
    private static int SENHA = 8437;

    private static final InputScanner input = new InputScanner() {
        @Override
        public double entradaDouble() {
            return super.entradaDouble();
        }
    };

    private static boolean confirmarPagamento(double valorTotal) {
        int opcao;
        do {

            System.out.println(Color.BLUE.getColorCode() + "\n*** Por favor realize o pagamento ***\n" +
                    Color.RESET.getColorCode() + "Valor Total: R$" + df.format(valorTotal));

            System.out.println(Color.YELLOW.getColorCode()
                    + "\nSelecione uma opcao:"
                    + Color.RESET.getColorCode()
                    + "\n(1) Cartao de Debito"
                    + "\n(2) Dinheiro");
            System.out.print(Color.YELLOW.getColorCode() + "\nOpcao n: " + Color.RESET.getColorCode());

            opcao = input.entrada();
            System.out.println((opcao < 1 || opcao > 2) ? Color.RED.getColorCode() + "\nOPCAO INVALIDA!" + Color.RESET.getColorCode() : "");

        } while (opcao < 1 || opcao > 2 && valorTotal > 0);
        {

            if (opcao == 1) {
                pagamentoEfetuado = cartaoDeDebito();
            }

            if (opcao == 2) {
                pagamentoEfetuado = dinheiro(valorTotal);
            }

        }


        return pagamentoEfetuado;

    }

    private static boolean cartaoDeDebito() {
        System.out.println(Color.BLUE.getColorCode() + "*** Por favor insira o cartao ***" + Color.RESET.getColorCode());

        int verificaSenha;

        do {
            System.out.print(Color.YELLOW.getColorCode() + "informe sua senha: " + Color.RESET.getColorCode());
            verificaSenha = input.entrada();
            System.out.println((verificaSenha != SENHA) ? Color.RED.getColorCode() + "\nSENHA INVALIDA!\n" + Color.RESET.getColorCode() : "");


        } while (verificaSenha != SENHA);
        {
            System.out.println(Color.GREEN.getColorCode() + "Pagamento aprovado!\n" + Color.RESET.getColorCode());
            return true;
        }
    }


    public static boolean dinheiro(double valorTotal) {
        System.out.print(Color.RESET.getColorCode() + "*** Adicionar Credito ***");
        boolean isNotaValida;
        do {
            System.out.print(Color.YELLOW.getColorCode() + "\nInforme o valor a pagar: " + Color.RESET.getColorCode());

            valorPago = input.entradaDouble();
            isNotaValida = !verificarNotaValida(valorPago);

            if (!isNotaValida) calcularValorPagoETroco(valorTotal);


        } while ((valorTotal > valorTotalPago) || isNotaValida);

        if (valorTotalPago > valorTotal) {
            System.out.println(Color.RESET.getColorCode() + "\nTroco: R$" + Math.abs(troco));
        }
        System.out.println(Color.GREEN.getColorCode() + "\nPagamento realizado!\n" + Color.RESET.getColorCode());

        return true;

    }

    private static void calcularValorPagoETroco(double valorTotal) {
        valorTotalPago = valorTotalPago + valorPago;
        troco = valorTotal - valorTotalPago;
        System.out.println(Color.BLUE.getColorCode() + "\nValor total: R$" + valorTotal + Color.RESET.getColorCode());


        if (valorTotalPago < valorTotal) {
            System.out.println(Color.RED.getColorCode() + "Total recebido: R$" + valorTotalPago + Color.RESET.getColorCode());

        } else {
            System.out.println(Color.BLUE.getColorCode() + "Total recebido: R$" + valorTotalPago + Color.RESET.getColorCode());

        }
        System.out.println(Color.BLUE.getColorCode() + "Total restante: R$" + (troco < 0 ? 0 : troco) + Color.RESET.getColorCode());
    }


    public boolean realizarPagamento(double valorTotal) {
        return  confirmarPagamento(valorTotal);
    }

    public static boolean verificarNotaValida(double nota) {

        if (nota != 2 && nota != 5 && nota != 10 && nota != 20 && nota != 50 && nota != 100 && nota != 200) {
            System.out.println(Color.RED.getColorCode() +"\nNota invalida!, por favor insira uma nota valida: ");
            System.out.println(Color.RESET.getColorCode() + "R$2,00, R$5,00, R$10,00, R$20,00, R$50,00, R$100,00 ou R$200,00");
            return false;
        }

        return true;

    }
}
