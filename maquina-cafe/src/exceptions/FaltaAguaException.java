package exceptions;

public class FaltaAguaException extends RuntimeException {

	public FaltaAguaException() {
		super("N�o h� �gua o suficiente para realizar opera��o. �"
				+ " necess�rio reabastecer.");
	}
	
}
