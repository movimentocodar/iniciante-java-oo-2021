package br.com.hugoogle.menu.fabrica;

import br.com.hugoogle.enumerator.ColorEnum;
import br.com.hugoogle.enumerator.MenuPrincipalEnum;
import br.com.hugoogle.menu.submenu.SubMenuAbastecer;
import br.com.hugoogle.menu.submenu.SubMenuCompra;
import br.com.hugoogle.util.InputScanner;

import java.util.Arrays;

public class FabricaMenu {

    public static final int COMPRAR = 1;
    public static final int ABASTECER = 2;
    public static final int SAIR = 3;
    private final MenuPrincipalEnum[] menu = MenuPrincipalEnum.values();
    private final InputScanner fechar = new InputScanner();

    public void getMenu(int opcaoMenu) {
        obterDescricaoDoMenu(opcaoMenu);
        switch (opcaoMenu) {
            case COMPRAR ->  new SubMenuCompra() ;
            case ABASTECER -> new SubMenuAbastecer();
            case SAIR -> fechar.sair();
            default -> {
            }
        }
    }

    private void obterDescricaoDoMenu(int opcao) {
        Arrays.stream(menu).filter(m -> m.getCodigoMenuKey() == opcao).findAny().ifPresent(m -> System.out.println(ColorEnum.BLUE.getColorCode() + "\n" + "\n" + m.getDescricao() + "\n" + ColorEnum.RESET.getColorCode()));
    }
}





