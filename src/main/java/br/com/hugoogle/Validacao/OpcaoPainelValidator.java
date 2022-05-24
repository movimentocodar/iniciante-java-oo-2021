package br.com.hugoogle.Validacao;

import br.com.hugoogle.enumerator.ColorEnum;
import br.com.hugoogle.interfaces.IMenuValidator;
import br.com.hugoogle.menu.MenuPrincipal;

public class OpcaoPainelValidator implements IMenuValidator<Integer> {
    @Override
    public void valida(Integer opcao, Integer inicio, Integer fim) throws ValidatorException {
        System.out.println((opcao < inicio || opcao > fim) ? ColorEnum.RED.getColorCode() + "\nOPCAO INVALIDA!\n" : "" + ColorEnum.RESET.getColorCode());
        if (opcao.equals(fim)) {
            new MenuPrincipal();
            MenuPrincipal.menu();
        }
    }
}