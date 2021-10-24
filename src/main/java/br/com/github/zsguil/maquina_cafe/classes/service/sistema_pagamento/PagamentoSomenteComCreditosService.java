package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;

public class PagamentoSomenteComCreditosService extends SistemaPagamento {

	public boolean verifica(int numeroPedido) {
		BigDecimal precoBebida = super.determinaPreco(numeroPedido);

		if(AdministraCreditoService.administraCredito().verificaSeCreditoESobrejacente(precoBebida)) {
			new PagamentoBemSucedidoComCreditoService(precoBebida);
			return true;
		} else return false;
	}
	
}
