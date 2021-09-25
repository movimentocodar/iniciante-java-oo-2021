package br.com.movimento.cafeteira.bebidas;
import java.util.Scanner;

public abstract class Bebida{
	
	private int numeroDaOpcao;
//	private int reservatorioAgua = 1000;
//	private int nivelAgua;
		
	public Bebida(int opcao) {
		if(opcao <= 0) {
			System.out.println("\nEntre com uma opção de bebida válida.");
			return;
		}
		this.numeroDaOpcao = opcao;
	}
	
	public abstract void prepararBebida();
	public abstract double getPreco();
	
	public int getNumeroDaOpcao() {
		return numeroDaOpcao;
	}
	
	public int solicitarNivelAcucar() {
		Scanner opcaoAcucar = new Scanner(System.in);
	    System.out.println("\nDeseja alterar o nível(3) padrão de açucar?Entre com o número\n"
	    		+ "1 - 2 - (3) - 4 - 5");

	    int pedidoAcucarUsuario = opcaoAcucar.nextInt();
	    System.out.println("O nível escolhido foi: " + pedidoAcucarUsuario);
	    return pedidoAcucarUsuario;
	}

	
	
//	public boolean confereNivelDeAgua(Bebida agua) {
//		if( agua.getReservatorioAgua() < 50 ) {
//		    System.out.println("\nNível de água baixo. Com " + agua.getReservatorioAgua() + " ml");
//		    return true;
//		}
//		nivelAgua = agua.getReservatorioAgua();
//		nivelAgua -= 50;
//		agua.setReservatorioAgua(nivelAgua);
//		System.out.println("\nReservatório com: " + nivelAgua + "ml.\nFervendo água...");
//		return false;
//	}
	
//	public void abastecerAgua(Bebida agua) {
//		System.out.println("\nAbastecendo nível de água do reservatório.");
//		agua.setReservatorioAgua(1000);
//		System.out.println("\nReservatório agora com " + agua.getReservatorioAgua() + " ml.\n"
//				+ "Fervendo água...");
//	}

//	public int getReservatorioAgua() {
//		return reservatorioAgua;
//	}
//
//	public void setReservatorioAgua(int reservatorioAgua) {
//		this.reservatorioAgua = reservatorioAgua;
//	}
	
}
