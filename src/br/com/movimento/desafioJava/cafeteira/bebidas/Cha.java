package br.com.movimento.desafioJava.cafeteira.bebidas;

import java.util.Scanner;

import br.com.movimento.desafioJava.cafeteira.Credito;
import br.com.movimento.desafioJava.cafeteira.Display;
import br.com.movimento.desafioJava.cafeteira.ReservatorioAgua;

public class Cha extends Bebida{
	
	private double preco = 1.0;
	private int usoAgua = 50;
	
	public Cha(int numeroDaOpcao) {
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
		
		new Display().imprime("\nAdicionando: chá em pó + filtro + nível de açúcar de: " 
				+ acucar + "\nChá de limão pronto.");
	}
	
	public int solicitarNivelDeAcucar() {
			
		Scanner opcaoAcucar = new Scanner(System.in);
		new Display().imprime("\nDeseja alterar o nível(3) padrão de açucar?Entre com o número\n"
	    		+ "1 - 2 - (3) - 4 - 5");
		int acucar = opcaoAcucar.nextInt();
	    return acucar;	    
	}

	public double getPreco() {
		return preco;
	}
	
}
