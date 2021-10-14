package br.com.github.zsguil.maquina_cafe.classes;

import java.util.InputMismatchException;

import br.com.github.zsguil.maquina_cafe.classes.abstracts.SistemaPagamento;
import br.com.zsguil.maquina_cafe.exceptions.DinheiroInsuficienteException;

public class ProcessandoPedido extends SistemaPagamento {
	private int numeroPedido;
	private int nivelAcucar;

	public void processando(int numeroPedido) {

		if (numeroPedido == 5) {
			throw new IllegalArgumentException("Água quente não deve ter o"
					+ " pedido procesado!");
		}

		this.numeroPedido = numeroPedido;
	}

	public void escolheNivelAcucar() {
		super.println("Deseja escolher o nível de açúcar? S/N");
		String acucarEscolha = super.nextLine();

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
			this.escolheNivelAcucar();
		}

		this.nivelAcucar = escolhaNivel;

	}

	public void escolheFormaPagamento() {
		super.println("\nFormas de pagamento: \n " + "1. Pagar em dinheiro \n 2. Pagar com débito");
		int pagEscolha = super.tryEscolha(1, 2);

		if (pagEscolha == 1) {
			super.println("Insira o dinheiro abaixo:");
			super.insereDinheiro(this.numeroPedido, super.nextInt());
		} else {
			super.println("Insira o valor abaixo:");
			super.usaDebito(this.numeroPedido, super.nextBigDecimal());
		}
	}

	public void iniciaPreparo() {
		try {
			if (!SistemaPagamento.getSaldoNegado()) {
				new Preparo(this.numeroPedido, this.nivelAcucar);
			} else
				throw new DinheiroInsuficienteException();
		} catch (DinheiroInsuficienteException ex) {
			super.println(ex);
			super.pausa(500);
		}
	}

}
