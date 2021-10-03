package com.jands.cafefx.maquinadecafe.model.credito.modelocredito;

public class CreditoInvalidoException extends RuntimeException {
    public CreditoInvalidoException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
