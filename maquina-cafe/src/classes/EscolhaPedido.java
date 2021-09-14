package classes;
import abstracts.SistemaInterno;

public class EscolhaPedido extends SistemaInterno {
	private int escolhaBebida;
	
	public EscolhaPedido() {
		this.escolha();
	}
	
	public void escolha() {
		
		System.out.println("\n  --------- Selecione uma Op��o --------- \n");
		System.out.println("| --> 1. Caf� .................... R$0.50  |");
		System.out.println("| --> 2. Caf� com Leite .......... R$1.00  |");
		System.out.println("| --> 3. Capuccino ............... R$1.50  |");
		System.out.println("| --> 4. Ch� de Lim�o ............ R$1.00  |");
		System.out.println("| --> 5. �gua Quente ............. Gr�tis  |");		
		System.out.println("\n ------------- 0. Desliga -------------");
		
		System.out.println("\n -----> N�mero do Pedido: ");		
		escolhaBebida = super.tryEscolha(0, 5);
		super.pausa(500);
		
		if(escolhaBebida != 0) {
			ProcessandoPedido bebida = new ProcessandoPedido(escolhaBebida);
		} if(escolhaBebida == 5) {
			Preparo bebida = new Preparo(5);
		} else {
			super.carregando("Desligando");
			System.out.println("_____________________________________");
			System.exit(0);
		}
	}
}
