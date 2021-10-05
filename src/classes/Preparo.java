package classes;

import java.util.InputMismatchException;

import classes.abstracts.SistemaInterno;
import classes.abstracts.SistemaPagamento;
import classes.bebidas.AguaQuente;
import classes.bebidas.Cafe;
import classes.bebidas.CafeLeite;
import classes.bebidas.Cappucino;
import classes.bebidas.Cha;
import exceptions.DinheiroInsuficienteException;

public class Preparo extends SistemaInterno {
	private int escolha;
	private int acucar;
	
	public Preparo(int escolha, int acucar) {
		this.escolha = escolha;
		this.acucar = acucar;
		
		if(escolha != 5) {
			try {
				if(!SistemaPagamento.getSaldoNegado()) {
					this.preparo();
				} else throw new DinheiroInsuficienteException();
			} catch (DinheiroInsuficienteException ex) {
				System.out.println(ex);
				SistemaInterno.pausa(500);
				SistemaInterno.repetir();
			}
		} else { 
			this.preparo();
			SistemaInterno.pausa(500);
		}
	}
		
	
	// Preparando as bebidas
	
	public void preparo() {
		switch (this.escolha) {
		case 1:
			new Cafe(this.acucar);
			break;
		case 2:
			new CafeLeite(this.acucar);
			break;
		case 3:
			new Cappucino(this.acucar);
			break;
		case 4:
			new Cha(this.acucar);
			break;
		case 5:
			new AguaQuente();
			break;
		}
	}
}
