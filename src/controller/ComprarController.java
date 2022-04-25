package controller;

import menu.MenuCompra;
import model.Pedido;
import model.Receita;
import service.*;

import java.util.List;

public class ComprarController {

    EstoqueService estoqueService = new EstoqueService();
    FuncaoService funcaoService = new FuncaoService();
    PagamentoService pagamentoService = new PagamentoService();
    BebidaService bebidaService = new BebidaService();
    MovimentoService movimentoService = new MovimentoService();



    public void comprarProduto(int opcao, int qtdCopos){
        validarCompra(opcao, qtdCopos);
    }

    private void validarCompra(int opcao, int qtdCopos) {
        boolean isPagamentoRealizado;
        estoqueService.consultarEstoque(opcao, qtdCopos);

        boolean itemGratis = isItemGratis(opcao, qtdCopos);

        if (itemGratis) isPagamentoRealizado = true;
        else isPagamentoRealizado = pagamentoService.realizarPagamento(getValorTotal());


        if(isPagamentoRealizado)
        bebidaService.prepararBebida(getModoPreparo(), qtdCopos, itemGratis);
        movimentoService.atualizarEstoque(getListaDePedidos(), getQuantidadeTotalAcucar());
        Pedido.resetListaPedida();
        MenuCompra.menuCompra();

    }

    private boolean isItemGratis(int opcao, int qtdCopos) {
        boolean itemGratis = false;
        int codigoMenuAgua = Receita.getCodigoMenuAgua();
        if (codigoMenuAgua != opcao) {
            funcaoService.nivelDeAcucar(qtdCopos);
        } else {
            itemGratis = true;
        }
        return itemGratis;
    }

    private double getValorTotal(){
        return estoqueService.getValorTotal();

    }

    private Receita getModoPreparo(){
        return  estoqueService.getModoDePreparo();
    }

    private  int getQuantidadeTotalAcucar(){
       return estoqueService.getQtdTotalDeAcucar();
    }

    private List<Pedido> getListaDePedidos(){
        return Pedido.getListaDePedidos();
    }


}
