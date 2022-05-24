package br.com.hugoogle.command;

import br.com.hugoogle.Validacao.ValidarEstoque;
import br.com.hugoogle.interfaces.ICommand;
import br.com.hugoogle.menu.fabrica.Bebida;
import br.com.hugoogle.model.Produto;

import java.util.List;
import java.util.Map;


public class EstoqueCommand implements ICommand {
    private final Bebida bebida;
    private final Map<Produto, List<Double>> produtoEQuantidade;
    private  final ValidarEstoque validarEstoque;

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
