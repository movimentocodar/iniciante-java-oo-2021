package br.com.codar.maquinacafe;

import java.util.Scanner;

public class Cafe implements Bebida {

	private double preco;
	private int aguaConsumida;

	public Cafe(int pedidoBebidaUsuario) {
	}

	public void preparaBebida(Credito credito, ReservatorioAgua reservatorio) {
	}

	public int solicitaNivelAcucar() {
		return solicitaNivelAcucar();
	}

	@Override
	public double getPreco() {
		return 0.50;
	}

	@Override
	public int getAguaConsumida() {
		return 50;
	}

}