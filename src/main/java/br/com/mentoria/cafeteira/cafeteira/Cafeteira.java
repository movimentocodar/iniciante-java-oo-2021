package br.com.mentoria.cafeteira.cafeteira;

public class Cafeteira {

	public static void main(String[] args) {
		
		Display display = new Display();
		
		display.imprime("Bem-vindo a Cafeteira!!\n");
		
		Menu menu = new Menu();
		menu.menuInicial();
		
		display.imprime("Máquina finalizada");

	}
}
