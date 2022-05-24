package br.com.hugoogle.interfaces;


import br.com.hugoogle.Validacao.ValidatorException;

public interface IMenuValidator<T> {

    void valida(T opcao, T inicio, T fim) throws ValidatorException;
}
