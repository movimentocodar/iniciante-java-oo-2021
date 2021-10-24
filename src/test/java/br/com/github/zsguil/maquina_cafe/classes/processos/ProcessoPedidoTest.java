package br.com.github.zsguil.maquina_cafe.classes.processos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.github.zsguil.maquina_cafe.classes.processo.ProcessoPedido;

class ProcessoPedidoTest {
	private int numeroPedido;
	
	private ProcessoPedido processoPedido = new ProcessoPedido();
	
	//---------------------------------------------------------------------------------------------//
	
	@Test
	void deveLancarErroQuandoProcessarPedidoInvalido() {
		
		this.numeroPedido = 5;
		assertThrows(IllegalArgumentException.class, () ->
		this.processoPedido.processar(numeroPedido));
		
		this.numeroPedido = 1;
		assertDoesNotThrow(() -> 
		this.processoPedido.processar(numeroPedido));
	}
}