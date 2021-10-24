package br.com.github.zsguil.maquina_cafe.classes.processo;

import br.com.github.zsguil.maquina_cafe.classes.bebidas.AguaQuente;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.bebidas.IBebidaEspecial;

public class Preparo extends InteracaoComUsuario {
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
		IBebidaEspecial bebida = (IBebidaEspecial) super.getBebidas().get(this.escolha);
		bebida.separaAcucar(acucar);
		bebida.preparo();
		super.pausa(2000);
	}
	
	public void preparoDaBebida() {
		AguaQuente bebida = (AguaQuente) super.getBebidas().get(5);
		bebida.preparo();
		super.pausa(2000);
	}
}
