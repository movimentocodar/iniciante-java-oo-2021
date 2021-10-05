package classes.bebidas;

import classes.abstracts.Bebida;

public class CafeLeite extends Bebida {
	private String nome = "Café com leite";	
	
	public CafeLeite(int acucar) {
		super.ferverAgua();
		super.usandoIngrediente("Adicionando café", "Concluído!");
		super.usandoIngrediente("Colocando leite", "Pronto!");
		super.acucar(acucar);
		super.terminoBebida(this.nome);
	}
	
}
