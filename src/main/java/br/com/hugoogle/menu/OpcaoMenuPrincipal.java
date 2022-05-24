package menu;

import enumerator.ColorEnum;
import enumerator.MenuPrincipalEnum;

import java.util.Arrays;

public class OpcaoMenuPrincipal {

    private static final MenuPrincipalEnum[] menu = MenuPrincipalEnum.values();

    public static void descricaoMenu() {
        System.out.println(ColorEnum.YELLOW.getColorCode() + "\n[ HUGOOGLE CAFE MENU  ] \n");
        Arrays.stream(menu).forEach(m -> System.out.println(ColorEnum.RESET.getColorCode()
                + "(" + m.getCodigoMenuKey()  + ")" + " - " + m.getDescricao() + ColorEnum.RESET.getColorCode()));
        System.out.print(ColorEnum.YELLOW.getColorCode() + "\nPor favor selecione  uma opcao desejada:  de 1 a " +  menu.length + ": "  + ColorEnum.RESET.getColorCode());
    }
}
