package br.com.github.zsguil.maquina_cafe.classes.service.bebida;

import br.com.github.zsguil.maquina_cafe.classes.service.bebida.processo_de_preparo.IngredienteService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public final class ProcessoDePreparoService extends InteracaoComUsuario {

	public void ferverAgua() {
		super.getReservatorioAgua().usarAgua();
		this.usarIngrediente("Esquentando água", " \n Água fervida!");
	}

	public void filtrar(String nome) {
		this.usarIngrediente("Filtrando", "\n" + nome + " filtrado!");
	}

	public void terminarBebida(String nome) {
		this.filtrar(nome);
		super.pausar(300);
		super.text().println("_____________________________________ \n");
		super.text().println(nome + " pronto!");
	}

	public void usarIngrediente(String processando, String concluido) {
		new IngredienteService().usarNovoIngrediente(processando, concluido);
	}
	
	
}
