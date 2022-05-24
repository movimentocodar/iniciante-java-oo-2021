package mensagem;

import enumerator.ColorEnum;

public class MensagemMaquinaAbastecida {

    private void mensagemAbastecida() {
        System.out.println(ColorEnum.GREEN.getColorCode() + "*** Maquina se encontra abastecida!  *** \n" + ColorEnum.RESET.getColorCode());
    }

    public  void maquinaAbastecida(boolean abastecida) {
        if (abastecida) {
            mensagemAbastecida();
        }
    }
}
