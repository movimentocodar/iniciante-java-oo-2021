package br.com.github.zsguil.maquina_cafe.classes.bebidas;

import java.util.Collections;
import java.util.Map;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.bebida.Bebida;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas.SistemaInterno;

public final class ColecaoBebidas extends SistemaInterno {
	
	private Map<Integer, Bebida> bebidas = Map.of(
				1, new Cafe(),
				2, new CafeLeite(),
				3, new Cappucino(),
				4, new Cha(),
				5, new AguaQuente());
	
	public Map<Integer, Bebida> getBebidas() {
		return Collections.unmodifiableMap(this.bebidas);
	}
}
