package br.com.github.zsguil.maquina_cafe.classes.service.processando_pedido;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;

public final class PagamentoService extends SistemaPagamento {

	private final int numeroPedido;
	private int escolhaPagamento;

	public PagamentoService(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public void escolhaFormaPagamento() {		
		this.escolhaPagamento = new RecebeEscolhasDeFormaDePagamento().fazEscolhaDePagamento();
		
	}
	
	public boolean valida() {

		if (this.escolhaPagamento == 1) {
			super.text().println("Insira o dinheiro abaixo:");
			return super.usaDinheiro(this.numeroPedido, this.escolhaDinheiro());
		} else {
			super.text().println("Insira o valor abaixo:");
			return super.usaDebito(this.numeroPedido, this.escolhaValorDebito());
		}
	}
	
	private int escolhaDinheiro() {
		return new RecebeEscolhasDeFormaDePagamento().recebeEscolhaDinheiro();
	}
	
	private BigDecimal escolhaValorDebito() {
		return new RecebeEscolhasDeFormaDePagamento().recebeEscolhaDebito();
	}

}
