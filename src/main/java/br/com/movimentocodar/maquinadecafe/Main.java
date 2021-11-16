package br.com.movimentocodar.maquinadecafe;

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
    public static void main(String[] args) throws IOException {
        ReservatorioDeAgua ReservatorioDeAgua = new ReservatorioDeAgua();
        Cupons cupons = new Cupons();
        inicializarMaquina(ReservatorioDeAgua, cupons);
    }

    static void inicializarMaquina(ReservatorioDeAgua ReservatorioDeAgua, Cupons cupons) throws IOException {
        MaquinaDeCafe MaquinaDeCafe = new MaquinaDeCafe(ReservatorioDeAgua);

        if (MaquinaDeCafe.ReservatorioDeAgua.reservatorioDeAguaVazio())  {
            CafeScanner ReporAgua = new CafeScanner("Por favor, digite 'repor' para repor quantidade de água", "repor");
            ReporAgua.pedirConfirmacaoUsuario();
            MaquinaDeCafe.ReservatorioDeAgua.completarReservatorioDeAgua();
        }

        MaquinaDeCafe.menu();
        Bebida BebidaEscolhida = MaquinaDeCafe.selecionarBebida();
        Pagamento pagamento = new Pagamento(BebidaEscolhida.getPreco());

        if(pagamento.cortesia()){
            System.out.println("A bebida será de graça.");

            MaquinaDeCafe.liberarBebida();
        }else {
            if(pagamento.executarCobranca(cupons)) {
                MaquinaDeCafe.determinarNivelDeAcucar();
                MaquinaDeCafe.liberarBebida();
            }
        }

        finalizacao(ReservatorioDeAgua, cupons);
    }

    private static void finalizacao(ReservatorioDeAgua ReservatorioDeAgua, Cupons cupons) throws IOException{
        CafeScanner finalizar = new CafeScanner("Digite 'sair' para sair ou 'iniciar' para comprar outra bebida.", "iniciar");
        finalizar.pedirConfirmacaoUsuario();
        inicializarMaquina(ReservatorioDeAgua, cupons);
    }

}
