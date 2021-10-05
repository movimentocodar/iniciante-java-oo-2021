package classes.bebidas;

import java.math.BigDecimal;

import classes.abstracts.Bebida;
import interfaces.BebidasEspeciais;

public class CafeLeite extends Bebida implements BebidasEspeciais {
	private String nome = "Café com leite";
	private BigDecimal preco = new BigDecimal("1.00");
	
		
	@Override
	public void preparo(int acucar) {
		super.ferverAgua();
		super.usandoIngrediente("Adicionando café", "Concluído!");
		super.usandoIngrediente("Colocando leite", "Pronto!");
		super.acucar(acucar);
		super.terminoBebida(this.nome);
	}
	
	@Override
	public BigDecimal getPreco() {
		return this.preco;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String toString() {
		return this.nome + " " + super.divisorNomePreco(this.nome.length()) 
			+ " R$" + this.preco;
	}
	
}
