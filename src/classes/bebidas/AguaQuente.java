package classes.bebidas;

import classes.abstracts.Bebida;
import classes.abstracts.SistemaInterno;

public class AguaQuente extends Bebida {

	public AguaQuente() {
		super.usaAgua();
		super.usandoIngrediente("Esquentando água", "Água esquentada!");
		SistemaInterno.pausa(500);
		System.out.println("_____________________________________ \n");
		System.out.println("Pegue sua água!");
	}
	
	
}
