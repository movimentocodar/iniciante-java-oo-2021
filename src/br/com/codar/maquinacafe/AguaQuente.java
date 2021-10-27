package br.com.codar.maquinacafe;

import java.util.Scanner;

public class AguaQuente implements Bebida {

	private double preco;
	private int aguaConsumida;

	public AguaQuente(int pedidoBebidaUsuario) {
	}

	public void preparaBebida(Credito credito, ReservatorioAgua reservatorio) {
		System.out.println("Água Quente é gratuito, obrigado pelo pedido.");
	}

	public int solicitaNivelAcucar() {
		return 0;
	}

	@Override
	public double getPreco() {
		return 0;
	}

	@Override
	public int getAguaConsumida() {
		return 50;
	}
}