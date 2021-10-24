package br.com.github.zsguil.maquina_cafe.sistema.abstracts.classes.maquina;

import br.com.github.zsguil.maquina_cafe.sistema.ReservatorioDeAgua;

public abstract class MaquinaCafe {
	private ReservatorioDeAgua reservatorioAgua = new ReservatorioDeAgua();

	public ReservatorioDeAgua getReservatorioAgua() {
		return reservatorioAgua;
	}

}
