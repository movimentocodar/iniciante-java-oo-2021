package br.com.github.zsguil.maquina_cafe.classes.service.processando_pedido;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;

public final class PagamentoService extends SistemaPagamento {

	private final int numeroPedido;
	private int escolhaPagamento;

	public PagamentoService(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public void escolherFormaPagamento() {		
		this.escolhaPagamento = new EscolhaPagamentoService().fazerEscolhaDePagamento();
		
	}
	
	public boolean validar() {

		if (this.escolhaPagamento == 1) {
			super.text().println("Insira o dinheiro abaixo:");
			return super.usaDinheiro(this.numeroPedido, this.escolherDinheiro());
		} else {
			super.text().println("Insira o valor abaixo:");
			return super.usaDebito(this.numeroPedido, this.escolherValorDebito());
		}
	}
	
	private int escolherDinheiro() {
		return new EscolhaPagamentoService().receberEscolhaDinheiro();
	}
	
	private BigDecimal escolherValorDebito() {
		return new EscolhaPagamentoService().receberEscolhaDebito();
	}

}
