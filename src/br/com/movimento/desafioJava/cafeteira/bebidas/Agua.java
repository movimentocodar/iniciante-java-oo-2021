package br.com.movimento.desafioJava.cafeteira.bebidas;

import br.com.movimento.desafioJava.cafeteira.Credito;
import br.com.movimento.desafioJava.cafeteira.Display;
import br.com.movimento.desafioJava.cafeteira.ReservatorioAgua;

public class Agua extends Bebida{
	
	private double preco = 0;
	private int usoAgua = 50;

	public Agua(int opcao) {
		super(opcao);
	}

	@Override
	public void prepararBebida(Credito credito, ReservatorioAgua reservatorio) {
		if(credito.getValorTotalCreditos() < this.preco) {
			new Display().imprime("Valor de créditos insuficiente. Insira créditos.");
			credito.adicionarCredito(credito);
			
		}
		
		reservatorio.confereNivelDeAgua();
		reservatorio.utilizarAgua(usoAgua);
		new Display().imprime("Adicionando: Água...\nFervendo água...\nÁgua pronta.");
	}


	@Override
	public double getPreco() {
		return 0;
	}

	@Override
	public int solicitarNivelDeAcucar() {
		return 0;
	}

}
