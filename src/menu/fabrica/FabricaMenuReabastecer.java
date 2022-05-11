package menu.fabrica;

import calculadora.CalcularQuantidadeAProduzir;
import controller.AbastecimentoController;
import menu.submenu.SubMenuCompra;

public class FabricaMenuReabastecer {

    private static final int SIM = 1;
    private static final int NAO = 2;
    private static final AbastecimentoController abastecimentoController = new AbastecimentoController();
    private static final CalcularQuantidadeAProduzir calcularQuantidadeAproduzir = new CalcularQuantidadeAProduzir();
    public static void getMenu(int opcaoMenu) {
        switch (opcaoMenu) {
            case SIM -> abastecimentoController.abastecer(calcularQuantidadeAproduzir.getProdutosEQuantidade());
            case NAO -> SubMenuCompra.menu();
            default -> {
            }
        }
    }
}
