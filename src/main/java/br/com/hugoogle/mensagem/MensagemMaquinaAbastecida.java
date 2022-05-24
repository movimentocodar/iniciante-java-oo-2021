package br.com.hugoogle.mensagem;

import br.com.hugoogle.enumerator.ColorEnum;

public class MensagemMaquinaAbastecida {

    private String mensagemAbastecida() {
        return ColorEnum.GREEN.getColorCode() + "*** Maquina se encontra abastecida!  *** \n" + ColorEnum.RESET.getColorCode();
    }

    private String mensagemDesabastecida() {
        return ColorEnum.GREEN.getColorCode() + "*** Maquina se encontra desabastecida!  *** \n" + ColorEnum.RESET.getColorCode();
    }

    public  void maquinaAbastecida(boolean abastecida) {
        if (abastecida) {
            System.out.println(mensagemAbastecida());
        } else {
            System.out.println(mensagemDesabastecida());
        }
    }
}
