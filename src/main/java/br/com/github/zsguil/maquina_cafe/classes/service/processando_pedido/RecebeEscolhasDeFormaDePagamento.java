package br.com.github.zsguil.maquina_cafe.classes.service.processando_pedido;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public final class RecebeEscolhasDeFormaDePagamento extends InteracaoComUsuario {

	public int fazEscolhaDePagamento() {
			super.text().println("\nFormas de pagamento: \n" 
					+ " 1. Pagar em dinheiro \n 2. Pagar com débito");
			return super.escolha(1, 2);
	}
	
	public int recebeEscolhaDinheiro() {
		return super.scanner().nextInt();
	}
	
	public BigDecimal recebeEscolhaDebito() {
		return super.scanner().nextBigDecimal();
	}

}
