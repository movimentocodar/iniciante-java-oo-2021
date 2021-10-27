package br.com.codar.maquinacafe;

import java.util.Scanner;

public interface Bebida {

	public default void preparaBebida(Credito credito, ReservatorioAgua reservatorio) {
		if (credito.getValorCredito() < this.getPreco()) {
			System.out.println("Valor de crédito insuficiente. Você pode inserir mais créditos agora");
			credito.adicionaCredito(credito);
		}
		reservatorio.conferindoReservatorio();
		reservatorio.utilizandoAgua(getAguaConsumida());
	}

	public default int solicitaNivelAcucar() {
		Scanner nivelAcucar = new Scanner(System.in);
		System.out.println("Como padrão, o nível de açúcar será 3, qual nível gostaria?\n " + "0, 1, 2, 3, 4, 5");

		int opcaoAcucar = nivelAcucar.nextInt();

		return opcaoAcucar;
	}

	double getPreco();

	int getAguaConsumida();
}
