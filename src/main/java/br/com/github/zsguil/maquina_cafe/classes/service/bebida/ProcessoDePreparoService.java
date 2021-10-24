package br.com.github.zsguil.maquina_cafe.classes.service.bebida;

import br.com.github.zsguil.maquina_cafe.classes.service.bebida.processo_de_preparo.UsarIngredienteService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public final class ProcessoDePreparoService extends InteracaoComUsuario {

	public void ferverAgua() {
		super.getReservatorioAgua().usaAgua();
		this.usandoIngrediente("Esquentando água", " \n Água fervida!");
	}

	public void filtrar(String nome) {
		this.usandoIngrediente("Filtrando", "\n" + nome + " filtrado!");
	}

	public void terminoBebida(String nome) {
		this.filtrar(nome);
		super.pausa(300);
		super.text().println("_____________________________________ \n");
		super.text().println(nome + " pronto!");
	}

	public void usandoIngrediente(String processando, String concluido) {
		new UsarIngredienteService(processando, concluido);
	}
	
	
}
