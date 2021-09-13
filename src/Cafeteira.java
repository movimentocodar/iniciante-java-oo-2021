import java.util.Scanner;

public class Cafeteira {

	public static void main(String[] args) {
	    
		System.out.println("Bem-vindo a Cafeteria!!\n");
		int inicio;
		
		Pedido pedido = new Pedido();
		Credito credito = new Credito();
		
		do {
			Scanner opcaoInicial = new Scanner(System.in);
		    System.out.println("\nEscolha a opção desejada:\n"
		    		+ "1 - Adicionar Crédito\n"
		    		+ "2 - Realizar Pedido\n"
		    		+ "0 - Finalizar");
	
		    inicio = opcaoInicial.nextInt();
		    System.out.println("Você escolheu: " + inicio);
		    
		    switch(inicio) {
		    case 1:
		    	pedido.AdicionarCredito(credito);
		    	break;
		    case 2:
		    	pedido.realizarPedido(credito);
		    	break;
		    }
		}while(inicio == 1 || inicio == 2);
		System.out.println("Máquina finalizada");
	}
}
