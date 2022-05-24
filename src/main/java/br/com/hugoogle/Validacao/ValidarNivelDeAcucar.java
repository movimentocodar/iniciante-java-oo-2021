package Validacao;

import enumerator.ColorEnum;
import util.InputScanner;

public class ValidarNivelDeAcucar {
    private static final InputScanner input = new InputScanner();
    public static int novoNivel(int opcao, int novoNivel) {
        if (opcao == 1) {

            System.out.print(ColorEnum.YELLOW.getColorCode() + "Informe um nivel de acucar de 1 a 5: " + ColorEnum.RESET.getColorCode());

            novoNivel = input.entrada();

        }

        System.out.println((novoNivel < 1 || novoNivel > 5) ? ColorEnum.RED.getColorCode() + "\nNivel informado invalido!\n" + ColorEnum.RESET.getColorCode() : "");
        return novoNivel;
    }
}
