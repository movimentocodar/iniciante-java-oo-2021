package service;

import model.Color;

import util.InputScanner;

public class FuncaoService {

    private final EstoqueService estoqueService = new EstoqueService();

    private static final InputScanner input = new InputScanner() {
        @Override
        public int entrada() {
            return super.entrada();
        }
    };

    public void nivelDeAcucar(int qtdCopos) {
        int opcao;
        int novoNivel = 3;

        System.out.println(Color.BLUE.getColorCode() + "*** Nivel padrao de acucar: 3 ***\n"
                + Color.RED.getColorCode() + "Eh aplicado 3g de acucar por nivel, logo  9g de acucar por copo\n"
                + "" + Color.RESET.getColorCode());
        do {

            opcao = validarOpcao();


        } while (opcao < 1 || opcao > 2);

        do {

            novoNivel = validarNivel(opcao, novoNivel);


        } while (novoNivel < 1 || novoNivel > 5);
        estoqueService.consultarSaldoDeEstoqueAcucar(qtdCopos, novoNivel);
    }

    private int validarNivel(int opcao, int novoNivel) {
        if (opcao == 1) {

            System.out.print(Color.YELLOW.getColorCode() + "Informe um nivel de acucar de 1 a 5: " + Color.RESET.getColorCode());

            novoNivel = input.entrada();

        }

        System.out.println((novoNivel < 1 || novoNivel > 5) ? Color.RED.getColorCode() + "\nNivel informado invalido!\n" + Color.RESET.getColorCode() : "");
        return novoNivel;
    }

    private int validarOpcao() {
        int opcao;
        System.out.print(Color.YELLOW.getColorCode() + "Deseja alterar o nivel padrao?\n"
                + Color.RESET.getColorCode()
                + "\n(1) Sim"
                + "\n(2) Nao\n");
        System.out.print(Color.YELLOW.getColorCode() + "\nOpcao n: " + Color.RESET.getColorCode());
        opcao = input.entrada();

        System.out.println((opcao < 1 || opcao > 2) ? Color.RED.getColorCode() + "\nOpcao invalida!\n" + Color.RESET.getColorCode() : "");
        return opcao;
    }

}