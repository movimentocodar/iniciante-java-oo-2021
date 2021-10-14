package br.com.codar.maquinacafe;

import java.util.Scanner;

public class Capuccino extends Bebida {

	private double preco = 1.50;
	private int aguaConsumida = 50;

	public Capuccino(int pedidoBebidaUsuario) {
		super(pedidoBebidaUsuario);
	}

	public double getPreco() {
		return preco;
	}

	public void preparaBebida(Credito credito, ReservatorioAgua reservatorio) {
		if (credito.getValorCredito() < this.preco) {
			System.out.println("Valor de crédito insuficiente. Você pode inserir mais créditos agora");
			credito.adicionaCredito(credito);
		}
		reservatorio.conferindoReservatorio();
		reservatorio.utilizandoAgua(aguaConsumida);
	}

	public int solicitaNivelAcucar() {
		Scanner nivelAcucar = new Scanner(System.in);
		System.out.println("Como padrão, o nível de açúcar será 3, qual nível gostaria?\n " + "0, 1, 2, 3, 4, 5");

		int opcaoAcucar = nivelAcucar.nextInt();

		return opcaoAcucar;
	}
}
