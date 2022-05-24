package br.com.hugoogle.Validacao;

import br.com.hugoogle.enumerator.ColorEnum;
import br.com.hugoogle.interfaces.IOpcaoSimNaoValidator;

public class OpcaoSimNaoValidator implements IOpcaoSimNaoValidator<Integer> {

    @Override
    public void valida(Integer opcao, Integer sim, Integer nao) throws ValidatorException {
        System.out.println((opcao < sim || opcao > nao) ? ColorEnum.RED.getColorCode() + "\nOPCAO INVALIDA!\n" : "" + ColorEnum.RESET.getColorCode());

    }


}
