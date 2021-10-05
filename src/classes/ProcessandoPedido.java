package classes;

import java.util.InputMismatchException;

import classes.abstracts.SistemaPagamento;
import exceptions.DinheiroInsuficienteException;

public class ProcessandoPedido extends SistemaPagamento {

	public ProcessandoPedido(int numeroPedido) {

		if (super.verificaAgua()) {
			int acucarNivel = this.nivelAcucar();
			this.formaPagamento(numeroPedido);

			super.pausa(500);

			try {
				if (!SistemaPagamento.getSaldoNegado()) {
					new Preparo(numeroPedido, acucarNivel);
				} else
					throw new DinheiroInsuficienteException();
			} catch (DinheiroInsuficienteException ex) {
				super.println(ex);
				super.pausa(500);
			}
		}
	}

	public int nivelAcucar() {
		super.println("Deseja escolher o nível de açúcar? S/N");
		String acucarEscolha = super.input.nextLine();

		int escolhaNivel = 3;

		try {
			switch (acucarEscolha) {
			case "N", "n": {
				break;
			}
			case "S", "s": {
				super.println("Colheres de açúcar: 0-5. Escolha:");
				escolhaNivel = super.tryEscolha(0, 5);
				break;
			}
			default:
				throw new InputMismatchException("Caractere inválido: " + acucarEscolha + ". Responda com S ou N.");
			}
		} catch (InputMismatchException ex) {
			super.println(ex + "\n");
			super.pausa(500);
			this.nivelAcucar();
		}

		return escolhaNivel;

	}

	public void formaPagamento(int numero) {
		super.println("\nFormas de pagamento: \n " + "1. Pagar em dinheiro \n 2. Pagar com débito");
		int pagEscolha = super.tryEscolha(1, 2);

		if (pagEscolha == 1) {
			super.println("Insira o dinheiro abaixo:");
			super.insereDinheiro(numero);
		} else {
			super.println("Insira o valor abaixo:");
			super.usaDebito(numero);
		}
	}

}
