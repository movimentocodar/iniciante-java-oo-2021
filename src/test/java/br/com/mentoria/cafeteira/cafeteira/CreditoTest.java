package br.com.mentoria.cafeteira.cafeteira;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.mentoria.cafeteira.cafeteira.bebidas.Bebida;
import br.com.mentoria.cafeteira.cafeteira.bebidas.OpcoesBebida;

class CreditoTest {

	@Test
	  public void deveriaAdicionarCredito() {
	    Credito credito = new Credito();
	    double valorCredito = credito.adicionarCredito(2.0);
	    
	    assertEquals(2.0, valorCredito);
	  }
	
	@Test
	  public void naoDeveriaAdicionarCreditoMenorDoQueZero() {
	    Credito credito = new Credito();
			
		assertThrows(IllegalArgumentException.class, () ->
			credito.adicionarCredito(-2.0));
	  }
	
	
	@Test
	  public void deveriaCalcularTroco() {
		
		Credito credito = new Credito();
		credito.adicionarCredito(2.0);
			
		double troco = credito.calcularTroco(OpcoesBebida.CAFE_COM_LEITE.getPreco());
		
	    assertEquals(1.0, troco);
	  }
	
	@Test
	  public void deveriaCalcularTrocoInsuficiente() {
		
		Credito credito = new Credito();
		credito.adicionarCredito(0.0);
			
		assertThrows(IllegalArgumentException.class, () ->
			credito.calcularTroco(OpcoesBebida.CAFE_COM_LEITE.getPreco()));

	  }
	
	@Test
	  public void deveriaCalcularTrocoBebidaGratuita() {
		
		Credito credito = new Credito();
		credito.adicionarCredito(2.0);
			
		double troco = credito.calcularTroco(OpcoesBebida.AGUA.getPreco());
		
	    assertEquals(2.0, troco);
	  }

}
