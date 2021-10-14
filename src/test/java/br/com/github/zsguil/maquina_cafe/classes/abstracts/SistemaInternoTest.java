package br.com.github.zsguil.maquina_cafe.classes.abstracts;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.github.zsguil.maquina_cafe.classes.ProcessandoPedido;
import br.com.github.zsguil.maquina_cafe.classes.bebidas.Cafe;
import br.com.zsguil.maquina_cafe.exceptions.EscolhaErradaException;

class SistemaInternoTest {
	private ProcessandoPedido pp = new ProcessandoPedido();

	@Test
	public void checaSeRetornoDeMapE_Unmodifiable() {
		assertThrows(UnsupportedOperationException.class, () -> pp.getBebidas().put(1, new Cafe()));
	}

	@Test
	public void checaLancamentoDe_ExceptionPraEscolhasIlegaisDoUsuario() {
		assertThrows(EscolhaErradaException.class, () -> pp.validaEscolha(0, 5, 6));
		assertDoesNotThrow(() -> pp.validaEscolha(0, 5, 1));
	}

	@Test
	public void deveRetornarFalseCasoFalteAgua_ERetornarTrueCasoContrario() {
		assertTrue(pp.verificaAgua(50));
		assertFalse(pp.verificaAgua(40));
	}	



}