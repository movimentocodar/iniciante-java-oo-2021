package br.com.codar.maquinacafe;

import java.util.Scanner;

public class CafeComLeite implements Bebida {

	private double preco;
	private int aguaConsumida;

	public CafeComLeite(int pedidoBebidaUsuario) {
	}

	public void preparaBebida(Credito credito, ReservatorioAgua reservatorio) {
	}

	public int solicitaNivelAcucar() {
		return solicitaNivelAcucar();
	}

	@Override
	public double getPreco() {
		return 1.00;
	}

	@Override
	public int getAguaConsumida() {
		return 50;
	}
}