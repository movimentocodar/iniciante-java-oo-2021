package br.com.github.zsguil.maquina_cafe.sistema;

import br.com.github.zsguil.maquina_cafe.classes.service.reservatorio_agua.VerificaQuantidadeDeAguaService;

public final class ReservatorioDeAgua {
	private static int reservatorioAgua = 1000;
	
	public void usarAgua() {
		ReservatorioDeAgua.reservatorioAgua -= 50;
	}
	
	public int getReservatorioAgua() {
		return ReservatorioDeAgua.reservatorioAgua;
	}

	public boolean verificarAgua() {
		return new VerificaQuantidadeDeAguaService()
				.verificar(this.getReservatorioAgua());
	}
	
}
