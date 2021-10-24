package br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.sistemas;

import java.util.Map;

import br.com.github.zsguil.maquina_cafe.classes.bebidas.ColecaoBebidas;
import br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno.PrintService;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.bebida.Bebida;
import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.maquina.MaquinaCafe;

public abstract class SistemaInterno extends MaquinaCafe {
	private final PrintService printService = new PrintService();
	private final static Map<Integer, Bebida> bebidas = new ColecaoBebidas().getBebidas();

	public PrintService text() {
		return this.printService;
	}

	public Map<Integer, Bebida> getBebidas() {
		return SistemaInterno.bebidas;
	}

}
