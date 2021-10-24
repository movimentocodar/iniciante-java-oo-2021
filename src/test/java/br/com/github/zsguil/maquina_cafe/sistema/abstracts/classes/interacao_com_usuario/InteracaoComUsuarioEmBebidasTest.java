package br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InteracaoComUsuarioEmBebidasTest {

	@Test
	public void deveRetornarOTamanhoCorretoDoDivisor() {
		int caracteresDoNome = 4;
		int tamanhoEsperadoDoDivisor = 24 - caracteresDoNome;
		
		assertEquals(tamanhoEsperadoDoDivisor, 
				InteracaoComUsuarioEmBebidas.gerarDivisorNomePreco(caracteresDoNome).length());
	}

}
