package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.github.zsguil.maquina_cafe.sistema.exceptions.DinheiroInsuficienteException;

class DebitoServiceTest {
	private DebitoService debito = new DebitoService();

	@Test
	public void deveLancarErroNoCasoDeValorSerMenorQueOPreco_EDoContrarioNaoLancarNada() {
		assertThrows(DinheiroInsuficienteException.class,
				() -> debito.usaSaldo(new BigDecimal("0.50"), BigDecimal.ONE));
		
		assertDoesNotThrow(() -> debito.usaSaldo(BigDecimal.ONE, BigDecimal.ONE));
	}
}
