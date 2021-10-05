package classes.abstracts;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.EscolhaPedido;
import exceptions.DinheiroInsuficienteException;
import exceptions.EscolhaErradaException;
import exceptions.FaltaAguaException;

public abstract class SistemaInterno{
	protected Scanner input = new Scanner(System.in);
	private static int reservaAgua = 1000;
	
	
	// CONTADOR DE ÁGUA:
	
	public void usaAgua() {
		
		try {
			if(SistemaInterno.reservaAgua >= 50) {
				SistemaInterno.reservaAgua -= 50;
			} else {
				throw new FaltaAguaException();
			}
		} catch (FaltaAguaException ex) {
			System.out.println(ex);
			SistemaInterno.pausa(500);
			SistemaInterno.repetir();
		}
	}
	
	public int getReservaAgua() {
		return SistemaInterno.reservaAgua;
	}
	
	// FUNCIONALIDADES BÁSICAS:
	
	public static void pausa(int ms) {
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
	
	public int tryEscolha(int minimo, int limite) {
		int escolha = 0;
		
		try {
			escolha = input.nextInt();
		} catch(InputMismatchException ex) {
			System.out.println(ex + "Caractere inválido. Insira um número.");
			SistemaInterno.pausa(500);
			this.tryEscolha(minimo, limite);
		}
		
		try {
			if(escolha < minimo || escolha > limite) {
				throw new EscolhaErradaException(escolha, limite, minimo);
			}
		} catch (EscolhaErradaException ex) {
			SistemaInterno.pausa(500);
			System.out.println(ex);
			System.out.println("\n Escolha novamente: \n");
			this.tryEscolha(minimo, limite);
		}
		
		return escolha;
	}
	
	public void carregando(String texto) {
		System.out.print(texto + "..");
		SistemaInterno.pausa(500);
		System.out.print("...");
		SistemaInterno.pausa(500);
		System.out.println("....");
		SistemaInterno.pausa(500);

	}

	public static void repetir() {
		SistemaInterno.pausa(2000);
		System.out.println("\n \n \n");
		EscolhaPedido escolhaPedido = new EscolhaPedido();
		SistemaInterno.repetir();
	}
		
}
