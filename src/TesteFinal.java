import java.util.Scanner;

public class TesteFinal { // Realize o teste do c�digo por aqui, obrigado!
	
	public static void main(String[] args) {
		
		Pedido pedido = new Pedido();
		int realizarPedido;
		
			Scanner pedidoInicial = new Scanner (System.in);
			System.out.println("Gostaria de fazer um pedido?\n"
								+ "1 - Sim\n"
								+ "2 - N�o");
			
			realizarPedido = pedidoInicial.nextInt();
			System.out.println("Voc� escolheu: " + realizarPedido);
			
			switch(realizarPedido) {
			case 1:
				pedido.realizarPedido();
				break;
			case 2:
				System.out.println("Obrigado e volte sempre!");
				break;
			}
		}
	}

// Desenvolvido por Gabriel Trudes Melo