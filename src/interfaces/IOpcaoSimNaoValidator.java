package interfaces;

import Validacao.ValidatorException;

public interface IOpcaoSimNaoValidator<T> {

   void valida(T opcao, T sim, T nao) throws ValidatorException;
}
