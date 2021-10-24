package br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaInterno;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.bebidas.IBebida;

public class VerificaSeEscolhaEAguaService extends SistemaInterno {

	public boolean verificar(int escolha) {
		IBebida bebidaEscolhida = (IBebida) super.getBebidas().get(escolha);
		return bebidaEscolhida.getPreco() == BigDecimal.ZERO;
	}

	public void verificarELancarException(int escolha) {
		if (this.verificar(escolha)) {
			throw new IllegalArgumentException("Água quente não deve ter o pedido procesado!");
		}
	}

}
