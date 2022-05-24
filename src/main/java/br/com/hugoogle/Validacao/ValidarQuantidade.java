package br.com.hugoogle.Validacao;

import br.com.hugoogle.interfaces.IQtdCoposValidator;

public class ValidarQuantidade {

    public static <T> void valida(IQtdCoposValidator<T> validatorQtdCopos, T qtdCopos) {
        try {
            validatorQtdCopos.valida(qtdCopos);
        } catch (ValidatorException e) {
            String mensagem = "Ocorreu um erro ao processar a quantidade informada!" + e.getMessage();
            System.err.println(mensagem);
            throw new RuntimeException(mensagem);
        }

    }
}
