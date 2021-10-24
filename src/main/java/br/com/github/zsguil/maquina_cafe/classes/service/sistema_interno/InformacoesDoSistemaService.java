package br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno;

import br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento.AdministraCreditoService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaInterno;

public class InformacoesDoSistemaService extends SistemaInterno {

	public void mostraInformacoes() {
		super.text().print("\n ----> Água disponível: " + super.getReservatorioAgua().getReservatorioAgua() + "ml");
		super.text().println("\n ----> Crédito: R$ " + AdministraCreditoService.getCredito());
	}
	
}
