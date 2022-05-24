package br.com.hugoogle.menu.submenu;

import br.com.hugoogle.enumerator.ColorEnum;

public class OpcaoSubMenuRetirada {

    public static void menu() {
        System.out.print(ColorEnum.YELLOW.getColorCode() + "\nPor favor confirmar a retirada da bebida!\n"
                + ColorEnum.RESET.getColorCode()
                + "\n(1) Sim\n");
        System.out.print(ColorEnum.YELLOW.getColorCode() + "\nOpcao n: " + ColorEnum.RESET.getColorCode());

    }
}
