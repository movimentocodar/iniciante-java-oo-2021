package br.com.zsguil.maquina_cafe.exceptions;

public class DinheiroInsuficienteException extends RuntimeException {

	public DinheiroInsuficienteException() {
		super("Operação negada. Saldo insuficiente.");
	}
	
}
