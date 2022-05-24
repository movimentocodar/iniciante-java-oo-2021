package command;

import Validacao.ValidarEstoque;
import br.com.hugoogle.calculadora.CalcularQuantidadeAProduzir;
import interfaces.ICommand;
import menu.fabrica.Bebida;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GerarPedidoHandler {

    private final CalcularQuantidadeAProduzir calcularQuantidadeAProduzir = new CalcularQuantidadeAProduzir();
    public void processarPedido(Bebida bebida, int qtdCopos, int nivelDeAcucar) {
        calcularQuantidadeAProduzir.bebida(bebida,qtdCopos,nivelDeAcucar);
        Map<Produto, List<Double>> produtosEQuantidade = calcularQuantidadeAProduzir.getProdutosEQuantidade();

        List<ICommand> tarefa = new ArrayList<>();
        tarefa.add(new IngredienteCommand(bebida, qtdCopos, nivelDeAcucar));
        tarefa.add(new EstoqueCommand(bebida, produtosEQuantidade, new ValidarEstoque()));
        tarefa.add(new VendaCommand(bebida, qtdCopos));
        new Executor().execute( tarefa );
    }


}
