package classes;

import java.util.InputMismatchException;

import classes.abstracts.SistemaInterno;
import classes.abstracts.SistemaPagamento;

public class ProcessandoPedido extends SistemaPagamento {

	public ProcessandoPedido(int numeroPedido) {
		int acucarNivel = this.nivelAcucar();		
		this.formaPagamento(numeroPedido);
		
		SistemaInterno.pausa(500);
		
		Preparo bebida = new Preparo(numeroPedido, acucarNivel);
	}

	public int nivelAcucar() {
		System.out.println("Deseja escolher o nível de açúcar? S/N");
		String acucarEscolha = super.input.nextLine();
		
		int escolhaNivel = 3;
		
		try {
			switch (acucarEscolha) {
			case "N", "n": {
				return 3;
			}
			case "S", "s": {
				System.out.println("Colheres de açúcar: 0-5. Escolha:");
				escolhaNivel = super.tryEscolha(0, 5);
			}
			default:
				throw new InputMismatchException("Caractere inválido: " 
			+ acucarEscolha + ". Responda com S ou N.");
			}
		} catch (InputMismatchException ex) {
				SistemaInterno.pausa(500);
				SistemaInterno.repetir();
			}
		
		return escolhaNivel;
		
		}
	
	public void formaPagamento(int numero) {
		System.out.println("Formas de pagamento: \n "
				+ "1. Pagar em dinheiro \n 2. Pagar com débito");
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
