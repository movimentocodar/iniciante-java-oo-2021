package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class AdministraCreditoServiceTest {

	@Test
	void deveRetornarTrueSomenteQuandoCreditoForMaiorOuIgual() {
		
		assertTrue(new AdministradorDeCreditoService()
				.verificarSeCreditoESobrejacente(BigDecimal.ZERO));
		
		assertFalse(new AdministradorDeCreditoService()
				.verificarSeCreditoESobrejacente(BigDecimal.ONE));
	}

}
