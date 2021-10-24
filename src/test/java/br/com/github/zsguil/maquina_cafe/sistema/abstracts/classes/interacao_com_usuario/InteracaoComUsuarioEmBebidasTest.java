package br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.github.zsguil.maquina_cafe.classes.bebidas.Cafe;

class InteracaoComUsuarioEmBebidasTest {

	@Test
	public void deveRetornarOTamanhoCorretoDoDivisor() {
		assertEquals(20, InteracaoComUsuarioEmBebidas.divisorNomePreco(4).length());
	}

}
