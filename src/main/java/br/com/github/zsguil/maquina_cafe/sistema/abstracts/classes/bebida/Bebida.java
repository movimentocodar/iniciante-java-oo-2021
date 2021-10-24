package br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.bebida;

import br.com.github.zsguil.maquina_cafe.classes.service.bebida.ProcessoDePreparoService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuarioEmBebidas;

public abstract class Bebida extends InteracaoComUsuarioEmBebidas {

	private ProcessoDePreparoService processo = new ProcessoDePreparoService();
	
	public ProcessoDePreparoService novoProcesso() {
		return processo;
	}
	
}
