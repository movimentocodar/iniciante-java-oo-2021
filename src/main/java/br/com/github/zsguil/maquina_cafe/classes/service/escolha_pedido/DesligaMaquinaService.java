package br.com.github.zsguil.maquina_cafe.classes.service.escolha_pedido;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public final class DesligaMaquinaService extends InteracaoComUsuario {

	public void desligar() {
		super.carregar("Desligando");
		super.text().println("_____________________________________");
		System.exit(0);
	}
}
