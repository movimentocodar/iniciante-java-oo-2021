package br.com.github.zsguil.maquina_cafe.classes.service.processando_pedido;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public final class EscolhaPagamentoService extends InteracaoComUsuario {

	public int fazerEscolhaDePagamento() {
			super.text().println("\nFormas de pagamento: \n" 
					+ " 1. Pagar em dinheiro \n 2. Pagar com débito");
			return super.escolher(1, 2);
	}
	
	public int receberEscolhaDinheiro() {
		return super.scanner().nextInt();
	}
	
	public BigDecimal receberEscolhaDebito() {
		return super.scanner().nextBigDecimal();
	}

}
