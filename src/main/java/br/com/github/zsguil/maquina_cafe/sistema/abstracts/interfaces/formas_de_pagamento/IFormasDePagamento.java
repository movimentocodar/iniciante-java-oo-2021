package br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.formas_de_pagamento;

import br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento.AdministraCreditoService;

public interface IFormasDePagamento {
	
	public default String compraBemSucedida() {
		return "Pagamento efetuado com sucesso! Você tem agora R$ " 
		+ AdministraCreditoService.getCredito() + " de crédito em descontos!";
	}
		
}