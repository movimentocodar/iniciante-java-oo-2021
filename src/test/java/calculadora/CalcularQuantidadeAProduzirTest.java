package calculadora;

import br.com.hugoogle.bebidas.Cafe;
import br.com.hugoogle.calculadora.CalcularQuantidadeAProduzir;
import br.com.hugoogle.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.hugoogle.util.PopularProdutos;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class CalcularQuantidadeAProduzirTest {

    public static final int INDEX = 0;
    CalcularQuantidadeAProduzir calcularQuantidadeAProduzir = new CalcularQuantidadeAProduzir();
    Map<Produto, List<Double>> produtosEQuantidade;
    Queue<Map.Entry<Produto, List<Double>>> produto;

    @BeforeEach
    void setUp() {
        PopularProdutos.criarProduto();
    }

    @Test
    void dadoUmaBebidaQuandoCalcularAquantidadeAProduzirEntaoDeveRetornarProdutoAguaEQuantidade150() {
        dadoUmaBebida();
        quandoCalularAQuantidadeAProduzir();
        eOrdenarAlistadeProduto();
        entaoDeveRetornarOProdutoAguaEQuantidade150();
    }

    @Test
    void dadoUmaBebidaQuandoCalcularAQuantidadeAProduzirEntaoDeveRetornarUmaListaComCincoProdutos() {
        dadoUmaBebida();
        quandoCalularAQuantidadeAProduzir();
        entaoDeveRetornarUmaListaComCincoProdutos();
    }

    private void dadoUmaBebida() {
        calcularQuantidadeAProduzir.bebida(new Cafe(), 3, 4);
    }

    private void quandoCalularAQuantidadeAProduzir() {
        produtosEQuantidade = calcularQuantidadeAProduzir.getProdutosEQuantidade();
    }

    private void eOrdenarAlistadeProduto() {
        produto = new PriorityQueue<>((a, b) ->
                (int) (b.getValue().get(0) - a.getValue().get(0)));
        produto.addAll(produtosEQuantidade.entrySet());
    }

    private void entaoDeveRetornarOProdutoAguaEQuantidade150() {
        Assertions.assertEquals("Agua", produto.iterator().next().getKey().getDescricao());
        Assertions.assertEquals(150.0, produto.iterator().next().getValue().get(INDEX));

    }

    private void entaoDeveRetornarUmaListaComCincoProdutos() {
        Assertions.assertEquals(5, produtosEQuantidade.entrySet().size());

    }

}
