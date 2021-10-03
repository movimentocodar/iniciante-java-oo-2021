package br.com.movimento.desafioJava.cafeteira.bebidas;

import java.util.Scanner;
import br.com.movimento.desafioJava.cafeteira.ReservatorioAgua;
import br.com.movimento.desafioJava.cafeteira.Credito;
import br.com.movimento.desafioJava.cafeteira.Display;

public class Cafe extends Bebida{
	
	private double preco = 0.5;
	private int usoAgua = 50;
	
	public Cafe(int numeroDaOpcao) {
		super(numeroDaOpcao);
	}
	
	public void prepararBebida(Credito credito, ReservatorioAgua reservatorio) {
		
		if(credito.getValorTotalCreditos() < this.preco) {
			new Display().imprime("Valor de créditos insuficiente. Insira créditos.");
			credito.adicionarCredito(credito);
			
		}
		
		reservatorio.confereNivelDeAgua();		
		int acucar = solicitarNivelDeAcucar();
		reservatorio.utilizarAgua(usoAgua);
		
		new Display().imprime("Adicionando água quente...\n"
				+ "\nAdicionando café em pó + filtro + nível de açúcar de: " 
		+ acucar + "\nCafé pronto.");
		
	}
	
	public int solicitarNivelDeAcucar() {
		Scanner opcaoAcucar = new Scanner(System.in);
		new Display().imprime("\nDeseja alterar o nível(3) padrão de açucar?\nEntre com o número\n"
	    		+ "1 - 2 - (3) - 4 - 5");

		int acucar = opcaoAcucar.nextInt();
	    return acucar;	 
	}

	public double getPreco() {
		return preco;
	}
	
}
