package menu.fabrica;

import enumerator.ColorEnum;
import enumerator.MenuPrincipalEnum;
import menu.submenu.SubMenuAbastecer;
import menu.submenu.SubMenuCompra;
import util.InputScanner;

import java.util.Arrays;

public class FabricaMenu {

    private static final int COMPRAR = 1;
    private static final int ABASTECER = 2;
    private static final int SAIR = 3;
    private static final MenuPrincipalEnum[] menu = MenuPrincipalEnum.values();
    private static final InputScanner fechar = new InputScanner();

    public static void getMenu(int opcaoMenu) {
        obterDescricaoDoMenu(opcaoMenu);
        switch (opcaoMenu) {
            case COMPRAR -> SubMenuCompra.menu();
            case ABASTECER -> SubMenuAbastecer.abastecer();
            case SAIR -> fechar.sair();
            default -> {
            }
        }
    }

    private static void obterDescricaoDoMenu(int opcao) {
        Arrays.stream(menu).filter(m -> m.getCodigoMenuKey() == opcao).findAny().ifPresent(m -> System.out.println(ColorEnum.BLUE.getColorCode() + "\n" + "\n" + m.getDescricao() + "\n" + ColorEnum.RESET.getColorCode()));
    }
}





