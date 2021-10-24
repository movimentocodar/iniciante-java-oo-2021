package br.com.github.zsguil.maquina_cafe.sistema;

import br.com.github.zsguil.maquina_cafe.classes.service.reservatorio_agua.VerificaQuantidadeDeAguaService;

public final class ReservatorioDeAgua {
	private static int reservatorioAgua = 1000;
	
	public void usaAgua() {
		ReservatorioDeAgua.reservatorioAgua -= 50;
	}
	
	public int getReservatorioAgua() {
		return ReservatorioDeAgua.reservatorioAgua;
	}

	public boolean verificaAgua() {
		return new VerificaQuantidadeDeAguaService()
				.verifica(this.getReservatorioAgua());
	}
	
}
