package classes.bebidas;

import classes.abstracts.Bebida;

public class Cappucino extends Bebida {
	private String nome = "Cappucino";
	
	public Cappucino(int acucar) {
		super.ferverAgua();
		super.usandoIngrediente("Adicionando café", "Concluído!");
		super.usandoIngrediente("Colocando leite", "Pronto!");
		super.usandoIngrediente("Adicionando chocolate", "Feito!");
		super.acucar(acucar);
		super.terminoBebida(this.nome);
	}
	
}
