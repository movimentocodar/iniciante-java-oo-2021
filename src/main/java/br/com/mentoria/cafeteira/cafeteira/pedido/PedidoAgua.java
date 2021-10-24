package br.com.mentoria.cafeteira.cafeteira.pedido;

import br.com.mentoria.cafeteira.cafeteira.Credito;
import br.com.mentoria.cafeteira.cafeteira.ReservatorioAgua;
import br.com.mentoria.cafeteira.cafeteira.bebidas.Bebida;
import br.com.mentoria.cafeteira.cafeteira.bebidas.OpcoesBebida;

public class PedidoAgua implements TipoPedido {
	
	public boolean avaliaPedido(int pedidoBebida) {
		return pedidoBebida == 5;
	}
	
	public void executaPedido(ReservatorioAgua reservatorio) {
		new Credito().calcularTroco(OpcoesBebida.AGUA.getPreco());
		new Bebida().prepararBebida(OpcoesBebida.AGUA, reservatorio);
	}

}
