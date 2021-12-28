package br.com.mentoria.cafeteira.cafeteira;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReservatorioAguaTest {

	@Test
	void deveriaUtilizarAguaReservatorio() {
		ReservatorioAgua reservatorio = new ReservatorioAgua();
		reservatorio.abastecerAgua();
		
		int usoAgua = reservatorio.utilizarAgua(50);
		
		assertEquals(950, usoAgua);
	}


}
