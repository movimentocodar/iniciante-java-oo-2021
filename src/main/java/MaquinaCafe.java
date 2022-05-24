import menu.MenuPrincipal;
import util.PopularModoDePreparo;
import util.PopularProdutos;

public class MaquinaCafe {

    public static void main(String[] args) {
        PopularProdutos.criarProduto();
        PopularModoDePreparo.criarModoDePreparo();
        MenuPrincipal.menu();
    }
}
