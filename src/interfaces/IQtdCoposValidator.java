package interfaces;


import Validacao.ValidatorException;

public interface IQtdCoposValidator<T> {

    void valida(T qtdCopos) throws ValidatorException;
}
