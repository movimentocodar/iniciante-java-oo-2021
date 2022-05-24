package br.com.hugoogle.interfaces;


import br.com.hugoogle.Validacao.ValidatorException;

public interface IValorInformadoValidator<T> {

    void valida(T valor) throws ValidatorException;
}
