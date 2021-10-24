package br.com.github.zsguil.maquina_cafe.classes.service.escolha_pedido;

import br.com.github.zsguil.maquina_cafe.classes.processo.Preparo;
import br.com.github.zsguil.maquina_cafe.classes.processo.ProcessandoPedido;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno.VerificaSeEscolhaEAguaService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaInterno;

public final class EscolhaRepassada extends SistemaInterno {
	
	public EscolhaRepassada(int escolha) {
		this.repassar(escolha);
	}
	
	public void repassar(int escolha) {
		if(this.verificaSeEscolhaEAgua(escolha)) {
			new Preparo(5);
		} else {
			new ProcessandoPedido().processando(escolha);
		}
	}
	
	private boolean verificaSeEscolhaEAgua(int escolha) {
		return new VerificaSeEscolhaEAguaService().verifica(escolha);
	}
		
}
