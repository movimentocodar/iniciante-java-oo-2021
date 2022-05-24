package br.com.hugoogle.menu.submenu;

import br.com.hugoogle.enumerator.ColorEnum;
import br.com.hugoogle.enumerator.MenuCompraEnum;

import java.util.Arrays;

public class OpcaoSubMenuCompra {


    private static final MenuCompraEnum[] menu = MenuCompraEnum.values();

    public static void menu() {
        System.out.println(ColorEnum.YELLOW.getColorCode() + "[ HUGOOGLE CAFE MENU  ] \n");
        Arrays.stream(menu).forEach(m -> System.out.println(ColorEnum.RESET.getColorCode()
                + "(" + m.getCodigoMenuKey() + ")" + " - " + m.getDescricao() + ColorEnum.RESET.getColorCode()));
        System.out.println(ColorEnum.RESET.getColorCode()
                + "(" + (menu.length + 1) + ") - Retornar"  + ColorEnum.RESET.getColorCode());
        System.out.print(ColorEnum.YELLOW.getColorCode() + "\nPor favor selecione  uma opcao desejada:  de 1 a " + (menu.length + 1) +": " + ColorEnum.RESET.getColorCode());
    }

}
