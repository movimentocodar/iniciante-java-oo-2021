package br.com.movimento.desafioJava.cafeteira;

import java.util.Scanner;


public class Cafeteira {

	public static void main(String[] args) {
		
		Display imprimir = new Display();
	    
		imprimir.imprime("Bem-vindo a Cafeteira!!\n");
		
		Pedido pedido = new Pedido();
		Credito credito = new Credito();
		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecerAgua();
		int inicio;
		
		do {
			Scanner opcaoInicial = new Scanner(System.in);
			imprimir.imprime("\nEscolha a opção desejada:\n"
		    		+ "1 - Adicionar Crédito\n"
		    		+ "2 - Realizar Pedido\n"
		    		+ "0 - Finalizar");
			
			inicio = opcaoInicial.nextInt();
		
		    switch(inicio) {
		    case 1:
		    	credito.adicionarCredito(credito);
		    	break;
		    case 2:
		    	pedido.realizarPedido(credito, reservatorio);
		    	break;
		    }
		    
		}while(inicio == 1 || inicio == 2);
		
		imprimir.imprime("Máquina finalizada");

	}
}
