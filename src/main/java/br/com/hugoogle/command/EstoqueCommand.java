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
    ValidarEstoque validarEstoque;

    public EstoqueCommand(Bebida bebida, Map<Produto, List<Double>> produtoEQuantidade, ValidarEstoque validarEstoque) {
        this.bebida = bebida;
        this.produtoEQuantidade = produtoEQuantidade;
        this.validarEstoque = validarEstoque;

    }

    @Override
    public void execute() {
        validarEstoque.calcular(this.bebida, this.produtoEQuantidade);

    }
}
