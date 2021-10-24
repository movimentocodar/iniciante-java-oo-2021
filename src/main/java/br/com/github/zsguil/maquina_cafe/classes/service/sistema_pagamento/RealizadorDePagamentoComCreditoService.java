package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import java.math.BigDecimal;

public class RealizadorDePagamentoComCreditoService extends AdministradorDeCreditoService {

	public void realizarPagamento(BigDecimal preco) {
		super.atualizarCredito(BigDecimal.ZERO, preco);
		
		super.text().println("Pagamento efetuado com créditos! Você tem agora R$ " 
				+ AdministradorDeCreditoService.getCredito() + " de crédito em descontos!");
		}

}
