package br.com.github.zsguil.maquina_cafe.classes.bebidas;

import java.math.BigDecimal;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.bebida.Bebida;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.bebidas.IBebida;

public class AguaQuente extends Bebida implements IBebida {
	private String nome = "Água quente";
	private BigDecimal preco = BigDecimal.ZERO;
	
	@Override
	public void preparar() {
		super.getReservatorioAgua().usarAgua();
		super.novoProcesso().usarIngrediente("Esquentando água", "\nÁgua esquentada!");
		super.pausar(500);
		super.text().println("_____________________________________ \n");
		super.text().println("Pegue sua água!");
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public BigDecimal getPreco() {
		return this.preco;
	}
	
	@Override
	public String toString() {
		return this.nome + " " + super.gerarDivisorNomePreco(this.nome.length()) + " Grátis";
	}


}
