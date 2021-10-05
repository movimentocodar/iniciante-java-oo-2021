package br.com.codar.maquinacafe;

public class ReservatorioAgua {
	
	private int nivelAgua;
	private int reservatorio;
	
	
	public int getNivelAgua() {
		return nivelAgua;
	}
	
	public void setNivelAgua(int nivelAgua) {
		this.nivelAgua = nivelAgua;
	}

	public int getReservatorio() {
		return reservatorio;
	}
	
	public void conferindoReservatorio() {
		int reservatorio = getNivelAgua();
		
		if(reservatorio == 0) {
			abastecendoReservatorio();
		}
	}
	
	public void abastecendoReservatorio() {
		setNivelAgua(1000);
		int reservatorio = getNivelAgua();
	}
	
}