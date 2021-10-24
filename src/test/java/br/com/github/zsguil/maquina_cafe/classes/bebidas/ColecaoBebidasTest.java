package br.com.github.zsguil.maquina_cafe.classes.bebidas;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ColecaoBebidasTest {
	private ColecaoBebidas classeTeste = new ColecaoBebidas();
	
	@Test
	void deveLancarErroAoTentarModificarAColecaoDeBebidas() {
		assertThrows(UnsupportedOperationException.class, 
				() -> classeTeste.getBebidas().put(1, new Cafe()));
	}
}
