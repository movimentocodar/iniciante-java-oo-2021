package classes.bebidas;

import java.math.BigDecimal;

import classes.abstracts.Bebida;

public class AguaQuente extends Bebida {
	private String nome = "Água quente";
	private BigDecimal preco = new BigDecimal("0.00");
	
	public void preparo() {
		super.usaAgua();
		super.usandoIngrediente("Esquentando água", "\nÁgua esquentada!");
		super.pausa(500);
		super.println("_____________________________________ \n");
		super.println("Pegue sua água!");
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
		return this.nome + " " + super.divisorNomePreco(this.nome.length()) + " Grátis";
	}


}
