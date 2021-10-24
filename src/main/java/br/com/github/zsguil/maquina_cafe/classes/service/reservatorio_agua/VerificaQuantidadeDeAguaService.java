package br.com.github.zsguil.maquina_cafe.classes.service.reservatorio_agua;

import br.com.github.zsguil.maquina_cafe.sistema.exceptions.FaltaAguaException;

public final class VerificaQuantidadeDeAguaService {

	public boolean verifica(int agua) {
		try {
			if(agua >= 50) {
				return true;
			} else {
				throw new FaltaAguaException();
			}
		} catch (FaltaAguaException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
}
