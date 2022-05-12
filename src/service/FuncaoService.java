package service;

import enumerator.ColorEnum;

import menu.fabrica.Bebida;
import util.InputScanner;

public class FuncaoService {

    private static final InputScanner input = new InputScanner() {
        @Override
        public int entrada() {
            return super.entrada();
        }
    };


    private int novoNivel = 3;


    public int nivelDeAcucar(Bebida bebida) {
        if (bebida.isNotGratis()) {

            int opcao;

            System.out.println(ColorEnum.BLUE.getColorCode() + "*** Nivel padrao de acucar: 3 ***\n"
                    + ColorEnum.RED.getColorCode() + "Eh aplicado 3g de acucar por nivel, logo  9g de acucar por copo\n"
                    + "" + ColorEnum.RESET.getColorCode());
            do {

                opcao = validarOpcao();


            } while (opcao < 1 || opcao > 2);

            do {

                novoNivel = validarNivel(opcao, novoNivel);


            } while (novoNivel < 1 || novoNivel > 5);
            return novoNivel;
        }
        return 0;
    }

    private int validarNivel(int opcao, int novoNivel) {
        if (opcao == 1) {

            System.out.print(ColorEnum.YELLOW.getColorCode() + "Informe um nivel de acucar de 1 a 5: " + ColorEnum.RESET.getColorCode());

            novoNivel = input.entrada();

        }

        System.out.println((novoNivel < 1 || novoNivel > 5) ? ColorEnum.RED.getColorCode() + "\nNivel informado invalido!\n" + ColorEnum.RESET.getColorCode() : "");
        return novoNivel;
    }

    private int validarOpcao() {
        int opcao;
        System.out.print(ColorEnum.YELLOW.getColorCode() + "Deseja alterar o nivel padrao?\n"
                + ColorEnum.RESET.getColorCode()
                + "\n(1) Sim"
                + "\n(2) Nao\n");
        System.out.print(ColorEnum.YELLOW.getColorCode() + "\nOpcao n: " + ColorEnum.RESET.getColorCode());
        opcao = input.entrada();

        System.out.println((opcao < 1 || opcao > 2) ? ColorEnum.RED.getColorCode() + "\nOpcao invalida!\n" + ColorEnum.RESET.getColorCode() : "");
        return opcao;
    }

}