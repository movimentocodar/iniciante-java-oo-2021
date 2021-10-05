package classes.abstracts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import exceptions.EscolhaErradaException;
import exceptions.FaltaAguaException;

public abstract class SistemaInterno {
	protected Scanner input = new Scanner(System.in);
	private static int reservaAgua = 1000;
	private static List<Bebida> bebidas = new ArrayList<>();

	
	// ENCAPSULA SYSTEM.OUT
	
	public void println(Object arg) {
		System.out.println(arg);
	}
	
	public void print(Object arg) {
		System.out.print(arg);
	}
	
	// ARMAZENA BEBIDAS E DISPONIBILIZA A TODO O SISTEMA

	public void armazenaLista(List<Bebida> bebidas) {
		SistemaInterno.bebidas = bebidas;
	}

	public List<Bebida> getBebidas() {
		return Collections.unmodifiableList(SistemaInterno.bebidas);
	}

	// CONTADOR DE ÁGUA:

	public void usaAgua() {
		SistemaInterno.reservaAgua -= 50;
	}

	public boolean verificaAgua() {
		try {
			if (SistemaInterno.reservaAgua >= 50) {
				return true;
			} else {
				throw new FaltaAguaException();
			}
		} catch (FaltaAguaException ex) {
			this.println(ex);
			this.pausa(3000);
		}
		return false;
	}

	public int getReservaAgua() {
		return SistemaInterno.reservaAgua;
	}

	// FUNCIONALIDADES BÁSICAS:

	public void pausa(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			this.println("Oh oh, algo aconteceu aqui...");
			ex.printStackTrace();
		}
	}

	public int tryEscolha(int minimo, int limite) {
		int escolha = 0;

		try {
			escolha = input.nextInt();

			try {
				if (escolha < minimo || escolha > limite) {
					throw new EscolhaErradaException(escolha, limite, minimo);
				}
			} catch (EscolhaErradaException ex) {
				this.pausa(500);
				this.println(ex);
				this.println("");
				input.reset();
				this.println("Insira novamente:");
				input.next();
				this.tryEscolha(minimo, limite);

			}

		} catch (InputMismatchException ex) {
			this.println(ex + ": Caractere inválido. Insira um número.");
			this.println("");
			input.reset();
			input.next();
			this.println("Insira novamente:");
			this.tryEscolha(minimo, limite);
		}

		return escolha;
	}

	public void carregando(String texto) {
		this.pausa(500);
		this.println(texto + "...");
		this.pausa(500);
		this.println(texto + "......");
		this.pausa(500);

	}

}
