package br.com.hugoogle.Validacao;

import br.com.hugoogle.interfaces.IValorInformadoValidator;

public class ValorInformadoValidator implements IValorInformadoValidator<Double> {
    @Override
    public void valida(Double valor) throws ValidatorException {
        System.out.println((valor < 1) ? """

                QUANTIDADE INFORMADA INVALIDA!
                QUANTIDADE MINIMA 1""" : "");

    }
}