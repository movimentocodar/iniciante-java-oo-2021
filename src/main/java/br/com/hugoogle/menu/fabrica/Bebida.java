package br.com.hugoogle.menu.fabrica;


import br.com.hugoogle.Validacao.OpcaoSimNaoValidator;
import br.com.hugoogle.Validacao.ValidarOpcaoSimNao;
import br.com.hugoogle.enumerator.ColorEnum;
import br.com.hugoogle.menu.submenu.OpcaoSubMenuRetirada;
import br.com.hugoogle.model.Ingrediente;
import br.com.hugoogle.util.InputScanner;
import br.com.hugoogle.util.PopularModoDePreparo;

import java.util.List;

public abstract class Bebida {
    private static final InputScanner input = new InputScanner();

    public abstract List<Ingrediente> getIngredients();

    public abstract double getPreco();


    public void mensagem(Bebida bebida, int numeroDaBebida) {
        System.out.println(ColorEnum.GREEN.getColorCode()
                + "Iniciando preparo!\n"
                + ColorEnum.RESET.getColorCode()
                + "- Bebida " + bebida.getClass().getName().substring(24)  + " de numero "
                + numeroDaBebida + " -");
    }

    public void mensagemBebidaFinalizada() {
        System.out.println("A bebida esta pronta!\n");
    }

    public void addAcucar() {
        System.out.println(ColorEnum.BLUE.getColorCode() + "Adicionando Acucar!" + ColorEnum.RESET.getColorCode());
    }

    public boolean isNotGratis() {
        return true;
    }

    public final void prepararBebida(Bebida bebida, int qdtCopos) {
        int numeroDaBebida = 0;
        do {

            numeroDaBebida += 1;
            mensagem(bebida, numeroDaBebida);

            getModoDePreparo(bebida.getClass().getName().substring(24));

            if (isNotGratis()) {
                addAcucar();
            }

            mensagemBebidaFinalizada();

            getOpcaoDeRetirada();

        } while (numeroDaBebida < qdtCopos);
    }

    private void getModoDePreparo(String modoDePreparo) {
        String modo = PopularModoDePreparo.getModoPreparo(modoDePreparo);
        System.out.println(ColorEnum.GREEN.getColorCode() + modo + ColorEnum.RESET.getColorCode());
    }


    private static void getOpcaoDeRetirada() {
        int opcao;
        do {
            OpcaoSubMenuRetirada.menu();
            opcao = input.entrada();
            ValidarOpcaoSimNao.valida(new OpcaoSimNaoValidator(), opcao, 1, 1);
        } while (opcao != 1);
    }

}
