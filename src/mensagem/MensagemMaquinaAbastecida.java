package mensagem;

import enumerator.ColorEnum;

public class MensagemMaquinaAbastecida {

    private static void mensagemAbastecida() {
        System.out.println(ColorEnum.GREEN.getColorCode() + "*** Maquina se encontra abastecida!  *** \n" + ColorEnum.RESET.getColorCode());
    }

    public static void maquinaAbastecida(boolean abastecida) {
        if (abastecida) {
            mensagemAbastecida();
        }
    }
}
