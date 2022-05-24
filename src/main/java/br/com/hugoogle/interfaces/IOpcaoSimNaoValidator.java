package br.com.hugoogle.interfaces;

import br.com.hugoogle.Validacao.ValidatorException;

public interface IOpcaoSimNaoValidator<T> {

   void valida(T opcao, T sim, T nao) throws ValidatorException;
}
