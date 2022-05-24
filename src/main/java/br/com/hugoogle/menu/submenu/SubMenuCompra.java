package menu.submenu;

import Validacao.*;
import br.com.hugoogle.calculadora.CalcularQuantidadeAProduzir;
import command.*;
import controller.*;
import menu.MenuPrincipal;
import menu.fabrica.Bebida;
import menu.fabrica.FabricarBebida;

import model.Produto;
import service.FuncaoService;
import util.InputScanner;

import java.util.List;
import java.util.Map;

import static mensagem.MensagemInformarQuantidadeDeCopos.mensagemInformarQuantidadeDeCopos;

public class SubMenuCompra {

    private final InputScanner input = new InputScanner();
    private static final int INICIO = 1;
    private static final int FINAL = 6;

    private final FabricarBebida fabricaDeBebida = new FabricarBebida();
    private final EstoqueController estoqueController = new EstoqueController();
    private final FuncaoService funcaoService = new FuncaoService();
    private final CalcularQuantidadeAProduzir calcularQuantidadeAProduzir = new CalcularQuantidadeAProduzir();

    private final GerarPedidoHandler gerarPedidoHandler = new GerarPedidoHandler();

    public SubMenuCompra() {
        menu();
    }


    public void menu() {

        int opcao = getOpcao();

        int qtdCopos = getQtdCopos();

        Bebida bebida = fabricaDeBebida.getBebida(opcao);

        int nivelDeAcucar = funcaoService.nivelDeAcucar(bebida);

        gerarPedidoHandler.processarPedido(bebida, qtdCopos, nivelDeAcucar);

        SubMenuPagamento.menu(bebida);

        bebida.prepararBebida(bebida, qtdCopos);

        Map<Produto, List<Double>> produtosEQuantidadeAProduzir = calcularQuantidadeAProduzir.getProdutosEQuantidade();
        estoqueController.atualizarEstoque(produtosEQuantidadeAProduzir);
        new MenuPrincipal();
       }

    private int getOpcao() {
        int opcao;
        do {
            OpcaoSubMenuCompra.menu();
            opcao = input.entrada();
            ValidarOpcao.valida(new OpcaoMenuValidator(), opcao, INICIO, FINAL);
        } while (opcao < INICIO || opcao > FINAL);
        return opcao;
    }

    private int getQtdCopos() {
        int qtdCopos;
        do {
            mensagemInformarQuantidadeDeCopos();
            qtdCopos = input.entrada();
            ValidarQuantidade.valida(new QtdCoposValidator(), qtdCopos);
        } while (qtdCopos < 1);
        return qtdCopos;
    }

}

