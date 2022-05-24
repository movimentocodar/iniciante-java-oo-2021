package br.com.hugoogle.mensagem;

import br.com.hugoogle.enumerator.ColorEnum;

public class MensagemMaquinaAbastecida {

    private String mensagemAbastecida() {
        return ColorEnum.GREEN.getColorCode() + "*** Maquina se encontra abastecida!  *** \n" + ColorEnum.RESET.getColorCode();
    }

    private String mensagemDesabastecida() {
        return ColorEnum.GREEN.getColorCode() + "*** Maquina se encontra desabastecida!  *** \n" + ColorEnum.RESET.getColorCode();
    }

    public void maquinaAbastecida(){
        System.out.println(mensagemAbastecida());
    }

    public void maquinaDesabastecida(){
        System.out.println(mensagemDesabastecida());
    }

}
