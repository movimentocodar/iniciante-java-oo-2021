package classes.abstracts;

import java.math.BigDecimal;
import classes.ListaBebidas;

public abstract class Bebida extends SistemaInterno {

	public String divisorNomePreco(int caracteres) {
		return ListaBebidas.divisorNomePreco(caracteres);
	}

	// MÉTODOS ABSTRATOS

	public abstract BigDecimal getPreco();

	public abstract String getNome();

	// MÉTODOS DE PREPARO DAS BEBIDAS:

	public void acucar(int acucar) {
		if (acucar != 0) {
			this.usandoIngrediente("Adicionando açúcar", "Adicionado " + acucar + " colheres de açúcar!");
		} else
			return;
	}

	public void ferverAgua() {
		super.usaAgua();
		this.usandoIngrediente("Esquentando água", " \n Água fervida!");
	}

	public void filtrar(String nome) {
		this.usandoIngrediente("Filtrando", "\n" + nome + " filtrado!");
	}

	public void terminoBebida(String nome) {
		this.filtrar(nome);
		super.pausa(300);
		super.println("_____________________________________ \n");
		super.println(nome + " pronto!");
	}

	public void usandoIngrediente(String processando, String concluido) {
		super.println("");
		super.carregando(processando);
		super.carregando(processando + "......");
		super.println(concluido);
		super.pausa(250);
	}

}
