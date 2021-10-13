package br.com.mentoria.cafeteira.cafeteira;

public class Credito{
	
	private double valorTotalCreditos;
	
	public double adicionarCredito(double valorCredito) {
		
		double total = getValorTotalCreditos();
		if(valorCredito < 0) {
			throw new IllegalArgumentException("Valor de créditos inválido");
		}
		double ajusteCredito = total + valorCredito;
		setValorTotalCreditos(ajusteCredito);
		
		return ajusteCredito;
		
	}
	
	public double calcularTroco(double valorProduto) {
		Display display = new Display();
		 
		double valorCredito = getValorTotalCreditos();
		if(valorCredito < valorProduto) {
			throw new IllegalArgumentException("Saldo insuficiente, adicione mais créditos");
		}
		
		valorCredito -= valorProduto;
		setValorTotalCreditos(valorCredito);
		
		display.imprime("\nDevolvendo o troco de: R$ " + valorCredito);
		
		double troco = valorCredito;
		
		valorCredito = 0;
		setValorTotalCreditos(valorCredito);
		
		return troco;
	}

	public double getValorTotalCreditos() {
		return valorTotalCreditos;
	}

	public void setValorTotalCreditos(double valorTotalCreditos) {
		this.valorTotalCreditos = valorTotalCreditos;
	}	

}
