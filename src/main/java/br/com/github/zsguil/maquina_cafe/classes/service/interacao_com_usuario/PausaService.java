package br.com.github.zsguil.maquina_cafe.classes.service.interacao_com_usuario;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public class PausaService extends InteracaoComUsuario {

	public void pausar(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			super.text().println("Oh oh, algo aconteceu aqui...");
			ex.printStackTrace();
		}
	}
	
}
