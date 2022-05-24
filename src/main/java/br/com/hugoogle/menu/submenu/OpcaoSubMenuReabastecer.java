package menu.submenu;

import enumerator.ColorEnum;


public class OpcaoSubMenuReabastecer {

    public static void menu() {
        System.out.print(ColorEnum.YELLOW.getColorCode() + "\nDeseja reabastecer?\n"
                + ColorEnum.RESET.getColorCode()
                + "\n(1) Sim"
                + "\n(2) Nao\n");
        System.out.print(ColorEnum.YELLOW.getColorCode() + "\nOpcao n: " + ColorEnum.RESET.getColorCode());

    }

}


