package command;

import calculadora.CalcularQuantidadeAProduzir;
import interfaces.ICommand;
import menu.fabrica.Bebida;

public class IngredienteCommand implements ICommand {
    private final Bebida bebida;
    private final int qtdCopos;
    private final int nivelDeAcucar;
    private final CalcularQuantidadeAProduzir calcularQuantidadeAProduzir = new CalcularQuantidadeAProduzir();

    public IngredienteCommand(Bebida bebida, int qtdCopos, int nivelDeAcucar) {
        this.bebida = bebida;
        this.qtdCopos = qtdCopos;
        this.nivelDeAcucar = nivelDeAcucar;
    }

    private void calcularQuantidadeAproduzir(Bebida bebida, int qtdCopos, int nivelDeAcucar) {
         calcularQuantidadeAProduzir.produto(bebida, qtdCopos, nivelDeAcucar);
    }

    @Override
    public void execute() {
        calcularQuantidadeAproduzir(this.bebida, this.qtdCopos, this.nivelDeAcucar);
    }
}