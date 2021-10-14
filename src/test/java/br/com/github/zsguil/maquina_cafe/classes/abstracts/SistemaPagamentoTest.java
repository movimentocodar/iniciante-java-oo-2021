package br.com.github.zsguil.maquina_cafe.classes.abstracts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.github.zsguil.maquina_cafe.classes.ProcessandoPedido;
import br.com.github.zsguil.maquina_cafe.classes.bebidas.Cafe;

class SistemaPagamentoTest {
	private ProcessandoPedido pp;
	private Map<Integer, Bebida> mapBebidas = new LinkedHashMap<>();
	
	@BeforeEach
	public void beforeEach() {
		mapBebidas.put(1, new Cafe());
		this.pp = new ProcessandoPedido();
	}
	
	@Test
	public void aoSimularInsercaoDeDinheiro_DeveRetornarTrue() {
		pp.armazenaBebidas(mapBebidas);
		assertTrue(pp.insereDinheiro(1, 2));
	}
	
	@Test
	public void aoSimularTransacaoComDebito_DeveRetornarTrue() {
		pp.armazenaBebidas(mapBebidas);
		assertTrue(pp.usaDebito(1, new BigDecimal("0.50")));
	}
}