package br.com.mentoria.cafeteira.cafeteira.pedido;

import br.com.mentoria.cafeteira.cafeteira.Credito;
import br.com.mentoria.cafeteira.cafeteira.ReservatorioAgua;
import br.com.mentoria.cafeteira.cafeteira.bebidas.Bebida;
import br.com.mentoria.cafeteira.cafeteira.bebidas.OpcoesBebida;

public class PedidoCafeComLeite implements TipoPedido{
	
	public boolean avaliaPedido(int pedidoBebida) {
		return pedidoBebida == 2;
	}
	
	public void executaPedido(ReservatorioAgua reservatorio) {
		new Credito().calcularTroco(OpcoesBebida.CAFE_COM_LEITE.getPreco());
		new Bebida().prepararBebida(OpcoesBebida.CAFE_COM_LEITE, reservatorio);
	}
	
}
