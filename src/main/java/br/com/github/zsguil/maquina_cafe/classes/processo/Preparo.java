package br.com.github.zsguil.maquina_cafe.classes.processo;

import br.com.github.zsguil.maquina_cafe.classes.bebidas.AguaQuente;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.bebidas.IBebidaEspecial;

public class Preparo extends InteracaoComUsuario {
	private int escolha;
		
	public Preparo(int escolha) {
		this.escolha = escolha;
	}
	
	
	// Preparando as bebidas
	
	public void prepararBebida(int acucar) {
		super.pausar(500);
		IBebidaEspecial bebida = (IBebidaEspecial) super.getBebidas().get(this.escolha);
		bebida.separarAcucar(acucar);
		bebida.preparar();
		super.pausar(2000);
	}
	
	public void prepararBebida() {
		super.pausar(500);
		AguaQuente bebida = (AguaQuente) super.getBebidas().get(5);
		bebida.preparar();
		super.pausar(2000);
	}
}
