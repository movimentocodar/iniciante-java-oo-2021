package classes;

import classes.abstracts.SistemaInterno;
import classes.abstracts.SistemaPagamento;
import classes.bebidas.AguaQuente;
import exceptions.DinheiroInsuficienteException;
import interfaces.BebidasEspeciais;

public class Preparo extends SistemaInterno {
	private int escolha;
		
	public Preparo(int escolha, int acucar) {
		this.escolha = escolha;
		this.preparo(acucar);
	}
	
	public Preparo(int escolha) {
		this.preparo();
		super.pausa(500);
	}
	
	// Preparando as bebidas
	
	public void preparo(int acucar) {				
		BebidasEspeciais bebida = (BebidasEspeciais) super.getBebidas().get(this.escolha - 1);
		bebida.preparo(acucar);
		super.pausa(2000);
	}
	
	public void preparo() {
		AguaQuente bebida = (AguaQuente) super.getBebidas().get(4);
		bebida.preparo();
		super.pausa(2000);
	}
}
