package br.com.github.zsguil.maquina_cafe.classes.processo;

import br.com.github.zsguil.maquina_cafe.classes.service.processando_pedido.NivelAcucarService;
import br.com.github.zsguil.maquina_cafe.classes.service.processando_pedido.PagamentoService;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno.VerificaSeEscolhaEAguaService;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento.VerificadorDePagamentoComCreditoService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;

public class ProcessoPedido extends SistemaPagamento {
	private int numeroPedido;
	private int nivelAcucar;

	public void processar(int escolha) {
		new VerificaSeEscolhaEAguaService().verificarELancarException(escolha);

		this.numeroPedido = escolha;

		this.nivelAcucar = this.escolherNivelAcucar();

		if (this.escolherFormaPagamento())
			this.iniciarPreparo();
	}

	public int escolherNivelAcucar() {
		return new NivelAcucarService().escolher();
	}

	public boolean escolherFormaPagamento() {

		if (new VerificadorDePagamentoComCreditoService().verificar(this.numeroPedido)) {
			return true;
		} else {
			var formaPagamento = new PagamentoService(this.numeroPedido);
			formaPagamento.escolherFormaPagamento();

			return formaPagamento.validar();
		}
	}

	public void iniciarPreparo() {
		new Preparo(this.numeroPedido).prepararBebida(this.nivelAcucar);
	}

}
