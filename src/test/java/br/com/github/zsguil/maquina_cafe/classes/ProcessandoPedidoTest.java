package br.com.github.zsguil.maquina_cafe.classes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ProcessandoPedidoTest {
	private int numeroPedido;
	
	private ProcessandoPedido processandoPedido = new ProcessandoPedido();
	
	//---------------------------------------------------------------------------------------------//
	
	@Test
	public void verificaSeExceptionELancada_CasoAlguemPasseCincoComoArgumento() {
		
		this.numeroPedido = 5;
		assertThrows(IllegalArgumentException.class, () ->
		this.processandoPedido.processando(numeroPedido));
		
		this.numeroPedido = 1;
		assertDoesNotThrow(() -> 
		this.processandoPedido.processando(numeroPedido));
	}
}