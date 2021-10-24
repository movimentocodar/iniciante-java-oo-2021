package br.com.github.zsguil.maquina_cafe.sistema.exceptions;

public class FaltaAguaException extends RuntimeException {

	private static final long serialVersionUID = -225292105417038640L;

	public FaltaAguaException() {
		super("Não há água o suficiente para realizar operação. É"
				+ " necessário reabastecer.");
	}
	
}
