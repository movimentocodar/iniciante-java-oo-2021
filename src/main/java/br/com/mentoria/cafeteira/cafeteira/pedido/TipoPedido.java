package br.com.mentoria.cafeteira.cafeteira.pedido;

import br.com.mentoria.cafeteira.cafeteira.ReservatorioAgua;

public interface TipoPedido {
	
	public boolean avaliaPedido(int pedidoBebida);
	
	public void executaPedido(ReservatorioAgua reservatorio);

}
