package br.com.codar.maquinacafe.tdd;

import static org.junit.Assert.assertThrows;

import java.io.InputStream;

import org.junit.jupiter.api.Test;

import br.com.codar.maquinacafe.Credito;

public class CreditoTest {
	
	@Test
	public void deveriaAdicionarCredito() {
		Credito input = new Credito();
		
		InputStream valorCredito = input.adicionaCredito(input);
		
	}
	
	@Test
	public void deveriaChamarExceptionQuandoCreditoAdicionadoIgualOuMenorAZero() {
		Credito input = new Credito();
		
		assertThrows(IllegalArgumentException.class, () -> input.adicionaCredito(input));
	}

}
