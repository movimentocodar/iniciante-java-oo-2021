package exceptions;

public class DinheiroInsuficienteException extends RuntimeException {

	public DinheiroInsuficienteException() {
		super("Operação negada. Saldo insuficiente.");
	}
	
}
