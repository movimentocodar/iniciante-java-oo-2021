package service;

import Validacao.ValidaOpcaoNivelPadrao;
import Validacao.ValidarNivelDeAcucar;
import mensagem.MensagemNivelPadraoDeAcucar;
import menu.fabrica.Bebida;

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