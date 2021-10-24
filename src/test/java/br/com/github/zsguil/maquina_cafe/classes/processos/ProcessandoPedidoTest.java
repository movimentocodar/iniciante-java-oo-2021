package br.com.github.zsguil.maquina_cafe.classes.processos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.github.zsguil.maquina_cafe.classes.processo.ProcessandoPedido;

class ProcessandoPedidoTest {
	private int numeroPedido;
	
	private ProcessandoPedido processandoPedido = new ProcessandoPedido();
	
	//---------------------------------------------------------------------------------------------//
	
	@Test
	public void deveLancarErroQuandoProcessarPedidoInvalido() {
		
		this.numeroPedido = 5;
		assertThrows(IllegalArgumentException.class, () ->
		this.processandoPedido.processando(numeroPedido));
		
		this.numeroPedido = 1;
		assertDoesNotThrow(() -> 
		this.processandoPedido.processando(numeroPedido));
	}
}