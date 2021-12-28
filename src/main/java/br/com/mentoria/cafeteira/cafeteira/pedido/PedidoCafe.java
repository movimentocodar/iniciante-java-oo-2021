package br.com.mentoria.cafeteira.cafeteira.pedido;

import br.com.mentoria.cafeteira.cafeteira.Credito;
import br.com.mentoria.cafeteira.cafeteira.ReservatorioAgua;
import br.com.mentoria.cafeteira.cafeteira.bebidas.Bebida;
import br.com.mentoria.cafeteira.cafeteira.bebidas.OpcoesBebida;

public class PedidoCafe implements TipoPedido {
	
	public boolean avaliaPedido(int pedidoBebida) {
		return pedidoBebida == 1;
	}
	
	public void executaPedido(ReservatorioAgua reservatorio) {
		new Credito().calcularTroco(OpcoesBebida.CAFE.getPreco());
		new Bebida().prepararBebida(OpcoesBebida.CAFE, reservatorio);
	}

}
