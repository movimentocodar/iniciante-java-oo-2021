package br.com.movimentocodar.maquinadecafe;

import com.fasterxml.jackson.core.JsonParseException;

import java.io.IOException;

/**
 * Máquina de café que vende e processa diversas bebidas como
 * café, café com leite, cappuccino, chá de limão e água quente.
 * Aceita dinheiro, cartão e cupom como forma de pagamento.
 *
 * @author Lilian Ferreira
 * @version 1.0
 * @since 2021-09-06
 * @link https://github.com/lilianjaf/iniciante-java-oo-2021
 */

public class Main {
    public static void main(String[] args) throws JsonParseException, IOException {
        ReservatorioDeAgua ReservatorioDeAgua = new ReservatorioDeAgua();
        inicializarMaquina(ReservatorioDeAgua);
    }

    static void inicializarMaquina(ReservatorioDeAgua ReservatorioDeAgua) throws JsonParseException, IOException {
        MaquinaDeCafe MaquinaDeCafe = new MaquinaDeCafe(ReservatorioDeAgua);

        if (MaquinaDeCafe.ReservatorioDeAgua.reservatorioDeAguaVazio())  {
            CafeScanner ReporAgua = new CafeScanner("Por favor, digite 'repor' para repor quantidade de água", "repor");
            ReporAgua.pedirConfirmacaoUsuario();
            MaquinaDeCafe.ReservatorioDeAgua.completarReservatorioDeAgua();
        }

        MaquinaDeCafe.Menu();
        Bebida BebidaEscolhida = MaquinaDeCafe.selecionarBebida();
        Pagamento Pagamento = new Pagamento(BebidaEscolhida.getPreco());

        if(Pagamento.Cortesia()){
            System.out.println("A bebida será de graça.");

            MaquinaDeCafe.liberarBebida();
        }else{
            System.out.println("O total é de " + Pagamento.moedaEmReais() + ".");

            Boolean sucesso;
            do {
                CafeScanner selecionarMetodoDePagamento = new CafeScanner("Digite 1 para pagamento em dinheiro, 2 para pagamento em cartão de débito e 3 para utilizar cupom.");
                int MetodoDePagamento = selecionarMetodoDePagamento.pedirMetodoDePagamentoAoUsuario();
                sucesso = Pagamento.executarCobranca(MetodoDePagamento);
            }while(!sucesso);

            MaquinaDeCafe.determinarNivelDeAcucar();
            MaquinaDeCafe.liberarBebida();
        }

        finalizacao(ReservatorioDeAgua);
    }

    private static void finalizacao(ReservatorioDeAgua ReservatorioDeAgua) throws JsonParseException, IOException{
        System.out.println("Retire a bebida e obrigado por utilizar a máquina de café.");
        CafeScanner finalizar = new CafeScanner("Digite 'sair' para sair ou 'iniciar' para comprar outra bebida.", "iniciar");
        finalizar.pedirConfirmacaoUsuario();
        inicializarMaquina(ReservatorioDeAgua);
    }

}
