package br.com.zsguil.maquina_cafe;

import br.com.github.zsguil.maquina_cafe.classes.EscolhaPedido;
import br.com.github.zsguil.maquina_cafe.classes.abstracts.SistemaInterno;
import br.com.github.zsguil.maquina_cafe.classes.abstracts.SistemaPagamento;

public class Main extends SistemaInterno {
	
	
	public static void main(String[] args) {				
		
		while(true) {
			new EscolhaPedido().escolha();
			SistemaPagamento.resetVerificacaoSaldo();
		}
	}
}
