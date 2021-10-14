package br.com.codar.maquinacafe;

import java.util.Scanner;

public class AguaQuente extends Bebida {
	
	private double preco = 0;
	
	public AguaQuente(int pedidoBebidaUsuario) {
		super(pedidoBebidaUsuario);
	}

	public double getPreco() {
		return preco;
	}
	
	public void preparaBebida(Credito credito, ReservatorioAgua reservatorio) {
		System.out.println("Água Quente é gratuito, obrigado pelo pedido.");
		}

	public int solicitaNivelAcucar() {
		return 0;
	}
}
