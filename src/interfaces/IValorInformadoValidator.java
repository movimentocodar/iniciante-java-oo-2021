package interfaces;


import Validacao.ValidatorException;

public interface IValorInformadoValidator<T> {

    void valida(T valor) throws ValidatorException;
}
