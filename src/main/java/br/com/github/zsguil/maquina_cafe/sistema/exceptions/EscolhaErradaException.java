package br.com.github.zsguil.maquina_cafe.sistema.exceptions;

public class EscolhaErradaException extends RuntimeException {
	
	private static final long serialVersionUID = -1305645055079188982L;

	public EscolhaErradaException(int escolha, int limite, int minimo) {
		super("Você escolheu um número inválido(" + escolha + "). Escolha "
				+ "um número entre " + minimo + " e " + limite + "!");
	}

}
