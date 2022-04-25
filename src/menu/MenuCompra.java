package menu;
import controller.ComprarController;
import model.Color;
import model.Estoque;
import model.Receita;
import util.InputScanner;

public class MenuCompra {

    private static final ComprarController comprarController = new ComprarController();
    private static final InputScanner input = new InputScanner() {
        @Override
        public int entrada() {
            return super.entrada();
        }
    };
    private static final String COPO = "Copo";
    private static final int INICIO = 1;
    private static final int FINAL = 1 + MenuCompra.quantidade();

    private  static void menu() {
        int opcao;
        do {

            menuDescricao();
            opcao = input.entrada();
            System.out.println((opcao < INICIO || opcao > FINAL) ? Color.RED.getColorCode() + "\nOPCAO INVALIDA!\n" : "" + Color.RESET.getColorCode());

        } while (opcao < INICIO || opcao > FINAL);

        int qtdCopos = 0;
        do {

            qtdCopos = opcaoSelecionada(opcao, qtdCopos);


        } while (qtdCopos < 1);

        comprarController.comprarProduto(opcao, qtdCopos);

    }

    private static int opcaoSelecionada(int opcao, int qtdCopos) {
        if (opcao == FINAL) {
            Painel.menuPrincipal();
        } else {
            qtdCopos = informarQuantidadeDeCopos();
            System.out.println((qtdCopos < 1) ? "\nQUANTIDADE INFORMADA INVALIDA!\n" + "QUANTIDADE MAXIMA " + Estoque.getEstoque(COPO) : "");
        }
        return qtdCopos;
    }


    public static void menuCompra() {
        menu();
    }

    private static int informarQuantidadeDeCopos() {
        System.out.print("Por favor informe a quantidade de copos: ");
        return input.entrada();
    }

    private static int quantidade() {
        return Receita.getQuantidade();

    }

    public static void menuDescricao() {
        System.out.println(Color.YELLOW.getColorCode() + "[ Selecione uma opcao: ]\n" + Color.RESET.getColorCode());
        Receita.getListaDescricao().forEach(System.out::println);
        System.out.println("(" + FINAL + ") Menu");
        System.out.print(Color.YELLOW.getColorCode() + "\nOpcao n: " + Color.RESET.getColorCode());

    }


}


