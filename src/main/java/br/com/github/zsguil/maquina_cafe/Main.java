package br.com.github.zsguil.maquina_cafe;

import br.com.github.zsguil.maquina_cafe.classes.processo.EscolhaPedido;
import br.com.github.zsguil.maquina_cafe.classes.processo.Menu;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno.PrintService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaInterno;

public class Main extends SistemaInterno {
	
	
	public static void main(String[] args) {				
		
		while(true) {
			new Menu().mostrarMenu();
			new EscolhaPedido().fazerEscolha();
			
			new PrintService().println("\n \n \n \n \n \n \n \n \n");
		}
	}
}