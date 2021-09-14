package abstracts;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.EscolhaPedido;
import exceptions.DinheiroInsuficienteException;
import exceptions.EscolhaErradaException;

public abstract class SistemaInterno{
	protected Scanner input = new Scanner(System.in);
	private static double credito;
	private static int reservaAgua = 1000;
	
	
	// CONTADOR DE ÁGUA:
	
	public int getReservaAgua() {
		return this.reservaAgua;
	}
	
	public void usaAgua() {
		
		if(this.reservaAgua >= 50) {
			this.reservaAgua -= 50;
		} else {
			
		}
	}
	
	// FUNCIONALIDADES BÁSICAS:
	
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
	
	public int tryEscolha(int minimo, int limite) {
		int escolha;
		
		try {
			escolha = input.nextInt();
		} catch(InputMismatchException ex) {
			pausa(500);
			throw new InputMismatchException("Caractere inválido. Insira um número.");
		}
		
		if(escolha < minimo || escolha > limite) {
			pausa(500);
			throw new EscolhaErradaException(escolha, limite, minimo);
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

	public void repetir() {
		this.pausa(2000);
		System.out.println("\n \n \n");
		EscolhaPedido escolhaPedido = new EscolhaPedido();
	}
	
	// MÉTODOS RELACIONADOS A DINHEIRO:
	
	private double determinaPreco(int numero) {
		double preco = 0;

		switch (numero) {
		case 1: {
			preco = 0.50;
		}
		case 2, 4: {
			preco = 1.00;
		}
		case 3: {
			preco = 1.50;
		}
		}

		return preco;
	}
	
	private void atualizaCredito(int dinheiro, double preco) {
		this.credito = (dinheiro + this.credito) - preco;
	}
		
	public void insereDinheiro(int numeroPedido) {
		
		double preco = determinaPreco(numeroPedido);
		
		int dinheiro = input.nextInt();
		
		switch (dinheiro) {
		case 2, 5, 10, 20, 50, 100: {
			this.atualizaCredito(dinheiro, preco);
			break;
		}
		default:
			throw new IllegalArgumentException("Valor inesperado: " + dinheiro);
		}

		System.out.println("Pagamento efetuado com sucesso! Você tem "
				+ "agora R$ " + this.credito + " de crédito em descontos! \n");
	}
	
	public void usaDebito(int numeroPedido) {
		double preco = determinaPreco(numeroPedido);
		int dinheiro = input.nextInt();
		
		if(dinheiro + this.credito >= preco) {
			this.atualizaCredito(dinheiro, preco);
			System.out.println("Pagamento efetuado com sucesso! Você tem "
				+ "agora R$ " + this.credito + " de crédito em descontos!");
		} else {
			throw new DinheiroInsuficienteException();
		}
	}
	
}
