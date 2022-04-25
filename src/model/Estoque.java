package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Estoque {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private static final List<Produto> estoque = new ArrayList<>();

    public static List<Produto> carregarProdutos() {
        estoque.add(new Produto(1, "Agua", 1000, "ml"));
        estoque.add(new Produto(2, "Po de Cafe", 1000, "g"));
        estoque.add(new Produto(3, "Filtro", 1000, "un"));
        estoque.add(new Produto(4, "Leite em Po", 1000, "g"));
        estoque.add(new Produto(5, "Chocolato em Po", 1000, "g"));
        estoque.add(new Produto(6, "Cha em po Limao", 1000, "g"));
        estoque.add(new Produto(7, "Copo", 1000, "un"));
        estoque.add(new Produto(8, "Acucar", 1000, "g"));
        return estoque;

    }

    public static double getEstoque(String descricao) {

        return Objects.requireNonNull(carregarProdutos()
                .stream()
                .filter(c -> c.getDescricao().equals(descricao)).findAny().orElse(null)).getEstoque();
    }

    public static List<Produto> getEstoqueProduto() {
        return estoque;
    }

    public static void atualizarEstoque(int codigo, int quantidade) {
        estoque.stream().filter(p -> p.getCodigo() == codigo).findAny().ifPresent(e -> {
            int qtdEstoque = e.getEstoque() - quantidade;
            if (e.getCodigo() == codigo) {
                e.setEstoque(qtdEstoque);
            }
        });
    }

}
