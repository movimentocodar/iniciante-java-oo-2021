package pagamento;

import enumerator.ColorEnum;

public class ReconhecimentoDeCedula {


    private static boolean isCedulaValida;

    public static void mensagemCedulaInvalida(){
        String mensagem = """
                Nota invalida!, por favor insira uma nota valida:
                R$2,00, R$5,00, R$10,00, R$20,00, R$50,00, R$100,00 ou R$200,00
                """;
        System.out.println(ColorEnum.RED.getColorCode() + mensagem + ColorEnum.RESET.getColorCode());
    }

    public static void detectarCedula(double cedula) {

        if (cedula != 2 && cedula != 5 && cedula != 10 && cedula != 20 && cedula != 50 && cedula != 100 && cedula != 200) {
            mensagemCedulaInvalida();
            isCedulaValida = false;
        } else {
            isCedulaValida  = true;
        }


    }



    public static boolean isCedulaValida() {
        return isCedulaValida;
    }
}
