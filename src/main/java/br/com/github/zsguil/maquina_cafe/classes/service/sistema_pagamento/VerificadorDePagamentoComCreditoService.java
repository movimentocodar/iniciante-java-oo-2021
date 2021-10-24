package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;

public class VerificadorDePagamentoComCreditoService extends SistemaPagamento {

	public boolean verificar(int numeroPedido) {
		BigDecimal precoBebida = super.determinaPreco(numeroPedido);

		if(AdministradorDeCreditoService.administraCredito().verificarSeCreditoESobrejacente(precoBebida)) {
			new RealizadorDePagamentoComCreditoService().realizarPagamento(precoBebida);
			return true;
		} else return false;
	}
	
}
