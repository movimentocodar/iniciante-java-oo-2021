package classes;
import classes.abstracts.SistemaInterno;

public class EscolhaPedido extends SistemaInterno {
	private int escolhaBebida;
	
	public EscolhaPedido() {
		this.escolha();
	}
	
	public void escolha() {
		
		System.out.println("\n  --------- Selecione uma Opção --------- \n");
		System.out.println("| --> 1. Café .................... R$0.50  |");
		System.out.println("| --> 2. Café com Leite .......... R$1.00  |");
		System.out.println("| --> 3. Capuccino ............... R$1.50  |");
		System.out.println("| --> 4. Chá de Limão ............ R$1.00  |");
		System.out.println("| --> 5. Água Quente ............. Grátis  |");		
		System.out.println("\n ------------- 0. Desliga -------------");
		
		System.out.println("\n ----> Água disponível: " + getReservaAgua() + "ml");
		
		System.out.println("\n -----> Número do Pedido: ");		
		escolhaBebida = super.tryEscolha(0, 5);
		SistemaInterno.pausa(500);
		
		if(escolhaBebida != 0 && escolhaBebida != 5) {
			ProcessandoPedido bebida = new ProcessandoPedido(escolhaBebida);
		} if(escolhaBebida == 5) {
			Preparo bebida = new Preparo(5, 0);
		} if(escolhaBebida == 0) {
			super.carregando("Desligando");
			System.out.println("_____________________________________");
			System.exit(0);
		}
	}
}
