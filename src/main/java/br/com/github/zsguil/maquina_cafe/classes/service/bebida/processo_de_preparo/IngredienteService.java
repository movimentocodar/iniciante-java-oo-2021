package br.com.github.zsguil.maquina_cafe.classes.service.bebida.processo_de_preparo;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public class IngredienteService extends InteracaoComUsuario {

	public void usarNovoIngrediente(String processando, String concluido) {
		super.text().println("");
		super.carregar(processando);
		super.carregar(processando + "......");
		super.text().println(concluido);
		super.pausar(250);
	}
	
}
