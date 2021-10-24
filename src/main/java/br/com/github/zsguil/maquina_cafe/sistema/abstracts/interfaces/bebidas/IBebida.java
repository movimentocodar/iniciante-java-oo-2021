package br.com.github.zsguil.maquina_cafe.sistema.abstracts.interfaces.bebidas;

import java.math.BigDecimal;

public interface IBebida {

	public String getNome();
	
	public BigDecimal getPreco();
	
	@Override
	public String toString();
	
	public void preparo();
	
}
