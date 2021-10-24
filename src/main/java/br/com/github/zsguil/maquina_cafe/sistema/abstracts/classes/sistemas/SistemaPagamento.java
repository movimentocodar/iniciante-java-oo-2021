package br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento.AdministraCreditoService;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento.DebitoService;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento.DinheiroService;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento.VerificacoesDePrecoService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public abstract class SistemaPagamento extends InteracaoComUsuario {
	private final static AdministraCreditoService administraCredito = new AdministraCreditoService();
	
	public static AdministraCreditoService administraCredito() {
		return SistemaPagamento.administraCredito;
	}
	
	public boolean verificaSePodeComprar(BigDecimal dinheiro, BigDecimal preco) {
		return new VerificacoesDePrecoService().verificaCompra(dinheiro, preco);
	}
	
	public BigDecimal determinaPreco(int numero) {
		return new VerificacoesDePrecoService().verificaPreco(numero);
	}

	public boolean usaDinheiro(int numeroPedido, int dinheiro) {
		return new DinheiroService().insereDinheiro(numeroPedido, dinheiro);
	}
	
	public boolean usaDebito(int numeroPedido, BigDecimal dinheiro) {
		return new DebitoService().iniciaPagamento(numeroPedido, dinheiro);
	}
	
}
