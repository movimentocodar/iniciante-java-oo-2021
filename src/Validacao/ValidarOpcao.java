package Validacao;

import interfaces.IMenuValidator;

public class ValidarOpcao {
    public static <T> void valida(IMenuValidator<T> validatorMenu, T opcao, T inicio, T fim) {
        try {
            validatorMenu.valida(opcao, inicio, fim);
        } catch (ValidatorException e) {
            String mensagem = "Ocorreu um erro ao processar a opcao informada!" + e.getMessage();
            System.err.println(mensagem);
            throw new RuntimeException(mensagem);
        }
    }
}
