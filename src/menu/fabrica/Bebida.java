package menu.fabrica;


import Validacao.OpcaoSimNaoValidator;
import Validacao.ValidarOpcaoSimNao;
import enumerator.ColorEnum;
import menu.submenu.OpcaoSubMenuRetirada;
import model.Ingrediente;
import util.InputScanner;
import util.PopularModoDePreparo;

import java.util.List;

public abstract class Bebida {
    private static final InputScanner input = new InputScanner() {
        @Override
        public int entrada() {
            return super.entrada();
        }
    };

    public abstract List<Ingrediente> getIngredients();

    public abstract double getPreco();


    public void mensagem(Bebida bebida, int numeroDaBebida) {
        System.out.println(ColorEnum.GREEN.getColorCode()
                + "Inicinado preparo!\n"
                + ColorEnum.RESET.getColorCode()
                + "- Bebida " + bebida.getClass().getName().substring(8)  + " de numero "
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

            getModoDePreparo(bebida.getClass().getName().substring(8));

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
