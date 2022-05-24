package br.com.hugoogle.menu.fabrica;

import br.com.hugoogle.calculadora.CalcularQuantidadeAProduzir;
import br.com.hugoogle.controller.AbastecimentoController;
import br.com.hugoogle.menu.submenu.SubMenuCompra;
import br.com.hugoogle.service.AbastecimentoService;

public class FabricaMenuReabastecer {
    private static final int SIM = 1;
    private static final int NAO = 2;
    private final AbastecimentoController abastecimentoController = new AbastecimentoController();
    private final CalcularQuantidadeAProduzir calcularQuantidadeAproduzir = new CalcularQuantidadeAProduzir();
    public void getMenu(int opcaoMenu) {
        switch (opcaoMenu) {
            case SIM -> abastecimentoController.abastecer(calcularQuantidadeAproduzir.getProdutosEQuantidade());
            case NAO -> new SubMenuCompra();
            default -> {
            }
        }
    }
}
