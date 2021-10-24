package br.com.github.zsguil.maquina_cafe.classes.service.interacao_com_usuario;

import java.util.InputMismatchException;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;
import br.com.github.zsguil.maquina_cafe.sistema.exceptions.EscolhaErradaException;

public final class ValidadorDeEscolhasService extends InteracaoComUsuario {

	public int tryEscolha(int minimo, int limite) {
		int escolha = 0;

		try {
			escolha = super.scanner().nextInt();
			
			try {
				
				this.validarEscolha(minimo, limite, escolha);
				
			} catch (EscolhaErradaException ex) {
				this.pausar(500);
				super.text().println(ex);
				super.text().println("");
				super.scanner().reset();
				super.text().println("Insira novamente:");
				super.scanner().next();
				this.tryEscolha(minimo, limite);
			}
			
		} catch (InputMismatchException ex) {
			super.text().println(ex + ": Caractere inválido. Insira um número.");
			super.text().println("");
			super.scanner().reset();
			super.scanner().next();
			super.text().println("Insira novamente:");
			this.escolher(minimo, limite);
		}

		return escolha;
		
	}
	
	public void validarEscolha(int minimo, int limite, int escolha) {
		if (escolha < minimo || escolha > limite)
			throw new EscolhaErradaException(escolha, limite, minimo);
	}

	
}
