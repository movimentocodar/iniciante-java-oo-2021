package model;

public class Ingrediente {

    private final int codigo;
    private final int quantidade;

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Ingrediente(int codigo, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "codigo=" + codigo +
                ", quantidade=" + quantidade +
                '}';
    }
}
