package br.com.mentoria.cafeteira.cafeteira;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.mentoria.cafeteira.cafeteira.pedido.PedidoAgua;
import br.com.mentoria.cafeteira.cafeteira.pedido.PedidoCafe;
import br.com.mentoria.cafeteira.cafeteira.pedido.PedidoCafeComLeite;
import br.com.mentoria.cafeteira.cafeteira.pedido.PedidoCapuccino;
import br.com.mentoria.cafeteira.cafeteira.pedido.PedidoChaDeLimao;
import br.com.mentoria.cafeteira.cafeteira.pedido.TipoPedido;

public class Pedido {
	
	private List<TipoPedido> pedidos = new ArrayList<TipoPedido>();
	
	public void realizarPedido(int pedidoBebida) {

		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecerAgua();
		
		Display display = new Display();
		
		pedidos.add(new PedidoAgua());
		pedidos.add(new PedidoCafe());
		pedidos.add(new PedidoCafeComLeite());
		pedidos.add(new PedidoCapuccino());
		pedidos.add(new PedidoChaDeLimao());
		
		pedidos.stream()
		.filter(p -> p.avaliaPedido(pedidoBebida))
		.forEach(p -> p.executaPedido(reservatorio));

	}

}
