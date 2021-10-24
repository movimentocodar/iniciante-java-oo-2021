package br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario;

public abstract class InteracaoComUsuarioEmBebidas extends InteracaoComUsuario {

	public static String divisorNomePreco(int caracteresDoNome) {
		String divisor = "";
		int maximoCaracteres = 24;
		
		for(int i = 0; i < (maximoCaracteres - caracteresDoNome); i++) {
			divisor += ".";
		}
		
		return divisor;
	}
	
}
