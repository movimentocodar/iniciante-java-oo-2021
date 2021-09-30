package exceptions;

import abstracts.SistemaPagamento;

public class DinheiroInsuficienteException extends RuntimeException {

	public DinheiroInsuficienteException() {
		super("Operação negada. Saldo insuficiente.");
	}
	
}
