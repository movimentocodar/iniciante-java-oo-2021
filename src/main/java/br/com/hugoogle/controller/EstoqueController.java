package br.com.hugoogle.controller;

import br.com.hugoogle.model.Produto;
import br.com.hugoogle.service.EstoqueService;

import java.util.List;
import java.util.Map;

public class EstoqueController {

    private final EstoqueService estoqueService = new EstoqueService();

    public void atualizarEstoque( Map<Produto, List<Double>> produtoEQuantidade) {
        estoqueService.atualizarEstoque(produtoEQuantidade);
    }
}
