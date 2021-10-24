package br.com.github.zsguil.maquina_cafe.classes.bebidas;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.bebida.Bebida;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.bebidas.IBebidaEspecial;

public class Cha extends Bebida implements IBebidaEspecial {
	private String nome = "Chá de limão";
	private BigDecimal preco = new BigDecimal("1.00");
	private int nivelAcucar;
	
	@Override
	public void preparo() {
		super.novoProcesso().ferverAgua();
		super.novoProcesso().usandoIngrediente("Adicionando chá", "\n Concluído!");
		this.usaAcucar();
		super.novoProcesso().terminoBebida(this.nome);	
	}
	
	@Override
	public void separaAcucar(int acucar) {
		this.nivelAcucar = acucar;
	}

	@Override
	public void usaAcucar() {
		if(this.nivelAcucar != 0)
			super.novoProcesso()
			.usandoIngrediente("Colocando " + this.nivelAcucar + " colheres de açúcar", "Açúcar adicionado");
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
