package interfaces;


import Validacao.ValidatorException;

public interface IMenuValidator<T> {

    void valida(T opcao, T inicio, T fim) throws ValidatorException;
}
