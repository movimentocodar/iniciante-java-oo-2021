package classes;

import abstracts.SistemaInterno;

public class Preparo extends SistemaInterno {
	private int escolha;
	
	public Preparo(int escolha) {
		this.escolha = escolha;
		this.preparo();
		super.repetir();
		
	}
	
	// Preparando as bebidas
	
	public void preparo() {
		switch (this.escolha) {
		case 1:
			this.cafe();
			break;
		case 2:
			this.cafeLeite();
			break;
		case 3:
			this.capuccino();
			break;
		case 4:
			this.cha();
			break;
		case 5:
			super.usaAgua();
			super.usandoIngrediente("Esquentando �gua", "�gua esquentada!");
			super.pausa(1000);
			System.out.println("_____________________________________ \n");
			System.out.println("Pegue sua �gua!");
			break;
		}
	}

	// Bebidas dispon�veis
	
	private void cafe() {
		this.ferverAgua();
		super.usandoIngrediente("Adicionando caf�", "Conclu�do!");
		this.terminoBebida("Caf�");
	}
	
	private void cafeLeite() {
		this.ferverAgua();
		super.usandoIngrediente("Adicionando caf�", "Conclu�do!");
		super.usandoIngrediente("Colocando leite", "Pronto!");
		this.terminoBebida("Caf� com leite");
	}
	
	private void capuccino() {
		this.ferverAgua();
		super.usandoIngrediente("Adicionando caf�", "Conclu�do!");
		super.usandoIngrediente("Colocando leite", "Pronto!");
		super.usandoIngrediente("Adicionando chocolate", "Feito!");
		this.terminoBebida("Capuccino");
	}
	
	private void cha() {
		this.ferverAgua();
		super.usandoIngrediente("Adicionando ch�", "Pronto!");
		this.terminoBebida("Ch� de lim�o");
	}
	
	// Processos comuns entre as bebidas
	
	private void ferverAgua() {
		super.usaAgua();
		super.usandoIngrediente("Esquentando �gua", "�gua fervida!");
	}
	
	private void filtrar(String nome) {
		super.usandoIngrediente("Filtrando", nome + " filtrado!");
	}
	
	private void terminoBebida(String nome) {
		this.filtrar(nome);
		super.pausa(300);
		System.out.println("_____________________________________ \n");
		System.out.println(nome + " pronto!");
	}
	
}