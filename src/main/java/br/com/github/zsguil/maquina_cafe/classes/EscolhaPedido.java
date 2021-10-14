package br.com.github.zsguil.maquina_cafe.classes;

import java.util.Map;

import br.com.github.zsguil.maquina_cafe.classes.abstracts.Bebida;
import br.com.github.zsguil.maquina_cafe.classes.abstracts.SistemaInterno;
import br.com.github.zsguil.maquina_cafe.classes.abstracts.SistemaPagamento;

public class EscolhaPedido extends SistemaInterno {
	private int escolhaBebida;
	private ColecaoBebidas colecaoBebidas;
	private ProcessandoPedido pedido;
	
	public void escolha() {
				
		this.mostraOpcoesBebidas(this.getColecaoBebidas());
				
		super.println("\n -----> Número do Pedido: ");		
		
		this.escolhaBebida = super.tryEscolha(0, super.getBebidas().size());
		
		super.println("");
		super.pausa(500);

		if(super.verificaAgua(super.getReservaAgua())) {
			switch (escolhaBebida) {
				case 0: {
					super.carregando("Desligando");
					super.println("_____________________________________");
					System.exit(0);
				}
				case 5: {
					new Preparo(5);
					break;
				}
				default: {
					this.pedido = new ProcessandoPedido();
					pedido.processando(escolhaBebida);
					pedido.escolheNivelAcucar();
					pedido.escolheFormaPagamento();
					pedido.iniciaPreparo();
				}
			}
		}
		
		super.println("\n \n \n \n \n \n \n \n \n");

		
	}

	private Map<Integer, Bebida> getColecaoBebidas() {
		this.colecaoBebidas = new ColecaoBebidas();
		this.colecaoBebidas.adicionaItens();
		return super.getBebidas();
	}
	
	private void mostraOpcoesBebidas(Map<Integer, Bebida> bebidas) {
		super.println("\n  --------- Selecione uma Opção --------- \n");

		for (Map.Entry<Integer, Bebida> bebida : bebidas.entrySet()) {
			super.println("| --> " + bebida.getKey() + ". " + bebida.getValue() + " |");
		}
				
		super.println("\n ------------- 0. Desliga -------------");
		
		super.print("\n ----> Água disponível: " + super.getReservaAgua() + "ml");
		super.println("\n ----> Crédito: R$ " + SistemaPagamento.getCredito());
	}
}
