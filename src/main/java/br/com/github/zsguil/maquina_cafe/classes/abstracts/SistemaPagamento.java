package br.com.github.zsguil.maquina_cafe.classes.abstracts;

import java.math.BigDecimal;

import br.com.zsguil.maquina_cafe.exceptions.DinheiroInsuficienteException;

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
		return SistemaPagamento.credito;
	}

	protected BigDecimal determinaPreco(int numero) {
		BigDecimal preco = super.getBebidas().get(numero).getPreco();
		return preco;
	}

	protected void atualizaCredito(int dinheiro, BigDecimal preco) {
		BigDecimal dinheiroDecimal = new BigDecimal(dinheiro);
		super.println(dinheiroDecimal);
		SistemaPagamento.credito = SistemaPagamento.credito.add(dinheiroDecimal).subtract(preco);
	}

	protected void atualizaCredito(BigDecimal dinheiro, BigDecimal preco) {
		SistemaPagamento.credito = SistemaPagamento.credito.add(dinheiro).subtract(preco);
	}

	protected boolean checaCredito(BigDecimal preco) {
		if (SistemaPagamento.credito.compareTo(preco) >= 0)
			return true;
		else
			return false;
	}

	public boolean insereDinheiro(int numeroPedido, int dinheiro) {

		BigDecimal preco = determinaPreco(numeroPedido);

		if (!this.checaCredito(preco)) {
			try {
				switch (dinheiro) {
				case 2, 5, 10, 20, 50, 100: {
					this.atualizaCredito(dinheiro, preco);
					break;
				}
				default:
					throw new IllegalArgumentException(
							"Valor inesperado: nota inválida. \n " + "Insira uma nota existente abaixo:");
				}
			} catch (IllegalArgumentException ex) {
				super.println(ex);
				insereDinheiro(numeroPedido, super.nextInt());
			}

			super.println("\n Pagamento efetuado com sucesso! " + "Você tem agora R$ " + SistemaPagamento.credito
					+ " de crédito em descontos!");
			super.pausa(500);
			return true;
			
		} else {
			super.println("\n Pagamento efetuado com créditos! " + "Você tem agora R$ " + SistemaPagamento.credito
					+ " de crédito em descontos!");
			super.pausa(500);
			return true;
		}		
	}

	public boolean usaDebito(int numeroPedido, BigDecimal dinheiro) {
		BigDecimal preco = determinaPreco(numeroPedido);

		if (!this.checaCredito(preco)) {
			try {
				if (dinheiro.add(SistemaPagamento.credito).compareTo(preco) < 0) {
					throw new DinheiroInsuficienteException();
				} else {
					this.atualizaCredito(dinheiro, preco);
					super.println("Pagamento efetuado com sucesso! " + "Você tem agora R$ " + SistemaPagamento.credito
							+ " de crédito em descontos!");
					return true;
				}
			} catch (DinheiroInsuficienteException ex) {
				SistemaPagamento.saldoNegado = true;
				return false;
			}
		} else {
			super.println("Pagamento efetuado com créditos! " + "Você tem agora R$ " + SistemaPagamento.credito
					+ "de crédito em descontos!");
			return true;
		}
	}

}
