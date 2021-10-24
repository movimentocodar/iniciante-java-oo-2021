package br.com.github.zsguil.maquina_cafe.classes.processo;

import br.com.github.zsguil.maquina_cafe.classes.service.escolha_pedido.DesligaMaquinaService;
import br.com.github.zsguil.maquina_cafe.classes.service.escolha_pedido.EscolhaRepassada;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public final class EscolhaPedido extends InteracaoComUsuario {
	private int escolhaBebida;
	
	public void fazerEscolha() {
				
		super.text().println("\n -----> Faça seu pedido: ");		
		
		this.escolhaBebida = super.escolha(0, super.getBebidas().size());
		
		super.text().println("");
		super.pausa(500);

		if(this.escolhaBebida != 0) 
			new EscolhaRepassada(this.escolhaBebida);
		else 
			new DesligaMaquinaService();
		
	}

}
