package br.com.github.zsguil.maquina_cafe.classes.bebidas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.github.zsguil.maquina_cafe.classes.processo.Menu;

class ColecaoBebidasTest {
	private ColecaoBebidas classeTeste = new ColecaoBebidas();
	
	@Test
	public void deveLancarErroAoTentarModificarAColecaoDeBebidas() {
		assertThrows(UnsupportedOperationException.class, 
				() -> classeTeste.getBebidas().put(1, new Cafe()));
	}
}
