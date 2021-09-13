package exceptions;

public class EscolhaErradaException extends RuntimeException {
	
	public EscolhaErradaException(int escolha, int limite) {
		super("Você escolheu um número inválido(" + escolha + "). Escolha um número entre 0 e " + limite + "!");
	}

}
