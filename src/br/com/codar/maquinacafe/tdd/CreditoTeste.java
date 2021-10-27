package br.com.codar.maquinacafe.tdd;

import static org.junit.Assert.assertThrows;

import java.io.InputStream;

import org.junit.jupiter.api.Test;

import br.com.codar.maquinacafe.Credito;

public class CreditoTeste {

	@Test
	public void deveriaAdicionarCreditoEDevolverTroco() {
		Credito input = new Credito();

		InputStream valorCredito = input.adicionaCredito(input);
		
		input.adicionaCredito(input);
		input.calculaTroco(0, input);
		
	}

	@Test
	public void deveriaChamarExceptionQuandoCreditoAdicionadoIgualOuMenorAZero() {
		Credito input = new Credito();

		assertThrows(IllegalArgumentException.class, () -> input.adicionaCredito(input));

	}

}