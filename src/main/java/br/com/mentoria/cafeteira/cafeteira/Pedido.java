package br.com.mentoria.cafeteira.cafeteira;

import br.com.mentoria.cafeteira.cafeteira.bebidas.Bebida;
import br.com.mentoria.cafeteira.cafeteira.bebidas.OpcoesBebida;

public class Pedido {

	public void realizarPedido(int pedidoBebida) {
		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecerAgua();
		Credito credito = new Credito();
		
		switch (pedidoBebida) {
			case 1:
				credito.calcularTroco(OpcoesBebida.CAFE.getPreco());
				new Bebida().prepararBebida(OpcoesBebida.CAFE, reservatorio);
				break;
			case 2:
				credito.calcularTroco(OpcoesBebida.CAFE_COM_LEITE.getPreco());
				new Bebida().prepararBebida(OpcoesBebida.CAFE_COM_LEITE, reservatorio);
				break;
			case 3:
				credito.calcularTroco(OpcoesBebida.CAPUCCINO.getPreco());
				new Bebida().prepararBebida(OpcoesBebida.CAPUCCINO, reservatorio);
				break;
			case 4:
				credito.calcularTroco(OpcoesBebida.CHA_DE_LIMAO.getPreco());
				new Bebida().prepararBebida(OpcoesBebida.CHA_DE_LIMAO, reservatorio);
				break;
			case 5:
				credito.calcularTroco(OpcoesBebida.AGUA.getPreco());
				new Bebida().prepararBebida(OpcoesBebida.AGUA, reservatorio);
				break;
		}
	}

}
