package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import java.math.BigDecimal;

public class PagamentoBemSucedidoComCreditoService extends AdministraCreditoService {

	public PagamentoBemSucedidoComCreditoService(BigDecimal preco) {
		super.atualizaCredito(BigDecimal.ZERO, preco);
		
		super.text().println("Pagamento efetuado com créditos! Você tem agora R$ " 
				+ AdministraCreditoService.getCredito() + " de crédito em descontos!");
		}

}
