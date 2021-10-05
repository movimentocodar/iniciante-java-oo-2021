package classes.bebidas;

import classes.abstracts.Bebida;

public class Cafe extends Bebida {
	private String nome = "Café";	
	
	public Cafe(int acucar) {
		super.ferverAgua();
		super.usandoIngrediente("Adicionando café", "Concluído!");
		super.acucar(acucar);
		super.terminoBebida(this.nome);
	}
	
}
