import br.com.hugoogle.menu.MenuPrincipal;
import br.com.hugoogle.util.PopularModoDePreparo;
import br.com.hugoogle.util.PopularProdutos;

public class MaquinaCafe {

    public static void main(String[] args) {
        PopularProdutos.criarProduto();
        PopularModoDePreparo.criarModoDePreparo();
        MenuPrincipal.menu();
    }
}
