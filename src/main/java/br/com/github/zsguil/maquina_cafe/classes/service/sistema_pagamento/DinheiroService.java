package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.formas_de_pagamento.IFormasDePagamento;

public final class DinheiroService extends SistemaPagamento implements IFormasDePagamento {

	public boolean insereDinheiro(int numeroPedido, int dinheiro) {

		BigDecimal preco = determinaPreco(numeroPedido);

		if (!super.administraCredito().verificarPagamentoComCredito(preco)) {

			if (this.validaCedula(dinheiro)) {
				
				super.administraCredito().atualizarCredito(dinheiro, preco);
				super.text().println(compraBemSucedida());
				super.pausar(500);
			
			} else insereDinheiro(numeroPedido, super.scanner().nextInt());
		}
		
		return true;
	}

	protected boolean validaCedula(int dinheiro) {
		try {

			switch (dinheiro) {
			case 2, 5, 10, 20, 50, 100: {
				return true;
			}
			default:
				throw new IllegalArgumentException(
						"Valor inesperado: nota inválida. \n " + "Insira uma nota existente abaixo:");
			}

		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
