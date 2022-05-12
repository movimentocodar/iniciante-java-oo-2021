package Validacao;

import enumerator.ColorEnum;
import interfaces.IOpcaoSimNaoValidator;

public class OpcaoSimNaoValidator implements IOpcaoSimNaoValidator<Integer> {

    @Override
    public void valida(Integer opcao, Integer sim, Integer nao) throws ValidatorException {
        System.out.println((opcao < sim || opcao > nao) ? ColorEnum.RED.getColorCode() + "\nOPCAO INVALIDA!\n" : "" + ColorEnum.RESET.getColorCode());

    }


}
