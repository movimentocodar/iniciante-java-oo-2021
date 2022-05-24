package br.com.hugoogle.command;

import br.com.hugoogle.controller.VendaController;
import br.com.hugoogle.interfaces.ICommand;
import br.com.hugoogle.menu.fabrica.Bebida;

public class VendaCommand implements ICommand {
    private final Bebida bebida;
    private final int qtdCopos;
    private final VendaController vendaController = new VendaController();

    public VendaCommand(Bebida bebida, int qtdCopos) {
        this.bebida = bebida;
        this.qtdCopos = qtdCopos;
    }

    private void calcularValorAPagar(Bebida bebida, int qtdCopos){
        vendaController.calcularValorAPagar(bebida.getPreco(), qtdCopos);

    }

    @Override
    public void execute() {
        calcularValorAPagar(this.bebida, this.qtdCopos);
    }
}
