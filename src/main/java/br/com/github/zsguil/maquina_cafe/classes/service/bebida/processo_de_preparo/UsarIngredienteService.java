package br.com.github.zsguil.maquina_cafe.classes.service.bebida.processo_de_preparo;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public class UsarIngredienteService extends InteracaoComUsuario {

	public UsarIngredienteService(String processando, String concluido) {
		super.text().println("");
		super.carregando(processando);
		super.carregando(processando + "......");
		super.text().println(concluido);
		super.pausa(250);
	}
	
}
