package br.com.hugoogle.Validacao;

import br.com.hugoogle.enumerator.ColorEnum;
import br.com.hugoogle.util.InputScanner;

public class ValidaOpcaoNivelPadrao {
    private static final InputScanner input = new InputScanner();
    public static int getOpcao() {
        int opcao;
        System.out.print(ColorEnum.YELLOW.getColorCode() + "Deseja alterar o nivel padrao?\n"
                + ColorEnum.RESET.getColorCode()
                + "\n(1) Sim"
                + "\n(2) Nao\n");
        System.out.print(ColorEnum.YELLOW.getColorCode() + "\nOpcao n: " + ColorEnum.RESET.getColorCode());
        opcao = input.entrada();
        ValidarOpcaoSimNao.valida(new OpcaoSimNaoValidator(), opcao, 1, 2);
        return opcao;
    }

}
