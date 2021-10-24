package br.com.github.zsguil.maquina_cafe.classes.bebidas;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.bebida.Bebida;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.bebidas.IBebidaEspecial;

public class Cha extends Bebida implements IBebidaEspecial {
	private String nome = "Chá de limão";
	private BigDecimal preco = new BigDecimal("1.00");
	private int nivelAcucar;
	
	@Override
	public void preparar() {
		super.novoProcesso().ferverAgua();
		super.novoProcesso().usarIngrediente("Adicionando chá", "\n Concluído!");
		this.usarAcucar();
		super.novoProcesso().terminarBebida(this.nome);	
	}
	
	@Override
	public void separarAcucar(int acucar) {
		this.nivelAcucar = acucar;
	}

	@Override
	public void usarAcucar() {
		if(this.nivelAcucar != 0)
			super.novoProcesso()
			.usarIngrediente("Colocando " + this.nivelAcucar + " colheres de açúcar", "Açúcar adicionado");
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
		return this.nome + " " + super.gerarDivisorNomePreco(this.nome.length()) 
			+ " R$" + this.preco;
	}
	
}
