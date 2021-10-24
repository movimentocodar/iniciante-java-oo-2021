package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;

public class AdministradorDeCreditoService extends SistemaPagamento {
	private static BigDecimal credito = BigDecimal.ZERO;
	
	public static BigDecimal getCredito() {
		return AdministradorDeCreditoService.credito;
	}
	
	public boolean verificarSeCreditoESobrejacente(BigDecimal preco) {
		return AdministradorDeCreditoService.credito.compareTo(preco) >= 0;
	}
	
	public boolean verificarPagamentoComCredito(BigDecimal preco) {
		if (this.verificarSeCreditoESobrejacente(preco)) {
			
			new RealizadorDePagamentoComCreditoService().realizarPagamento(preco);
			
			return true;
		
		} else return false;
	}
	
	protected void atualizarCredito(int dinheiro, BigDecimal preco) {
		BigDecimal dinheiroDecimal = new BigDecimal(dinheiro);
		AdministradorDeCreditoService.credito = 
				AdministradorDeCreditoService.credito.add(dinheiroDecimal).subtract(preco);
	}

	protected void atualizarCredito(BigDecimal dinheiro, BigDecimal preco) {
		AdministradorDeCreditoService.credito = 
				AdministradorDeCreditoService.credito.add(dinheiro).subtract(preco);
	}
	
}
