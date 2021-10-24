package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DinheiroServiceTest {
	private DinheiroService dinheiroService = new DinheiroService();
	
	@Test
	public void deveRetornarTrueParaCedulasValidas_ERetornarFalseParaCedulasInvalidas() {
		assertTrue(this.dinheiroService.validaCedula(2));
		assertFalse(this.dinheiroService.validaCedula(1));
	}
}
