package classes;

import java.util.InputMismatchException;

import abstracts.SistemaInterno;

public class ProcessandoPedido extends SistemaInterno {

	public ProcessandoPedido(int numeroPedido) {
		int acucarNivel = this.nivelAcucar();
		this.formaPagamento(numeroPedido);
		
		super.pausa(500);
		
		Preparo bebida = new Preparo(numeroPedido);
	}
	
	public int nivelAcucar() {
		System.out.println("Deseja escolher o n�vel de a��car? S/N");
		String acucarEscolha = super.input.nextLine();
		
		switch (acucarEscolha) {
		case "N", "n": {
			return 3;
		}
		case "S", "s": {
			System.out.println("N�veis de ��ucar: 0-5. Escolha:");
			int escolhaNivel = super.tryEscolha(0, 5);
			return escolhaNivel;
		}
		default:
			throw new InputMismatchException("Caractere inv�lido. Responda com S ou N.");
		}
	}
	
	public void formaPagamento(int numero) {
		System.out.println("Formas de pagamento: \n "
				+ "1. Pagar em dinheiro \n 2. Pagar com d�bito");
		int pagEscolha = super.tryEscolha(1, 2);
		
		if(pagEscolha == 1) {
			System.out.println("Insira o dinheiro abaixo:");
			super.insereDinheiro(numero);			
		} else {
			System.out.println("Insira o valor abaixo:");
			super.usaDebito(numero);
		}
	}
	
	
}
