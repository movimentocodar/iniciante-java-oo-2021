package exceptions;

public class DinheiroInsuficienteException extends RuntimeException {

	public DinheiroInsuficienteException() {
		super("Opera��o negada. Saldo insuficiente.");
	}
	
}
