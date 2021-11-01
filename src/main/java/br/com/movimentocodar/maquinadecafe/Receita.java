package br.com.movimentocodar.maquinadecafe;
import java.util.ArrayList;
import java.util.List;

public class Receita {
    private int quantidadeDeAgua;
    private int quantidadeDePoCafe;
    private int quantidadeDeLeite;
    private int quantidadeDeChocolate;
    private int quantidadeDeLimao;
    private boolean ferverAgua;
    private boolean filtro;

    public Receita(boolean ferverAgua, boolean filtro) {
        this.quantidadeDeAgua = 50;
        this.ferverAgua = ferverAgua;
        this.filtro = filtro;
    }

    public void setQuantidadeDePoCafe(int quantidadeDePoCafe) {
        this.quantidadeDePoCafe = quantidadeDePoCafe;
    }

    public void setQuantidadeDeLeite(int quantidadeDeLeite) {
        this.quantidadeDeLeite = quantidadeDeLeite;
    }

    public void setQuantidadeDeChocolate(int quantidadeDeChocolate) {
        this.quantidadeDeChocolate = quantidadeDeChocolate;
    }

    public void setQuantidadeDeLimao(int quantidadeDeLimao) {
        this.quantidadeDeLimao = quantidadeDeLimao;
    }

    public void preparar(Acucar NivelDeAcucar){
        List<String> ProcessoDaReceita = new ArrayList<>();

        if (this.ferverAgua){
            ProcessoDaReceita.add("Fervendo água");
        }
        if(this.filtro){
            ProcessoDaReceita.add("Adicionando filtro");
        }
        if(this.quantidadeDePoCafe > 0){
            ProcessoDaReceita.add("Adicionando " + this.quantidadeDePoCafe + "g de pó de café");
            ProcessoDaReceita.add("Passando café");
        }
        if(this.quantidadeDeLeite > 0){
            ProcessoDaReceita.add("Adicionando " + this.quantidadeDeLeite + "g de leite em pó");
        }
        if(this.quantidadeDeChocolate > 0){
            ProcessoDaReceita.add("Adicionando " + this.quantidadeDeChocolate + "g de chocolate em pó");
        }
        if(this.quantidadeDeLimao > 0){
            ProcessoDaReceita.add("Adicionando " + this.quantidadeDeLimao + "g de pó para chá sabor limão");
            ProcessoDaReceita.add("Passando chá");
        }
        if(!NivelDeAcucar.equals(Acucar.NIVEL_0)){
            ProcessoDaReceita.add("Adicionando " + NivelDeAcucar.getDescricao() + " açúcar");
        }

        for(String processo: ProcessoDaReceita) {
            System.out.println(processo);
        }
    }

}
