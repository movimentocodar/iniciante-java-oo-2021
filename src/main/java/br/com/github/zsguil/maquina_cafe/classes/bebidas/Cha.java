package br.com.github.zsguil.maquina_cafe.classes.bebidas;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.classes.abstracts.Bebida;
import br.com.zsguil.maquina_cafe.interfaces.BebidasEspeciais;

public class Cha extends Bebida implements BebidasEspeciais {
	private String nome = "Chá de limão";
	private BigDecimal preco = new BigDecimal("1.00");
	
	@Override
	public void preparo(int acucar) {
		super.ferverAgua();
		super.usandoIngrediente("Adicionando chá", "Pronto!");
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
