package exceptions;

public class EscolhaErradaException extends RuntimeException {
	
	public EscolhaErradaException(int escolha, int limite, int minimo) {
		super("Voc� escolheu um n�mero inv�lido(" + escolha + "). Escolha "
				+ "um n�mero entre " + minimo + " e " + limite + "!");
	}

}
