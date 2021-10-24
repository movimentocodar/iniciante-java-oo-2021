package br.com.github.zsguil.maquina_cafe.classes.processo;

import java.util.Map;

import br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno.InformacoesDoSistemaService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.bebida.Bebida;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaInterno;

public final class Menu extends SistemaInterno {
	private Map<Integer, Bebida> bebidas;
	
	public Menu() {
		this.bebidas = super.getBebidas();
	}
	
	public void mostraOpcoesBebidas() {
		super.text().println("\n  --------- Selecione uma Opção --------- \n");

		for(int key = 1; key <= 5; key++) {
			Bebida bebida = this.bebidas.get(key);
			super.text().println("| --> " + key + ". " + bebida.toString() + " |");
		}
				
		super.text().println("\n  ------------- 0. Desliga -------------");

		new InformacoesDoSistemaService().mostraInformacoes();
		
	}

}
