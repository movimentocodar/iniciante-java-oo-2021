package br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaInterno;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.bebidas.IBebida;

public class VerificaSeEscolhaEAguaService extends SistemaInterno {

	public boolean verifica(int escolha) {
		IBebida bebidaEscolhida = (IBebida) super.getBebidas().get(escolha);
		return bebidaEscolhida.getPreco() == BigDecimal.ZERO;
	}

	public void verificaELancaException(int escolha) {
		if (this.verifica(escolha)) {
			throw new IllegalArgumentException("Água quente não deve ter o pedido procesado!");
		}
	}

}