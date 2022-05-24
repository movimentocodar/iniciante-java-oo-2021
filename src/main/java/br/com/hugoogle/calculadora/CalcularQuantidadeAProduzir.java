package br.com.hugoogle.calculadora;

import br.com.hugoogle.menu.fabrica.Bebida;
import br.com.hugoogle.model.Estoque;
import br.com.hugoogle.model.Ingrediente;
import br.com.hugoogle.model.Produto;

import java.util.*;

public class CalcularQuantidadeAProduzir {
    
    private static final int CODIGOKEYACUCAR = 8;

    private static final Map<Produto, List<Double>> produtosEQuantidade = new HashMap<>();
    private final Estoque estoque = new Estoque();

    public void bebida(Bebida bebida, int qtdCopos, int nivelDeAcucar) {
        produtosEQuantidade.clear();

        List<Ingrediente> ingredientes =  bebida.getIngredients();
        for (Ingrediente ingrediente : ingredientes) {

            estoque.getEstoqueListaDeProduto().stream().filter(p -> p.getProdutoKey() == ingrediente.getProdutoKey()).findAny()
                    .ifPresent(produto ->
                            calcular(produto, qtdCopos, ingrediente.getQuantidade(), nivelDeAcucar));
        }
    }

    private void calcular(Produto produto, int qtdCopos, double ingredienteQuantidade, int nivelDeAcucar) {
        List<Double> quantidadeTotal = new ArrayList<>();

        if (produto.getProdutoKey() == CODIGOKEYACUCAR) {
            quantidadeTotal.add(qtdCopos * (ingredienteQuantidade * nivelDeAcucar));
            quantidadeTotal.add(ingredienteQuantidade);

        } else {
            quantidadeTotal.add(qtdCopos * ingredienteQuantidade);
            quantidadeTotal.add(ingredienteQuantidade);
        }
        produtosEQuantidade.put(produto, quantidadeTotal);
    }

    public Map<Produto, List<Double>> getProdutosEQuantidade() {
        return Collections.unmodifiableMap(produtosEQuantidade);
    }
}
