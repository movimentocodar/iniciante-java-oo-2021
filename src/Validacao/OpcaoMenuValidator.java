package Validacao;

import interfaces.IMenuValidator;
import menu.MenuPrincipal;
import enumerator.ColorEnum;

public class OpcaoMenuValidator implements IMenuValidator<Integer> {
    @Override
    public void valida(Integer opcao, Integer inicio, Integer fim) throws ValidatorException {
        System.out.println((opcao < inicio || opcao > fim) ? ColorEnum.RED.getColorCode() + "\nOPCAO INVALIDA!\n" : "" + ColorEnum.RESET.getColorCode());
        if (opcao.equals(fim)) {
            MenuPrincipal.menu();
        }
    }
}
