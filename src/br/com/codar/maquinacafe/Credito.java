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
		System.out.println("Entre com o valor do cr�dito dispon�vel:\n"
							+ "5 - 5 cr�ditos\n"
							+ "10 - 10 cr�ditos\n"
							+ "20 - 20 cr�ditos\n"
							+ "50 - 50 cr�ditos\n"
							+ "100 - 100 cr�ditos\n"
							+ "200 - 200 cr�ditos");
		
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
		System.out.println("Troco em cr�ditos: " + valorCredito);
		
		valorCredito = 0;
		credito.setValorCredito(valorCredito);
	}

}
