package br.com.github.zsguil.maquina_cafe.sistema.exceptions;

public class DinheiroInsuficienteException extends RuntimeException {
	
	private static final long serialVersionUID = -9066311131979448255L;

	public DinheiroInsuficienteException() {
		super("Operação negada. Saldo insuficiente.");
	}
	
}
