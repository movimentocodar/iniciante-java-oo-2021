package abstracts;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.EscolhaErradaException;

public abstract class SistemaInterno{
	private Scanner input = new Scanner(System.in);
	
	public void pausa(int ms) {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
        	Thread.currentThread().interrupt();
        	System.out.println("Oh oh, algo aconteceu aqui...");
        	ex.printStackTrace();
        }
    }
	
	
	public int tryEscolha(int limite) {
		int escolha;
		
		try {
			escolha = input.nextInt();
		} catch(InputMismatchException ex) {
			pausa(500);
			throw new InputMismatchException("Caractere inválido. Insira um número.");
		}
		
		if(escolha < 0 || escolha > limite) {
			pausa(500);
			throw new EscolhaErradaException(escolha, limite);
			} else {
				return escolha;
			}
	}
	
	public void carregando(String texto) {
		System.out.print(texto + "..");
		pausa(500);
		System.out.print("...");
		pausa(500);
		System.out.println("....");
		pausa(500);

	}
	
	public void usandoIngrediente(String processando, String concluido) {
		carregando(processando);
		carregando(processando + "...");
		System.out.println(concluido);
		pausa(250);
	}
	
	public int getInput() {
		return input.nextInt();
	}
}