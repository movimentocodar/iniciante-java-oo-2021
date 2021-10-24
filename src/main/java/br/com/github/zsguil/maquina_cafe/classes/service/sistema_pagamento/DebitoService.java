package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.formas_de_pagamento.IFormasDePagamento;
import br.com.github.zsguil.maquina_cafe.sistema.exceptions.DinheiroInsuficienteException;

public final class DebitoService extends SistemaPagamento implements IFormasDePagamento {

	public boolean iniciaPagamento(int numeroPedido, BigDecimal dinheiro) {
		BigDecimal preco = determinaPreco(numeroPedido);
	
		if(!super.administraCredito().verificaPagamentoComCredito(preco)) {
			this.usaSaldo(dinheiro, preco);
		}
		
		return true;

	}

	protected void usaSaldo(BigDecimal dinheiro, BigDecimal preco) {
		if (super.verificaSePodeComprar(dinheiro, preco)) {
			super.administraCredito().atualizaCredito(dinheiro, preco);
			
			super.text().println(compraBemSucedida());
			super.pausa(500);
			
		} else throw new DinheiroInsuficienteException();
	}
}
