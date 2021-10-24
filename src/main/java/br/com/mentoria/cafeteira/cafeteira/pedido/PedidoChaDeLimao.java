package br.com.mentoria.cafeteira.cafeteira.pedido;

import br.com.mentoria.cafeteira.cafeteira.Credito;
import br.com.mentoria.cafeteira.cafeteira.ReservatorioAgua;
import br.com.mentoria.cafeteira.cafeteira.bebidas.Bebida;
import br.com.mentoria.cafeteira.cafeteira.bebidas.OpcoesBebida;

public class PedidoChaDeLimao implements TipoPedido {
	
	public boolean avaliaPedido(int pedidoBebida) {
		return pedidoBebida == 4;
	}
	
	public void executaPedido(ReservatorioAgua reservatorio) {
		new Credito().calcularTroco(OpcoesBebida.CHA_DE_LIMAO.getPreco());
		new Bebida().prepararBebida(OpcoesBebida.CHA_DE_LIMAO, reservatorio);
	}

}
