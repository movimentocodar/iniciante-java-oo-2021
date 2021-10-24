package br.com.github.zsguil.maquina_cafe.classes.service.sistema_pagamento;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaPagamento;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.bebidas.IBebidaEspecial;

public class VerificacoesDePrecoService extends SistemaPagamento {

	public boolean verificaCompra(BigDecimal dinheiro, BigDecimal preco) {
		return dinheiro.add(AdministraCreditoService.getCredito()).compareTo(preco) >= 0;
	}
	
	public BigDecimal verificaPreco(int numero) {
		IBebidaEspecial bebida = (IBebidaEspecial) super.getBebidas().get(numero);
		return bebida.getPreco();
	}
	
}
