package br.com.mentoria.cafeteira.cafeteira;

import java.util.Scanner;

public class Menu {
	
	Display display = new Display();
	
	public void menuInicial() {		
		int inicio;
		
		do {
			Scanner opcaoInicial = new Scanner(System.in);
			display.imprime("\nEscolha a opção desejada:\n"
		    		+ "1 - Adicionar Crédito\n"
		    		+ "2 - Realizar Pedido\n"
		    		+ "0 - Finalizar");
			
			inicio = opcaoInicial.nextInt();
		
		    switch(inicio) {
		    case 1:
		    	menuCredito();
		    	break;
		    case 2:
		    	menuPedido();
		    	break;
		    }
		    
		}while(inicio == 1 || inicio == 2);
	}
	
	public void menuCredito() {
		
		Scanner opcaoCredito = new Scanner(System.in);
		display.imprime("Entre com a forma de pagamento desejada:\n"
				+ "1 - Notas\n"
				+ "2 - Débito");
		
		int opcaoInserida = opcaoCredito.nextInt();
		double totalCredito;
		
		if(opcaoInserida == 1) {
			Scanner notaInserida = new Scanner(System.in);
			new Display().imprime("Entre com o n�mero da nota desejada:\n"
					+ "2 - R$ 2,00\n"
					+ "5 - R$ 5,00\n"
					+ "10 - R$ 10,00\n"
					+ "20 - R$ 20,00\n"
					+ "50 - R$ 50,00\n"
					+ "100 - R$ 100,00");
			double nota = notaInserida.nextInt();
			totalCredito = new Credito().adicionarCredito(nota);
			
		} else {
			
			Scanner opcaoDebito = new Scanner(System.in);
			display.imprime("Entre com o valor de crédito desejado:\n");
			double valorInserido = opcaoDebito.nextInt();
			
			totalCredito = new Credito().adicionarCredito(valorInserido);
		}
		
		display.imprime("Valor total de créditos: " + totalCredito);
		
	}
	
	public void menuPedido() {
			
		Scanner opcaoBebida = new Scanner(System.in);
		display.imprime("Entre com o n�mero da bebida desejada:\n"
				+ "1 - Café - R$ 0.50\n"
				+ "2 - Café com leite - R$ 1.00 \n"
				+ "3 - Capuccino - R$ 1.50\n"
				+ "4 - Chá de limão - R$ 1.00\n"
				+ "5 - Água quente - FREE");

	    new Pedido().realizarPedido(opcaoBebida.nextInt());
	}
	
}
