package cafes;

public class Bebidas {

	private int id;
	private String nome;
	Receitas receita;
	private double preco;// obj novo?
	private static String menu;

	//construtor
	public Bebidas(int id, String nome, Receitas receita) {
		this.id = id;
		this.nome = nome;
		this.receita = receita;
		Bebidas.menu += this; //ser� que funciona como um array ?
	}




}
