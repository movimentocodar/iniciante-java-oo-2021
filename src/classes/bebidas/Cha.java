package classes.bebidas;

import classes.abstracts.Bebida;

public class Cha extends Bebida {
	private String nome = "Chá de limão";
	
	public Cha(int acucar) {
		super.ferverAgua();
		super.usandoIngrediente("Adicionando chá", "Pronto!");
		super.acucar(acucar);
		super.terminoBebida(this.nome);
	}

}
