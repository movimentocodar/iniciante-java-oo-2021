package service;

import menu.MenuCompra;
import model.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EstoqueService {
    private static int qtdTotalDeAcucar = 0;
    private static int qtdTotalDeAcucarPorCopo = 0;

    private Receita modoDepreparo;


    private double valorTotal;

    public double getValorTotal() {
        return valorTotal;
    }


    public void consultarEstoque(int opcao, int qtdCopo) {
        verificarSaldoDeEstoqueDisponivel(opcao, qtdCopo);
    }

    private void verificarSaldoDeEstoqueDisponivel(int opcao, int qtdCopos) {

        Optional<Receita> receita = Receita.getReceita(opcao);
        List<Ingrediente> ingredientes = receita.map(Receita::getIngredientes).orElse(Collections.emptyList());

        for (Ingrediente ingrediente : ingredientes) {

            getEstoque().stream().filter(p -> p.getCodigo() == ingrediente.getCodigo()).findAny().ifPresent(produto -> {

                int necessidade = qtdCopos * ingrediente.getQuantidade();
                if (necessidade > produto.getEstoque()) {
                    int qtd = produto.getEstoque() - necessidade;

                    System.out.println(Color.RED.getColorCode()
                            + "\nQuantidade de " + produto.getDescricao()
                            + " insuficiente, a maquina precisa ser reabastecida!"
                            + "\nQuantidade faltante: "
                            + Math.abs(qtd)
                            + produto.getEmbalagem() + "\n"
                            + Color.RESET.getColorCode());

                    MenuCompra.menuCompra();
                } else {
                    addPedidoPorProduto(produto, necessidade);
                }

            });

        }

        valorTotal = calcularValorTotal(qtdCopos, receita.orElseThrow());

        modoDepreparo = getReceita(receita.orElseThrow());

    }

    protected void consultarSaldoDeEstoqueAcucar(int qtdCopos, int nivelDeAcucar) {

        Produto produto = getEstoque().stream().filter(p -> p.getCodigo() == 8).findFirst().orElseThrow();

        qtdTotalDeAcucar = qtdCopos * (nivelDeAcucar * 3); // aplica 3g de acucar por nivel
        qtdTotalDeAcucarPorCopo = qtdTotalDeAcucar / qtdCopos;
        int necessidade = produto.getEstoque() - qtdTotalDeAcucar;


        if (qtdTotalDeAcucar > produto.getEstoque()) {
            System.out.println(Color.RED.getColorCode()
                    + "Quantidade de acucar insuficiente a maquina precisa ser reabastecida!"
                    + "\nSaldo em estoque: "
                    + produto.getEstoque() + "g"
                    + "\nQuantidade faltante: "
                    + Math.abs(necessidade)
                    + produto.getEmbalagem() + "\n"
                    + Color.RESET.getColorCode());

            MenuCompra.menuCompra();
        }


    }

    private void addPedidoPorProduto(Produto produto, int quantidade) {
        Pedido.addPedido(produto, quantidade);
    }

    private  double calcularValorTotal(int qtdCopos, Receita receita) {
        return receita.getPreco() * qtdCopos;
    }

    private  Receita getReceita(Receita receita) {
        return receita;
    }

    public  Receita getModoDePreparo() {
        return modoDepreparo;
    }

    public  int getQtdTotalDeAcucar() {
        return qtdTotalDeAcucar;
    }

    public  int getQtdTotalDeAcucarPorCopo() {
        return qtdTotalDeAcucarPorCopo;
    }

    public List<Produto> getEstoque(){
        return Estoque.getEstoqueProduto();
    }

}
