package br.com.hugoogle.service;

import br.com.hugoogle.Validacao.ValidaOpcaoNivelPadrao;
import br.com.hugoogle.Validacao.ValidarNivelDeAcucar;
import br.com.hugoogle.mensagem.MensagemNivelPadraoDeAcucar;
import br.com.hugoogle.menu.fabrica.Bebida;

public class FuncaoService {

    private int novoNivel = 3;

    public int nivelDeAcucar(Bebida bebida) {
        if (bebida.isNotGratis()) {

            int opcao;

            MensagemNivelPadraoDeAcucar.mensagem();

            do {

                opcao = ValidaOpcaoNivelPadrao.getOpcao();


            } while (opcao < 1 || opcao > 2);

            do {

                novoNivel = ValidarNivelDeAcucar.novoNivel(opcao, novoNivel);

            } while (novoNivel < 1 || novoNivel > 5);
            return novoNivel;
        }
        return 0;
    }
}