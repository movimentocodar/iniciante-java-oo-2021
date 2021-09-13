package classes;

import abstracts.SistemaInterno;

public class Preparo extends SistemaInterno {
	private int escolha;
	
	public Preparo(int escolha) {
		this.escolha = escolha;
		this.preparo();
	}
	
	public void preparo() {
		switch (this.escolha) {
		case 0:
			super.carregando("Desligando");
			System.out.println("\n _____________________________________");
			System.exit(0);
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
		case 5: // �gua quente
			this.ferverAgua();
			super.pausa(1000);
			System.out.println("\n _____________________________________ \n");
			System.out.println("Pegue sua �gua!");
			break;
		}
	}

	/*
	// Tipos de bebidas
	
	private void bebidaSimples(String nome, String ingrediente) {
		this.ferverAgua();
		//ingrediente;
		this.terminoBebida(nome);
	}
	
	private void bebidaFacil(String nome, String processo1, String concluido1,
			String processo2, String concluido2) {
		this.ferverAgua();
		super.usandoIngrediente(processo1, concluido1);
		super.usandoIngrediente(processo2, concluido2);
		this.terminoBebida(nome);
	}
	
	private void bebidaDificil(String nome, String processo1, String concluido1,
			String processo2, String concluido2, String processo3,
			String concluido3) {
		this.ferverAgua();
		super.usandoIngrediente(processo1, concluido1);
		super.usandoIngrediente(processo2, concluido2);
		super.usandoIngrediente(processo3, concluido3);
		this.terminoBebida(nome);
	}
	*/
	
	// Bebidas
	
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
	
	// Processos
	
	private void ferverAgua() {
		super.usandoIngrediente("Separando �gua", "�gua fervida!");
	}
	
	private void filtrar(String nome) {
		super.usandoIngrediente("Filtrando", nome + " filtrado!");
	}
	
	private void terminoBebida(String nome) {
		this.filtrar(nome);
		super.pausa(300);
		System.out.println("\n _____________________________________ \n");
		System.out.println(nome + " pronto!");
	}
}
