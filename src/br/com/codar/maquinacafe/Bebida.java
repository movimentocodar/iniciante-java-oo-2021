package br.com.codar.maquinacafe;

import java.util.Scanner;

public interface Bebida {

	public default void preparaBebida(Credito credito, ReservatorioAgua reservatorio) {
		if (credito.getValorCredito() < this.getPreco()) {
			System.out.println("Valor de cr�dito insuficiente. Voc� pode inserir mais cr�ditos agora");
			credito.adicionaCredito(credito);
		}
		reservatorio.conferindoReservatorio();
		reservatorio.utilizandoAgua(getAguaConsumida());
	}

	public default int solicitaNivelAcucar() {
		Scanner nivelAcucar = new Scanner(System.in);
		System.out.println("Como padr�o, o n�vel de a��car ser� 3, qual n�vel gostaria?\n " + "0, 1, 2, 3, 4, 5");

		int opcaoAcucar = nivelAcucar.nextInt();

		return opcaoAcucar;
	}

	double getPreco();

	int getAguaConsumida();
}
