package br.com.hugoogle.menu.submenu;

import br.com.hugoogle.controller.VendaController;
import br.com.hugoogle.enumerator.ColorEnum;
import br.com.hugoogle.enumerator.MenuPagamentoEnum;

import java.text.DecimalFormat;
import java.util.Arrays;

public class OpcaoSubMenuPagamento {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final MenuPagamentoEnum[] menu = MenuPagamentoEnum.values();
    private static final VendaController vendaController = new VendaController();

    public static void menu() {

        System.out.println(ColorEnum.BLUE.getColorCode()
                + "\n*** Por favor realize o pagamento ***\n"
                + ColorEnum.RESET.getColorCode()
                + "Valor Total: R$"
                + df.format(vendaController.obterValorTotalAPagar()));
        System.out.println(ColorEnum.YELLOW.getColorCode() + "\nSelecione uma opcao:\n");

        Arrays.stream(menu).forEach(m -> System.out.println(ColorEnum.RESET.getColorCode()
                + "(" + m.getCodigoMenuPagamentoKey() + ")"
                + " - " + m.getTipoPagamento()
                + ColorEnum.RESET.getColorCode()));
        System.out.print(ColorEnum.YELLOW.getColorCode() + "\nOpcao n: " + ColorEnum.RESET.getColorCode());
    }

}
