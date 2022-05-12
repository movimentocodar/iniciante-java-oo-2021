package Validacao;

import interfaces.IOpcaoSimNaoValidator;

public class ValidarOpcaoSimNao {

    public static <T> void valida(IOpcaoSimNaoValidator<T> validaOpcaoSimNao, T   opcao, T sim, T nao)  {
        try {
            validaOpcaoSimNao.valida(opcao, sim, nao);
        } catch (ValidatorException e) {
            String mensagem = "Ocorreu um erro ao processar a opcao informada!" + e.getMessage();
            System.err.println(mensagem);
            throw new RuntimeException(mensagem);
        }
    }
}
