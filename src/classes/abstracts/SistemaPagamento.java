package classes.abstracts;

import java.math.BigDecimal;

import exceptions.DinheiroInsuficienteException;

public abstract class SistemaPagamento extends SistemaInterno {
	private static BigDecimal credito = new BigDecimal("0.00");
	private static boolean saldoNegado = false;

	public static boolean getSaldoNegado() {
		return SistemaPagamento.saldoNegado;
	}

	public static void resetVerificacaoSaldo() {
		SistemaPagamento.saldoNegado = false;
	}

	public static BigDecimal getCredito() {
		return credito;
	}

	private BigDecimal determinaPreco(int numero) {
		BigDecimal preco = super.getBebidas().get(numero - 1).getPreco();
		return preco;
	}

	private void atualizaCredito(int dinheiro, BigDecimal preco) {
		BigDecimal dinheiroDecimal = new BigDecimal(dinheiro);
		super.println(dinheiroDecimal);
		SistemaPagamento.credito = SistemaPagamento.credito.add(dinheiroDecimal).subtract(preco);
	}

	private void atualizaCredito(BigDecimal dinheiro, BigDecimal preco) {
		SistemaPagamento.credito = SistemaPagamento.credito.add(dinheiro).subtract(preco);
	}

	private boolean checaCredito(BigDecimal preco) {
		if (SistemaPagamento.credito.compareTo(preco) == 1) {
			return true;
		} else
			return false;
	}

	public void insereDinheiro(int numeroPedido) {

		BigDecimal preco = determinaPreco(numeroPedido);
		int dinheiro;

		if (!this.checaCredito(preco)) {
			try {
				dinheiro = super.input.nextInt();

				switch (dinheiro) {
				case 2, 5, 10, 20, 50, 100: {
					this.atualizaCredito(dinheiro, preco);
					break;
				}
				default:
					throw new IllegalArgumentException(
							"Valor inesperado: nota inválida. \n " + "Insira uma nota existente.");
				}
			} catch (IllegalArgumentException ex) {
				super.println(ex);
				insereDinheiro(numeroPedido);
			}

			super.println("\n Pagamento efetuado com sucesso! " + "Você tem agora R$ " + SistemaPagamento.credito
					+ " de crédito em descontos!");
			super.pausa(500);

		} else {
			super.println("\n Pagamento efetuado com créditos! " + "Você tem agora R$ " + SistemaPagamento.credito
					+ " de crédito em descontos!");
			super.pausa(500);
		}
	}

	public void usaDebito(int numeroPedido) {
		BigDecimal preco = determinaPreco(numeroPedido);

		if (!this.checaCredito(preco)) {
			try {
				BigDecimal dinheiro = super.input.nextBigDecimal();

				if (dinheiro.add(SistemaPagamento.credito).compareTo(preco) == -1) {
					throw new DinheiroInsuficienteException();
				} else {
					this.atualizaCredito(dinheiro, preco);
					super.println("Pagamento efetuado com sucesso! " + "Você tem agora R$ " + SistemaPagamento.credito
							+ " de crédito em descontos!");

				}
			} catch (DinheiroInsuficienteException ex) {
				SistemaPagamento.saldoNegado = true;
			}
		} else {
			super.println("Pagamento efetuado com créditos! " + "Você tem agora R$ " + SistemaPagamento.credito
					+ "de crédito em descontos!");
		}
	}

}
