package br.com.github.zsguil.maquina_cafe.classes.service.interacao_com_usuario;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public final class CarregamentoService extends InteracaoComUsuario {

	public void iniciarCarregamento(String texto) {
		super.pausar(500);
		super.text().println(texto + "...");
		super.pausar(500);
		super.text().println(texto + "......");
		super.pausar(500);
	}
	
}