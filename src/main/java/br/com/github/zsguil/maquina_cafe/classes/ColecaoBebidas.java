package br.com.github.zsguil.maquina_cafe.classes;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.github.zsguil.maquina_cafe.classes.abstracts.Bebida;
import br.com.github.zsguil.maquina_cafe.classes.abstracts.SistemaInterno;
import br.com.github.zsguil.maquina_cafe.classes.bebidas.AguaQuente;
import br.com.github.zsguil.maquina_cafe.classes.bebidas.Cafe;
import br.com.github.zsguil.maquina_cafe.classes.bebidas.CafeLeite;
import br.com.github.zsguil.maquina_cafe.classes.bebidas.Cappucino;
import br.com.github.zsguil.maquina_cafe.classes.bebidas.Cha;

public class ColecaoBebidas extends SistemaInterno {
	private Map<Integer, Bebida> bebidas = new LinkedHashMap<>();
	
	public void adicionaItens() {
		Bebida[] arrayBebidas = 
			{new Cafe(), new CafeLeite(), new Cappucino(), new Cha(),new AguaQuente()};
		
		int key = 0;
		
		for(Bebida bebiba : arrayBebidas) {
			key++;
			this.bebidas.put(key, bebiba);
		}
		
		super.armazenaBebidas(this.bebidas);
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
