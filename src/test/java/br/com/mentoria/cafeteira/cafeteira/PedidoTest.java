package br.com.mentoria.cafeteira.cafeteira;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.mentoria.cafeteira.cafeteira.bebidas.Bebida;
import br.com.mentoria.cafeteira.cafeteira.bebidas.OpcoesBebida;

public class PedidoTest {

	@Test
	public void deveriaPrepararCafe() {
		Credito credito = new Credito();
	    double valorCredito = credito.adicionarCredito(2.0);
	    
		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecerAgua();
		
		assertEquals(1, new Bebida().prepararBebida(OpcoesBebida.CAFE, reservatorio));
	}

	@Test
	public void deveriaPrepararCafeComLeite() {
		Credito credito = new Credito();
	    double valorCredito = credito.adicionarCredito(2.0);
	    
		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecerAgua();
		
		assertEquals(2, new Bebida().prepararBebida(OpcoesBebida.CAFE_COM_LEITE, reservatorio));
	}

	@Test
	public void deveriaPrepararCapuccino() {
		Credito credito = new Credito();
	    double valorCredito = credito.adicionarCredito(2.0);
	    
		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecerAgua();
		
		assertEquals(3, new Bebida().prepararBebida(OpcoesBebida.CAPUCCINO, reservatorio));
	}

	@Test
	public void deveriaPrepararChaDeLimao() {
		Credito credito = new Credito();
	    double valorCredito = credito.adicionarCredito(2.0);
	    
		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecerAgua();
		
		assertEquals(4, new Bebida().prepararBebida(OpcoesBebida.CHA_DE_LIMAO, reservatorio));
	}

	@Test
	public void deveriaPrepararAgua() {
		Credito credito = new Credito();
	    double valorCredito = credito.adicionarCredito(2.0);
	    
		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecerAgua();
		
		assertEquals(5, new Bebida().prepararBebida(OpcoesBebida.AGUA, reservatorio));
	}
	
	@Test
	public void naoDeveriaPrepararBebida() {
		Credito credito = new Credito();
	    double valorCredito = credito.adicionarCredito(2.0);
	    
		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecerAgua();
		
		assertThrows(IllegalArgumentException.class, () -> new Pedido().realizarPedido(0));
	}

}
