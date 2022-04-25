import menu.Painel;
import model.Estoque;
import model.Receita;

public class MaquinaCafe {

    public static void main(String[] args) {
        Estoque.carregarProdutos();
        Receita.carregarReceita();
        Painel.menuPrincipal();
    }
}
