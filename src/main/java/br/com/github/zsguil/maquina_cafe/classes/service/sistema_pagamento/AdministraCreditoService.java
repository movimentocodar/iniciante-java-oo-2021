package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;

public class AdministraCreditoService extends SistemaPagamento {
	private static BigDecimal credito = BigDecimal.ZERO;
	
	public static BigDecimal getCredito() {
		return AdministraCreditoService.credito;
	}
	
	public boolean verificaSeCreditoESobrejacente(BigDecimal preco) {
		return AdministraCreditoService.credito.compareTo(preco) >= 0;
	}
	
	public boolean verificaPagamentoComCredito(BigDecimal preco) {
		if (this.verificaSeCreditoESobrejacente(preco)) {
			
			new PagamentoBemSucedidoComCreditoService(preco);
			
			return true;
		
		} else return false;
	}
	
	protected void atualizaCredito(int dinheiro, BigDecimal preco) {
		BigDecimal dinheiroDecimal = new BigDecimal(dinheiro);
		AdministraCreditoService.credito = 
				AdministraCreditoService.credito.add(dinheiroDecimal).subtract(preco);
	}

	protected void atualizaCredito(BigDecimal dinheiro, BigDecimal preco) {
		AdministraCreditoService.credito = 
				AdministraCreditoService.credito.add(dinheiro).subtract(preco);
	}
	
}
