package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class VerificacoesDePrecoServiceTest {
	private VerificacoesDePrecoService classeTeste = new VerificacoesDePrecoService();

	@Test
	public void deveRetornarFalseCasoPrecoSejaMaiorQueDinheiro_ERetornarTrueCasoContrario() {
		assertTrue(this.classeTeste.verificaCompra(BigDecimal.ONE, BigDecimal.ONE));
		assertFalse(this.classeTeste.verificaCompra(BigDecimal.ONE, BigDecimal.TEN));
	}
	
	@Test
	public void verificaOPrecoDeCadaBebida() {
		assertEquals(new BigDecimal("0.50"), this.classeTeste.verificaPreco(1));
		assertEquals(new BigDecimal("1.00"), this.classeTeste.verificaPreco(2));
		assertEquals(new BigDecimal("1.50"), this.classeTeste.verificaPreco(3));
		assertEquals(new BigDecimal("1.00"), this.classeTeste.verificaPreco(4));
	}

}
