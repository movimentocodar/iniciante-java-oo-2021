package command;

import br.com.hugoogle.Validacao.ValidarEstoque;
import br.com.hugoogle.bebidas.Cafe;
import br.com.hugoogle.calculadora.CalcularQuantidadeAProduzir;
import br.com.hugoogle.command.EstoqueCommand;
import br.com.hugoogle.command.Executor;
import br.com.hugoogle.command.IngredienteCommand;
import br.com.hugoogle.command.VendaCommand;
import br.com.hugoogle.interfaces.ICommand;
import br.com.hugoogle.menu.fabrica.Bebida;
import br.com.hugoogle.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ExecutorTest {


    @Mock
    Executor executor;

    @Mock
    Executor executores;

    @Captor
    ArgumentCaptor<List<ICommand>> listCommandCaptor;

    Bebida bebida;

    CalcularQuantidadeAProduzir calcularQuantidadeAProduzir = new CalcularQuantidadeAProduzir();
    Map<Produto, List<Double>> produtosEQuantidade = calcularQuantidadeAProduzir.getProdutosEQuantidade();

    List<ICommand> tarefa = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void dadoUmaBebidaEUmaListaDeTarefaVerifiqueSeFoiExecutadoAListaDeTarefa() {

        dadoUmaBebida();
        eUmaListaDeTarefa();
        quandoExecutar();
        verifiqueSeFoiExecutadoAListaDeTarefa();

    }

    private void dadoUmaBebida() {
        this.bebida = new Cafe();
    }

    private void eUmaListaDeTarefa() {
        tarefa.add(new IngredienteCommand(bebida, 1, 10));
        tarefa.add(new EstoqueCommand(bebida, produtosEQuantidade, new ValidarEstoque()));
        tarefa.add(new VendaCommand(bebida, 1));
    }

    private void quandoExecutar() {
        executor.execute(tarefa);
    }


    private void verifiqueSeFoiExecutadoAListaDeTarefa() {
        verify(executor, times(1)).execute(tarefa);

    }

    @Test
    public void  dadoUmaListaDeTarefaQuandoExecutarVerifiqueSeAListaFoiExecutadaESeTodosComandForamPassados() {
        dadoUmaListaDeTarefa();
        quandoExecutar();
        verifiqueSeAListaFoiExecutada();
        eSeTodosCommandForamPassados();
         }

    private void dadoUmaListaDeTarefa(){
        tarefa.add(new IngredienteCommand(bebida, 1, 10));
        tarefa.add(new EstoqueCommand(bebida, produtosEQuantidade, new ValidarEstoque()));
        tarefa.add(new VendaCommand(bebida, 1));
    }

    private void verifiqueSeAListaFoiExecutada(){
        executores.execute(tarefa);
        verify(executores).execute(listCommandCaptor.capture());

    }

    private void eSeTodosCommandForamPassados(){
        ArgumentCaptor<List<ICommand>> listCommand = listCommandCaptor;
        Assertions.assertEquals(tarefa, listCommand.getAllValues().get(0));

    }


}