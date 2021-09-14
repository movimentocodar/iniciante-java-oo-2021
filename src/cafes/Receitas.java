package cafes;

public class Receitas {
    private int quantidadeDeAgua;
    private int quantidadeDePoCafe;
    private int quantidadeDeLeite;
    private int quantidadeDeChocolate;
    private int quantidadeDeLimao;
    private boolean ferverAgua;
    private boolean filtro;

    public Receitas(boolean ferverAgua, boolean filtro) {
        this.quantidadeDeAgua = 50;
        this.ferverAgua = ferverAgua;
        this.filtro = filtro;
    }

    public int getQuantidadeDePoCafe() {
        return quantidadeDePoCafe;
    }

    public void setQuantidadeDePoCafe(int quantidadeDePoCafe) {
        this.quantidadeDePoCafe = quantidadeDePoCafe;
    }

    public int getQuantidadeDeLeite() {
        return quantidadeDeLeite;
    }

    public void setQuantidadeDeLeite(int quantidadeDeLeite) {
        this.quantidadeDeLeite = quantidadeDeLeite;
    }

    public int getQuantidadeDeChocolate() {
        return quantidadeDeChocolate;
    }

    public void setQuantidadeDeChocolate(int quantidadeDeChocolate) {
        this.quantidadeDeChocolate = quantidadeDeChocolate;
    }

    public int getQuantidadeDeLimao() {
        return quantidadeDeLimao;
    }

    public void setQuantidadeDeLimao(int quantidadeDeLimao) {
        this.quantidadeDeLimao = quantidadeDeLimao;
    }

    //metodo de processo da receita
}
