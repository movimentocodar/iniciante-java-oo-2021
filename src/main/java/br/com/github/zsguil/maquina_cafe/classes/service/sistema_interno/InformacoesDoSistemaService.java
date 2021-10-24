package br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno;

import br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento.AdministradorDeCreditoService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaInterno;

public class InformacoesDoSistemaService extends SistemaInterno {

	public void mostrarInformacoes() {
		super.text().print("\n ----> Água disponível: " + super.getReservatorioAgua().getReservatorioAgua() + "ml");
		super.text().println("\n ----> Crédito: R$ " + AdministradorDeCreditoService.getCredito());
	}
	
}
