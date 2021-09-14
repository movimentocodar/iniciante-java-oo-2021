package cafes;
import java.util.ArrayList;

public class Bebida {
    private int id;
    private String nome;
    Receitas receita;
    private double preco;
    private static ArrayList<Bebida> menu = new ArrayList<Bebida>();

    public Bebida(){

    }

    public Bebida(int id, String nome, Receitas receita, double preco) {
        this.id = id;
        this.nome = nome;
        this.receita = receita;
        this.preco = preco;
        Bebida.menu.add(this);
    }

    public static ArrayList<Bebida> getMenu() {
        return menu;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }
}
