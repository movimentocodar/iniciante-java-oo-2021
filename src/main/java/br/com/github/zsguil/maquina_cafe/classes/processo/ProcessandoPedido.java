package br.com.github.zsguil.maquina_cafe.classes.processo;

import br.com.github.zsguil.maquina_cafe.classes.service.processando_pedido.EscolheNivelAcucarService;
import br.com.github.zsguil.maquina_cafe.classes.service.processando_pedido.PagamentoService;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno.VerificaSeEscolhaEAguaService;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento.PagamentoSomenteComCreditosService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;

public class ProcessandoPedido extends SistemaPagamento {
	private int numeroPedido;
	private int nivelAcucar;

	public void processando(int escolha) {
		new VerificaSeEscolhaEAguaService().verificaELancaException(escolha);

		this.numeroPedido = escolha;

		this.nivelAcucar = this.escolheNivelAcucar();

		if (this.escolheFormaPagamento())
			this.iniciaPreparo();
	}

	public int escolheNivelAcucar() {
		return new EscolheNivelAcucarService().defineNivelAcucar();
	}

	public boolean escolheFormaPagamento() {

		if (new PagamentoSomenteComCreditosService().verifica(this.numeroPedido)) {
			return true;
		} else {
			var formaPagamento = new PagamentoService(this.numeroPedido);
			formaPagamento.escolhaFormaPagamento();

			return formaPagamento.valida();
		}
	}

	public void iniciaPreparo() {
		new Preparo(this.numeroPedido, this.nivelAcucar);
	}

}
