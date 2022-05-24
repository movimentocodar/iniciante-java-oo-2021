package command;

import br.com.hugoogle.Validacao.ValidarEstoque;
import br.com.hugoogle.bebidas.CafeComLeite;
import br.com.hugoogle.calculadora.CalcularQuantidadeAProduzir;
import br.com.hugoogle.command.*;
import br.com.hugoogle.interfaces.ICommand;
import br.com.hugoogle.menu.fabrica.Bebida;
import br.com.hugoogle.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GerarPedidoHandlerTest {

    @Spy
    GerarPedidoHandler gerarPedidoHandler;

    @Mock
    CalcularQuantidadeAProduzir calcularQuantidadeAProduzir;

    @Mock
    Executor executor;

    @Captor
    ArgumentCaptor<List<ICommand>> executorCaptor;

    Bebida bebida = new CafeComLeite();
    Map<Produto, List<Double>> listaDeProdutoEQuantidadeProduzidaMap = listaDeProdutoEQuantidadeProduzida();

    private List<ICommand> tarefa;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void dadoUmPedidoAProcessarQuandoExecutarVerifiqueSeListaFoiExecutadaEValidaAListaDeTarefaExecutadaEValideOsProdutosEQuantidadeProduzida() {
        dadoUmPedidoAProcessar();
        eUmaListaDeTarefas();
        quandoExecutar();
        verifiqueSeListaFoiExecutada();
        eValidaAListaDeTarefaExecutada();
        eValideOsProdutosEQuantidadeProduzida();


    }

    private void dadoUmPedidoAProcessar() {
        this.gerarPedidoHandler.processarPedido(bebida, 2, 3);
        Mockito.when(calcularQuantidadeAProduzir.getProdutosEQuantidade()).thenReturn(listaDeProdutoEQuantidadeProduzidaMap);
    }

    private void eUmaListaDeTarefas() {
        this.tarefa = new ArrayList<>();
        tarefa.add(new IngredienteCommand(bebida, 2, 3));
        tarefa.add(new EstoqueCommand(bebida, listaDeProdutoEQuantidadeProduzidaMap, new ValidarEstoque()));
        tarefa.add(new VendaCommand(bebida, 2));
    }

    private void quandoExecutar() {
        executor.execute(tarefa);
    }

    private void verifiqueSeListaFoiExecutada() {

        Mockito.verify(executor).execute(executorCaptor.capture());
    }

    private void eValidaAListaDeTarefaExecutada() {
        List<ICommand> tarefas = executorCaptor.getValue();
        assertEquals(tarefa, tarefas);
        ArgumentCaptor<List<ICommand>> listCommand = executorCaptor;
        Assertions.assertEquals(tarefas, listCommand.getAllValues().get(0));
    }

    private void eValideOsProdutosEQuantidadeProduzida() {
        Assertions.assertEquals(listaDeProdutoEQuantidadeProduzidaMap, calcularQuantidadeAProduzir.getProdutosEQuantidade());
    }

    private Map<Produto, List<Double>> listaDeProdutoEQuantidadeProduzida() {
        Map<Produto, List<Double>> produtoListMap = new HashMap<>();
        List<Double> list = new ArrayList<>();
        list.add(10.00);
        list.add(12.00);
        Produto produto = new Produto(1, "Cafe", 100, 1000, "un");
        produtoListMap.put(produto, list);
        return produtoListMap;

    }
}