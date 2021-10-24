package br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario;

import br.com.github.zsguil.maquina_cafe.classes.service.interacao_com_usuario.CarregamentoService;
import br.com.github.zsguil.maquina_cafe.classes.service.interacao_com_usuario.PausaService;
import br.com.github.zsguil.maquina_cafe.classes.service.interacao_com_usuario.ScannerService;
import br.com.github.zsguil.maquina_cafe.classes.service.interacao_com_usuario.ValidadorDeEscolhasService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaInterno;

public abstract class InteracaoComUsuario extends SistemaInterno {
	private final ScannerService scannerService = new ScannerService();

	public ScannerService scanner() {
		return this.scannerService;
	}
	
	public int escolher(int minimo, int limite) {
		return new ValidadorDeEscolhasService().tryEscolha(minimo, limite);
	}

	public void pausar(int ms) {
		new PausaService().pausar(ms);
	}
	
	public void carregar(String texto) {
		new CarregamentoService().iniciarCarregamento(texto);
	}
}
