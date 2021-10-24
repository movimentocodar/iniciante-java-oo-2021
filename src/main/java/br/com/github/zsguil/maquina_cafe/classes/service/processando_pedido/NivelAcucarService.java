package br.com.github.zsguil.maquina_cafe.classes.service.processando_pedido;

import java.util.InputMismatchException;

import br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.interacao_com_usuario.InteracaoComUsuario;

public final class NivelAcucarService extends InteracaoComUsuario {
	
	public int escolher() {
		super.text().println("Deseja escolher o nível de açúcar? S/N");
		
		int escolhaNivel = this.validarResposta(super.scanner().nextLine());

		return escolhaNivel;

	}
	
	public int validarResposta(String escolha) {
		int escolhaNivel = 3;

		try {
		
			switch (escolha) {
			case "N", "n": {
				break;
			}
			case "S", "s": {
				super.text().println("Colheres de açúcar: 0-5. Escolha:");
				escolhaNivel = super.escolher(0, 5);
				break;
			}
			default:
				throw new InputMismatchException("Caractere inválido: " 
						+ escolha + ". Responda com S ou N.");
			}
			
		} catch (InputMismatchException ex) {
			ex.printStackTrace();
			super.pausar(500);
			this.escolher();
		}
		
		return escolhaNivel;
	}
}
