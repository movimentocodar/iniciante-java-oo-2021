package model;

import java.util.Objects;

public class Produto {

    private final int codigo;
    private final String descricao;
    private int estoque;
    private final String embalagem;


    public Produto(int codigo, String descricao, int estoque, String embalagem) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.estoque = estoque;
        this.embalagem = embalagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Produto produto = (Produto) o;
        return codigo == produto.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", estoque=" + estoque +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getEstoque() {
        return estoque;
    }


    public String getEmbalagem() {
        return embalagem;
    }
}
