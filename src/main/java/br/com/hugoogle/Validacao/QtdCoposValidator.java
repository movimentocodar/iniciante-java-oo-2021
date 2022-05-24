package br.com.hugoogle.Validacao;

import br.com.hugoogle.interfaces.IQtdCoposValidator;

public class QtdCoposValidator implements IQtdCoposValidator<Integer> {
    @Override
    public void valida(Integer qtdCopos) throws ValidatorException {
        System.out.println((qtdCopos < 1) ? """

                QUANTIDADE INFORMADA INVALIDA!
                QUANTIDADE MINIMA 1""" : "");
        }
}