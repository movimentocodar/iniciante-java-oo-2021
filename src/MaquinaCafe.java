import menu.MenuPrincipal;
import model.ModoDePreparo;
import model.Produto;

public class MaquinaCafe {

    public static void main(String[] args) {
        Produto.criarProduto();
        ModoDePreparo.criarModoDePreparo();
        MenuPrincipal.menuPrincipal();
    }
}
