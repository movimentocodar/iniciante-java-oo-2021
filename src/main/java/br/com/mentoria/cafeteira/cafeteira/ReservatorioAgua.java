package br.com.mentoria.cafeteira.cafeteira;

import java.util.Scanner;

public class ReservatorioAgua {
	
	private int nivelAgua;
	
	Display display = new Display();

	public void confereNivelDeAgua() {
		int reservatorio = getNivelAgua();
		
		if (reservatorio < 50) {
			display.imprime("\nNível de água baixo. Com " + reservatorio + " ml");
			int abastecer;
			
			do {
				Scanner opcaoAbastecer = new Scanner(System.in);
				display.imprime("\nNível de água baixo. Deseja abastecer o reservatório?"
						+ "\n1 - Sim"
						+ "\n2 - Não");
				abastecer = opcaoAbastecer.nextInt();
			}while(abastecer == 2);
			
			if(abastecer == 1) abastecerAgua();			
			
		}	
		
	}

	public void abastecerAgua() {
		
		setNivelAgua(1000);
		int reservatorio = getNivelAgua();
		
		display.imprime("\nAbastecendo nível de água do reservatório."
				+ "\nReservatório agora com " + reservatorio + " ml.");
	}
	
	public int getNivelAgua() {
		return nivelAgua;
	}
	
	public void setNivelAgua(int nivelAgua) {
		this.nivelAgua = nivelAgua;
	}

	public int utilizarAgua(int usoAgua) {
		int nivelTotal = getNivelAgua();
		nivelTotal -= usoAgua;
		setNivelAgua(nivelTotal);
		display.imprime("Utilizados " + usoAgua +"ml de água."
				+ "\nNível atual de água: " + nivelTotal + "ml.");
		return nivelTotal;
	}

}
