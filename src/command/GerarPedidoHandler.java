package command;

import calculadora.CalcularQuantidadeAProduzir;
import interfaces.ICommand;
import menu.fabrica.Bebida;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GerarPedidoHandler {

    public static void processarPedido(Bebida bebida, int qtdCopos, int nivelDeAcucar) {
        CalcularQuantidadeAProduzir calcularQuantidadeAProduzir = new CalcularQuantidadeAProduzir();
        Map<Produto, List<Double>> produtosEQuantidade = calcularQuantidadeAProduzir.getProdutosEQuantidade();

        List<ICommand> tarefa = new ArrayList<>();
        tarefa.add(new IngredienteCommand(bebida, qtdCopos, nivelDeAcucar));
        tarefa.add(new EstoqueCommand(bebida, produtosEQuantidade));
        tarefa.add(new VendaCommand(bebida, qtdCopos));
        new Executor().execute( tarefa );
    }
}
