package mensagem;

import enumerator.ColorEnum;

public class MensagemNivelPadraoDeAcucar {

    public static void mensagem() {
        System.out.println(ColorEnum.BLUE.getColorCode() + "*** Nivel padrao de acucar: 3 ***\n"
                + ColorEnum.RED.getColorCode() + "Eh aplicado 3g de acucar por nivel, logo  9g de acucar por copo\n"
                + "" + ColorEnum.RESET.getColorCode());
    }


}
