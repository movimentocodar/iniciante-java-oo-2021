package br.com.codar.maquinacafe;

import java.util.Scanner;

public class Pedido {

	public void realizarPedido(Credito credito, ReservatorioAgua reservatorio) {
		Scanner opcaoBebida = new Scanner(System.in);
		System.out.println(
				"Fa�a seu pedido entre as op��es:\n" + "1 - Caf� por R$0.50\n" + "2 - Caf� Com Leite por R$1.00\n"
						+ "3 - Capuccino por R$1.50\n" + "4 - Ch� De Lim�o por R$1.00\n" + "5 - �gua quente GRATUITO");

		int pedidoBebidaUsuario = opcaoBebida.nextInt();
		System.out.println("Obrigado, seu pedido ser�: " + pedidoBebidaUsuario);

		switch (pedidoBebidaUsuario) {
		case 1:
			Cafe cafe = new Cafe(pedidoBebidaUsuario);
			cafe.preparaBebida(credito, reservatorio);
			credito.calculaTroco(cafe.getPreco(), credito);
			break;

		case 2:
			CafeComLeite cafeComLeite = new CafeComLeite(pedidoBebidaUsuario);
			cafeComLeite.preparaBebida(credito, reservatorio);
			credito.calculaTroco(cafeComLeite.getPreco(), credito);
			break;

		case 3:
			Capuccino capuccino = new Capuccino(pedidoBebidaUsuario);
			capuccino.preparaBebida(credito, reservatorio);
			credito.calculaTroco(capuccino.getPreco(), credito);
			break;

		case 4:
			ChaDeLimao chaDeLimao = new ChaDeLimao(pedidoBebidaUsuario);
			chaDeLimao.preparaBebida(credito, reservatorio);
			credito.calculaTroco(chaDeLimao.getPreco(), credito);
			break;

		case 5:
			AguaQuente aguaQuente = new AguaQuente(pedidoBebidaUsuario);
			aguaQuente.preparaBebida(credito, reservatorio);
			credito.calculaTroco(aguaQuente.getPreco(), credito);
			break;

		default:
			System.out.println("Entre com uma das op��es dispon�veis");
		}
	}

}
