package br.com.github.zsguil.maquina_cafe.classes.service.escolha_pedido;

import br.com.github.zsguil.maquina_cafe.classes.processo.Preparo;
import br.com.github.zsguil.maquina_cafe.classes.processo.ProcessoPedido;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno.VerificaSeEscolhaEAguaService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaInterno;

public final class EscolhaRepassada extends SistemaInterno {
	
	public void repassar(int escolha) {
		if(this.verificarSeEscolhaEAgua(escolha)) {
			new Preparo(5).prepararBebida();
		} else {
			new ProcessoPedido().processar(escolha);
		}
	}
	
	private boolean verificarSeEscolhaEAgua(int escolha) {
		return new VerificaSeEscolhaEAguaService().verificar(escolha);
	}
		
}
