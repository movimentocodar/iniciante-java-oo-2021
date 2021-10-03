package br.com.movimento.desafioJava.cafeteira.bebidas;

import br.com.movimento.desafioJava.cafeteira.Credito;
import br.com.movimento.desafioJava.cafeteira.Display;
import br.com.movimento.desafioJava.cafeteira.ReservatorioAgua;

public abstract class Bebida{
	
	private int numeroOpcaoBebida;
		
	public Bebida(int opcao) {
		if(opcao <= 0) {
			new Display().imprime("Entre com uma opção de bebida válida.");
			return;
		}
		this.numeroOpcaoBebida = opcao;
	}
	
	public abstract void prepararBebida(Credito credito, ReservatorioAgua reservatorio);
	public abstract int solicitarNivelDeAcucar();
	public abstract double getPreco();
	
	public int getNumeroDaOpcao() {
		return numeroOpcaoBebida;
	}
		
}
