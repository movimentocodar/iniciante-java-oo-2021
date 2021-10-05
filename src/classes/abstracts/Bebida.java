package classes.abstracts;

public abstract class Bebida extends SistemaInterno {
	
	protected void acucar(int acucar) {
		if(acucar != 0) {
			this.usandoIngrediente("Adicionando açúcar", "Adicionado " + acucar + " colheres de açúcar!");
		} else return;
	}
	
	protected void ferverAgua() {
		super.usaAgua();
		this.usandoIngrediente("Esquentando água", "água fervida!");
	}
	
	protected void filtrar(String nome) {
		this.usandoIngrediente("Filtrando", nome + " filtrado!");
	}
	
	protected void terminoBebida(String nome) {
		this.filtrar(nome);
		SistemaInterno.pausa(300);
		System.out.println("_____________________________________ \n");
		System.out.println(nome + " pronto(a)!");
	}
	
	public void usandoIngrediente(String processando, String concluido) {
		super.carregando(processando);
		super.carregando(processando + "...");
		System.out.println(concluido);
		SistemaInterno.pausa(250);
	}

	
	
}
