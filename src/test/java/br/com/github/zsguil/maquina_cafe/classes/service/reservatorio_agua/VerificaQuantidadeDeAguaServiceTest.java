package br.com.github.zsguil.maquina_cafe.classes.service.reservatorio_agua;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VerificaQuantidadeDeAguaServiceTest {

	@Test
	void deveRetornarFalseSeQuantidadeDeAguaForMenorQue50() {
		assertFalse(new VerificaQuantidadeDeAguaService().verificar(20));
		assertTrue(new VerificaQuantidadeDeAguaService().verificar(50));
	}

}
