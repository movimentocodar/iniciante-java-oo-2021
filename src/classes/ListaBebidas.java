package classes;

import java.util.ArrayList;
import java.util.List;

import classes.abstracts.Bebida;
import classes.abstracts.SistemaInterno;
import classes.bebidas.AguaQuente;
import classes.bebidas.Cafe;
import classes.bebidas.CafeLeite;
import classes.bebidas.Cappucino;
import classes.bebidas.Cha;

public class ListaBebidas extends SistemaInterno {
	private List<Bebida> bebidas = new ArrayList<>();
	
	public void adicionaItens() {
		Bebida[] arrayBebidas = 
			{new Cafe(), new CafeLeite(), new Cappucino(), new Cha(),new AguaQuente()};
		
		for(Bebida bebiba : arrayBebidas) {
			this.bebidas.add(bebiba);
		}

		super.armazenaLista(this.bebidas);
	}
	
	public void removeItens() {
		this.bebidas.clear();
	}
	
	// DEFINE TAMANHO DO DIVISOR ENTRE NOME E PREÇO
	public static String divisorNomePreco(int caracteres) {
		String divisor = "";
		
		for(int i = 0; i < (24 - caracteres); i++) {
			divisor += ".";
		}
		
		return divisor;
	}

}
