package br.com.codar.maquinacafe;

import java.util.Scanner;

public class Credito {
	
	private double valorCredito;
	

	double getValorCredito() {
		return valorCredito;
	}
	
	public void setValorCredito(double valorCredito) {
		this.valorCredito++;
	}
	
	public void adicionaCredito(Credito credito) {
		Scanner opcaoCredito = new Scanner(System.in);
		System.out.println("Entre com o valor do crédito disponível:\n"
							+ "5 - 5 créditos\n"
							+ "10 - 10 créditos\n"
							+ "20 - 20 créditos\n"
							+ "50 - 50 créditos\n"
							+ "100 - 100 créditos\n"
							+ "200 - 200 créditos");
		
		int creditoInserido = opcaoCredito.nextInt();
		
		double valorCredito = credito.getValorCredito();
		valorCredito += creditoInserido;
		credito.setValorCredito(valorCredito);
		
	}
	
	public void calculaTroco(double valorBebida, Credito credito) {
		double valorCredito = credito.getValorCredito();
		valorCredito -= valorBebida;
		credito.setValorCredito(valorCredito);
		
		Scanner troco = new Scanner(System.in);
		System.out.println("Troco em créditos: " + valorCredito);
		
		valorCredito = 0;
		credito.setValorCredito(valorCredito);
	}

}
