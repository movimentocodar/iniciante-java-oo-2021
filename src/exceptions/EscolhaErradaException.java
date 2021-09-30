package exceptions;

public class EscolhaErradaException extends RuntimeException {
	
	public EscolhaErradaException(int escolha, int limite, int minimo) {
		super("Você escolheu um número inválido(" + escolha + "). Escolha "
				+ "um número entre " + minimo + " e " + limite + "!");
	}

}
