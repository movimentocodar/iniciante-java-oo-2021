package Validacao;

import interfaces.IQtdCoposValidator;

public class QtdCoposValidator implements IQtdCoposValidator<Integer> {
    @Override
    public void valida(Integer qtdCopos) throws ValidatorException {
        System.out.println((qtdCopos < 1) ? "\nQUANTIDADE INFORMADA INVALIDA!\n" + "QUANTIDADE MINIMA 1" : "");
        }
}