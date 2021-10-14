package br.com.github.zsguil.maquina_cafe.classes;

import br.com.github.zsguil.maquina_cafe.classes.abstracts.SistemaInterno;
import br.com.github.zsguil.maquina_cafe.classes.bebidas.AguaQuente;
import br.com.zsguil.maquina_cafe.interfaces.BebidasEspeciais;

public class Preparo extends SistemaInterno {
	private int escolha;
		
	public Preparo(int escolha, int acucar) {
		this.escolha = escolha;
		this.preparoDaBebida(acucar);
	}
	
	public Preparo(int escolha) {
		this.preparoDaBebida();
		super.pausa(500);
	}
	
	// Preparando as bebidas
	
	public void preparoDaBebida(int acucar) {				
		BebidasEspeciais bebida = (BebidasEspeciais) super.getBebidas().get(this.escolha);
		bebida.preparo(acucar);
		super.pausa(2000);
	}
	
	public void preparoDaBebida() {
		AguaQuente bebida = (AguaQuente) super.getBebidas().get(5);
		bebida.preparo();
		super.pausa(2000);
	}
}
