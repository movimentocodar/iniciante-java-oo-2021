package br.com.codar.maquinacafe;
import java.util.Scanner;

public class TesteFinal { // Realize o teste do c�digo por aqui, obrigado!
	
	public static void main(String[] args) {
		
		Pedido pedido = new Pedido();
		Credito credito = new Credito();
		int iniciarEscolha;
		
			Scanner pedidoInicial = new Scanner (System.in);
			System.out.println("Ol�, escolha uma das op��es abaixo\n"
								+ "1 - Adicionar cr�ditos\n"
								+ "2 - Realizar pedido");
			
			iniciarEscolha = pedidoInicial.nextInt();
			System.out.println("Voc� escolheu: " + iniciarEscolha);
			
			switch(iniciarEscolha) {
			case 1:
				credito.adicionaCredito(credito);
			case 2:
				pedido.realizarPedido(credito, null);
				break;
			}
			
			Scanner outroPedido = new Scanner(System.in);
			System.out.println("Gostaria de fazer mais um pedido?\n"
					+ "1 - Sim\n"
					+ "2 - N�o");
			
			iniciarEscolha = outroPedido.nextInt();
			System.out.println("Voc� escolheu: " + iniciarEscolha);
			
			switch(iniciarEscolha) {
			case 1:
				credito.adicionaCredito(credito);
				pedido.realizarPedido(credito, null);
				break;
			case 2:
				System.out.println("Obrigado e at� mais.");
				break;
			}
		}
	}

// Desenvolvido por Gabriel Trudes Melo