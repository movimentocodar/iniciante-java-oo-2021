package br.com.hugoogle.interfaces;


import br.com.hugoogle.Validacao.ValidatorException;

public interface IQtdCoposValidator<T> {

    void valida(T qtdCopos) throws ValidatorException;
}
