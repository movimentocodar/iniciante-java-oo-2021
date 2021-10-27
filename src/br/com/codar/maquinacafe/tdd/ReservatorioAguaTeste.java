package br.com.codar.maquinacafe.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.codar.maquinacafe.ReservatorioAgua;

public class ReservatorioAguaTeste {

	@Test
	public void deveriaAbastecerReservatorio() {
		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecendoReservatorio();

		int aguaConsumida = reservatorio.utilizandoAgua(50);

		assertEquals(950, aguaConsumida);
	}

}