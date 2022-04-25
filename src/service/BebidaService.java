package service;

import model.Color;
import model.Receita;
import util.InputScanner;

public class BebidaService {

    EstoqueService estoqueService = new EstoqueService();

    private static final InputScanner input = new InputScanner() {
        @Override
        public int entrada() {
            return super.entrada();
        }
    };

    public void prepararBebida(Receita modoDePreparo, int qtdCopos, boolean itemGratis) {

        for (int i = 1; i <= qtdCopos; i++) {
            System.out.print(Color.BLUE.getColorCode() + "Iniciando o preparo do "
                    + i + " "
                    + modoDePreparo.getDescricao() + "\n"
                    + Color.RESET.getColorCode()
                    + modoDePreparo.getModoPreparos());

            adicionarAcucar(itemGratis);
            System.out.println(Color.GREEN.getColorCode() + "\n" + modoDePreparo.getDescricao() + " esta pronto!\n");
            confirmarRetirada(modoDePreparo.getDescricao());

        }
    }



    private static void confirmarRetirada(String descricao) {
        int opcao;
        do {
            System.out.println(Color.YELLOW.getColorCode() + "Retirar o " + descricao + ": " + Color.RESET.getColorCode()
                    + "\n(1) Sim"
                    + "\n(2) Nao");
            System.out.print(Color.YELLOW.getColorCode() + "\nOpcao n: " + Color.RESET.getColorCode());
            opcao = input.entrada();
            System.out.println(opcao != 1 ? Color.RED.getColorCode() +"\n Necessario confirmar a retirada para preparar o proximo produto!\n": "");


        } while (opcao != 1);
    }

    private  void adicionarAcucar(boolean itemGratis) {
        if(!itemGratis)
            System.out.print("Adicionando " + getQtdTotalDeAcucarPorCopo() + "g acucar \n");
    }

    private  int getQtdTotalDeAcucarPorCopo(){
        return  estoqueService.getQtdTotalDeAcucarPorCopo();
    }

}
