package br.com.movimento.desafioJava.cafeteira;

import java.util.Scanner;

public class Credito{
	
	private double valorTotalCreditos;
	
	public void adicionarCredito(Credito credito) {
		Scanner opcaoCredito = new Scanner(System.in);
		new Display().imprime("Entre com a forma de pagamento desejada:\n"
				+ "1 - Notas\n"
				+ "2 - Débito");
		
		int opcaoInserida = opcaoCredito.nextInt();
		
		if(opcaoInserida == 1) {
			Scanner opcaoNotas = new Scanner(System.in);
			new Display().imprime("Entre com o número da nota desejada:\n"
					+ "2 - R$ 2,00\n"
					+ "5 - R$ 5,00\n"
					+ "10 - R$ 10,00\n"
					+ "20 - R$ 20,00\n"
					+ "50 - R$ 50,00\n"
					+ "100 - R$ 100,00");
			
			int notaInserida = opcaoNotas.nextInt();
			double valorCredito = credito.getValorTotalCreditos();
			valorCredito += notaInserida;
			credito.setValorTotalCreditos(valorCredito);
			
		} else if(opcaoInserida > 0) {
			
			Scanner opcaoDebito = new Scanner(System.in);
			new Display().imprime("Entre com o valor de crédito desejado:\n");
			double valorInserido = opcaoDebito.nextInt();
			double valorCredito = credito.getValorTotalCreditos();
			valorCredito += valorInserido;
			credito.setValorTotalCreditos(valorCredito);
			
		}
		new Display().imprime("Valor total de créditos: " + credito.getValorTotalCreditos());

	}
	
	public void calcularTroco(double valorProduto, Credito credito) {
		 
		double valorCredito = credito.getValorTotalCreditos();
		valorCredito -= valorProduto;
		credito.setValorTotalCreditos(valorCredito);
		new Display().imprime("\nDevolvendo o troco de: R$ " + valorCredito);
		valorCredito = 0;
		credito.setValorTotalCreditos(valorCredito);		
	}

	public double getValorTotalCreditos() {
		return valorTotalCreditos;
	}

	public void setValorTotalCreditos(double valorTotalCreditos) {
		this.valorTotalCreditos = valorTotalCreditos;
	}	

}
