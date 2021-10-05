package classes;
import java.math.BigDecimal;
import java.util.List;

import classes.abstracts.Bebida;
import classes.abstracts.SistemaInterno;
import classes.abstracts.SistemaPagamento;

public class EscolhaPedido extends SistemaInterno {
	private int escolhaBebida;
	
	public void escolha() {
		
		ListaBebidas lista = new ListaBebidas();
		lista.adicionaItens();
		List<Bebida> bebidas = super.getBebidas();

		super.println("\n  --------- Selecione uma Opção --------- \n");

		bebidas.forEach(bebida -> {
			super.println("| --> " + (bebidas.indexOf(bebida) + 1) 
					+ ". " + bebida.toString() + " |");
		});
		
		super.println("\n ------------- 0. Desliga -------------");
	
		super.print("\n ----> Água disponível: " + super.getReservaAgua() + "ml");
		super.println("\n ----> Crédito: R$ " + SistemaPagamento.getCredito());
		
		super.println("\n -----> Número do Pedido: ");		
		escolhaBebida = super.tryEscolha(0, super.getBebidas().size());
		super.println("");
		super.pausa(500);
		
		// Captura posição da água com base no preço gratuito para usar na condicional seguinte
		int precoBebida = 
				super.getBebidas().get(escolhaBebida - 1).getPreco().compareTo(new BigDecimal("0.00"));
		
		if(escolhaBebida != 0 && precoBebida != 0) {
			if(super.verificaAgua()) {
				new ProcessandoPedido(escolhaBebida);
			}
		} else if(precoBebida == 0) {
			if(super.verificaAgua()) {
				new Preparo(5);
			}
		} else {
			super.carregando("Desligando");
			super.println("_____________________________________");
			System.exit(0);
		}
		
		lista.removeItens();
		super.println("\n \n \n \n \n \n \n \n \n");
		
	}
}
