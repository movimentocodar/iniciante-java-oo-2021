package classes.abstracts;

import exceptions.DinheiroInsuficienteException;

public abstract class SistemaPagamento extends SistemaInterno {
	private static double credito;
	private static boolean saldoNegado = false;
	

	public static boolean getSaldoNegado() {
		return SistemaPagamento.saldoNegado;
	}
	
	private double determinaPreco(int numero) {
		double preco;

		switch (numero) {
		case 2, 4: {
			preco = 1.00;
			break;
		}
		case 3: {
			preco = 1.50;
			break;
		}
		default: {
			preco = 0.50;
		}
		}

		return preco;
	}

	private void atualizaCredito(int dinheiro, double preco) {
		SistemaPagamento.credito = 
				(dinheiro + SistemaPagamento.credito) - preco;
	}
	
	private void atualizaCredito(double dinheiro, double preco) {
		SistemaPagamento.credito = 
			(dinheiro + SistemaPagamento.credito) - preco;
	}

	private boolean checaCredito(double preco) {
		if (preco <= SistemaPagamento.credito) {
			return true;
		} else
			return false;
	}

	public void insereDinheiro(int numeroPedido) {
		
		double preco = determinaPreco(numeroPedido);
		int dinheiro;
		
		if(!this.checaCredito(preco)) {
			try {
				dinheiro = super.input.nextInt();
			
				switch (dinheiro) {
				case 2, 5, 10, 20, 50, 100: {
					this.atualizaCredito(dinheiro, preco);
					break;
				}
				default:
					throw new IllegalArgumentException();
				}
			} catch(IllegalArgumentException ex) {
				System.out.println(ex + "Valor inesperado: "
						+ "nota inválida. \n "
						+ "Insira uma nota existente.");
				insereDinheiro(numeroPedido);
			}
			
			System.out.println("Pagamento efetuado com sucesso! "
					+ "Você tem agora R$ " + SistemaPagamento.credito +
					" de crédito em descontos! \n");
		} else {
			System.out.println("Pagamento efetuado com créditos! "
					+ "Você tem agora R$ " + SistemaPagamento.credito +
					" de crédito em descontos! \n");
			SistemaInterno.pausa(500);
		}
	}

	public void usaDebito(int numeroPedido) {
		double preco = determinaPreco(numeroPedido);
		
		if(!this.checaCredito(preco)) {
			try {
				double dinheiro = super.input.nextDouble();
				
				if (dinheiro + SistemaPagamento.credito >= preco) {
					this.atualizaCredito(dinheiro, preco);
					System.out.println("Pagamento efetuado com sucesso! "
							+ "Você tem agora R$ " + SistemaPagamento.credito
							+ " de crédito em descontos!");
				} else {
					throw new DinheiroInsuficienteException();
				}
			} catch (DinheiroInsuficienteException ex) {
				SistemaPagamento.saldoNegado = true;
			}
		} else {
			System.out.println("Pagamento efetuado com créditos! "
					+ "Você tem agora R$ " + SistemaPagamento.credito +
					"de crédito em descontos! \n");
		}
	}

}
