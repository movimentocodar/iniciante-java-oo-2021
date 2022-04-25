package service;

import menu.Painel;
import model.Color;
import util.InputScanner;


public class AbastecimentoService {

    private  final int ESTOQUEPADRAO = 1000;
    private  int necessidade;
    private static final InputScanner input = new InputScanner();
    private final EstoqueService estoqueService = new EstoqueService();


    public int consultarSaldoDeEstoquePorProduto() {

        estoqueService.getEstoque().stream().filter(e -> e.getEstoque() < 1000).forEach(produto -> {
            necessidade = Math.abs(produto.getEstoque() - 1000);
            System.out.println(Color.RED.getColorCode()
                    + "\nQuantidade de " + produto.getDescricao()
                    + " insuficiente, a maquina precisa ser reabastecida!"
                    + "\nQuantidade faltante: "
                    + necessidade
                    + produto.getEmbalagem() + "\n"
                    + Color.RESET.getColorCode());
        });
        return necessidade;
    }

    public void reabastecerAMaquina() {
        int opcao;

        do {
            opcao = getReabastecimento("Deseja reabastecer a maquina?\n");

        } while (opcao < 1 || opcao > 2);

        do {
            opcao = getReabastecimento("Confirmar o reabastecimento?\n");

        } while (opcao < 1 || opcao > 2);


        estoqueService.getEstoque().stream().filter(e -> e.getEstoque() < 1000).forEach(
                produto -> produto.setEstoque(ESTOQUEPADRAO));


        System.out.println(Color.GREEN.getColorCode() + "\nMaquina reabastecida com sucesso!" + Color.RESET.getColorCode());
        necessidade = 0;
    }



    private  int getReabastecimento(String x) {
        System.out.print(Color.YELLOW.getColorCode() + x
                + Color.RESET.getColorCode()
                + "\n(1) Sim"
                + "\n(2) Nao\n");
        System.out.print(Color.YELLOW.getColorCode() + "\nOpcao n: " + Color.RESET.getColorCode());
        int reabastecimento = input.entrada();

        System.out.println((reabastecimento < 1 || reabastecimento > 2) ? Color.RED.getColorCode() + "\nOpcao invalida!\n" + Color.RESET.getColorCode() : "");
        if (reabastecimento == 2) Painel.menuPrincipal();
        return reabastecimento;
    }



}
