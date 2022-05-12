package Validacao;

import enumerator.ColorEnum;
import interfaces.IMenuValidator;
import menu.MenuPrincipal;

public class OpcaoPainelValidator implements IMenuValidator<Integer> {
    @Override
    public void valida(Integer opcao, Integer inicio, Integer fim) throws ValidatorException {
        System.out.println((opcao < inicio || opcao > fim) ? ColorEnum.RED.getColorCode() + "\nOPCAO INVALIDA!\n" : "" + ColorEnum.RESET.getColorCode());
        System.out.print(ColorEnum.YELLOW.getColorCode() + "\nPor favor selecione  uma opcao desejada:  de 1 a " + fim +  ": " + ColorEnum.RESET.getColorCode());
        if (opcao.equals(fim)) {
            MenuPrincipal.menu();
        }
    }
}