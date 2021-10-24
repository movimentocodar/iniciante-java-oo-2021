package br.com.github.zsguil.maquina_cafe.classes.service.interacao_com_usuario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.github.zsguil.maquina_cafe.sistema.exceptions.EscolhaErradaException;

class ValidadorDeEscolhasServiceTest {
	private ValidadorDeEscolhasService classeTeste = new ValidadorDeEscolhasService();
	
	@Test
	void deveLancarErroPraEscolhasIlegaisDoUsuario() {
		assertThrows(EscolhaErradaException.class, 
				() -> this.classeTeste.validarEscolha(0, 5, 6));
		assertDoesNotThrow(() -> this.classeTeste.validarEscolha(0, 5, 2));
	}

}
