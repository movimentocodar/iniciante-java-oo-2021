package command;

import Validacao.ValidarEstoque;
import interfaces.ICommand;
import menu.fabrica.Bebida;
import model.Produto;

import java.util.List;
import java.util.Map;


public class EstoqueCommand implements ICommand {
    Bebida bebida;
    Map<Produto, List<Double>> produtoEQuantidade;
    ValidarEstoque validarEstoque = new ValidarEstoque();

    public EstoqueCommand(Bebida bebida, Map<Produto, List<Double>> produtoEQuantidade) {
        this.bebida = bebida;
        this.produtoEQuantidade = produtoEQuantidade;

    }

    @Override
    public void execute() {
        validarEstoque.calcular(this.bebida, this.produtoEQuantidade);

    }
}
