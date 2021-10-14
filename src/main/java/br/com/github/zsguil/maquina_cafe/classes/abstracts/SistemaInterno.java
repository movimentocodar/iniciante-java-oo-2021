package br.com.github.zsguil.maquina_cafe.classes.abstracts;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.zsguil.maquina_cafe.exceptions.EscolhaErradaException;
import br.com.zsguil.maquina_cafe.exceptions.FaltaAguaException;

public abstract class SistemaInterno {
	private Scanner input = new Scanner(System.in);
	private static int reservaAgua = 1000;
	private static Map<Integer, Bebida> bebidas = new LinkedHashMap<>();

	// ENCAPSULA SYSTEM.OUT

	public void println(Object arg) {
		System.out.println(arg);
	}

	public void print(Object arg) {
		System.out.print(arg);
	}

	// ENCAPSULA MÉTODOS DO SCANNER

	protected int nextInt() {
		return this.input.nextInt();
	}

	protected BigDecimal nextBigDecimal() {
		return this.input.nextBigDecimal();
	}

	protected String nextLine() {
		return this.input.nextLine();
	}

	protected Scanner reset() {
		return this.input.reset();
	}

	protected String next() {
		return input.next();
	}

	// ARMAZENA BEBIDAS E DISPONIBILIZA A TODO O SISTEMA

	public void armazenaBebidas(Map<Integer, Bebida> bebidas) {
		SistemaInterno.bebidas = bebidas;
	}

	public Map<Integer, Bebida> getBebidas() {
		return Collections.unmodifiableMap(SistemaInterno.bebidas);
	}

	// CONTADOR DE ÁGUA:

	public void usaAgua() {
		SistemaInterno.reservaAgua -= 50;
	}

	public boolean verificaAgua(int agua) {
		try {
			if (agua >= 50) {
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
			escolha = this.nextInt();
			
			try {
				
				this.validaEscolha(minimo, limite, escolha);
				
			} catch (EscolhaErradaException ex) {
				this.pausa(500);
				this.println(ex);
				this.println("");
				this.reset();
				this.println("Insira novamente:");
				this.next();
				this.tryEscolha(minimo, limite);
			}
			
		} catch (InputMismatchException ex) {
			this.println(ex + ": Caractere inválido. Insira um número.");
			this.println("");
			this.reset();
			this.next();
			this.println("Insira novamente:");
			this.tryEscolha(minimo, limite);
		}

		return escolha;
	}

	public int validaEscolha(int minimo, int limite, int escolha) {
		if (escolha < minimo || escolha > limite)
			throw new EscolhaErradaException(escolha, limite, minimo);
		else
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
