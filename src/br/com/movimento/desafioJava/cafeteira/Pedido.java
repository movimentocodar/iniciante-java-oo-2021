package br.com.movimento.desafioJava.cafeteira;

import java.util.Scanner;
import br.com.movimento.desafioJava.cafeteira.bebidas.*;

public class Pedido {
	
	Display imprimir = new Display();
	
	public void realizarPedido(Credito credito, ReservatorioAgua reservatorio) {
		
		Scanner opcaoBebida = new Scanner(System.in);
		imprimir.imprime("Entre com o número da bebida desejada:\n"
				+ "1 - Café - R$ 0.50\n"
				+ "2 - Café com leite - R$ 1.00 \n"
				+ "3 - Capuccino - R$ 1.50\n"
				+ "4 - Chá de limão - R$ 1.00\n"
				+ "5 - Água quente - free");
	    
	    int pedidoBebidaUsuario = opcaoBebida.nextInt();
	    
	    switch (pedidoBebidaUsuario) {
	    case 1:
	    	Bebida cafe = new Cafe(pedidoBebidaUsuario);
	    	cafe.prepararBebida(credito, reservatorio);
	    	credito.calcularTroco(cafe.getPreco(), credito);
	    	break;
		case 2:
			Bebida cafeComLeite = new CafeComLeite(pedidoBebidaUsuario);
	    	cafeComLeite.prepararBebida(credito, reservatorio);
	    	credito.calcularTroco(cafeComLeite.getPreco(), credito);
	    	break;
		case 3:
			Bebida capuccino = new Capuccino(pedidoBebidaUsuario);
			capuccino.prepararBebida(credito, reservatorio);
			credito.calcularTroco(capuccino.getPreco(), credito);
			break;
		case 4:
			Bebida cha = new Cha(pedidoBebidaUsuario);
			cha.prepararBebida(credito, reservatorio);
			credito.calcularTroco(cha.getPreco(), credito);
			break;
		case 5:
			Bebida agua = new Agua(pedidoBebidaUsuario);
			agua.prepararBebida(credito, reservatorio);
			break;
	    }
	}

}
