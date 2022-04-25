package menu;
import model.Color;
import util.InputScanner;

public class Painel {
    private static final InputScanner input = new InputScanner() {
        @Override
        public int entrada() {
            return super.entrada();
        }
    };
    private static final InputScanner fechar = new InputScanner() {
        @Override
        public void sair() {
            super.sair();
        }
    };


    private static void menu() {
        int opcao;

        do {

            System.out.println(Color.YELLOW.getColorCode() + "\n[ HUGOOGLE CAFE MENU  ] ");
            System.out.println("\n"
                    + Color.RESET.getColorCode()
                    + "(1) - Comprar \n"
                    + "(2) - Abastecer \n"
                    + "(3) - Sair \n");
            do {
                System.out.print(Color.YELLOW.getColorCode() + "\nPor favor selecione  uma opcao desejada:  de 1 a 3: " + Color.RESET.getColorCode());

                opcao = input.entrada();

                System.out.println((opcao < 1 || opcao > 3) ? Color.RED.getColorCode() + "\nOPCAO INVALIDA!" : " ");

            } while (opcao < 1 || opcao > 3);

            switch (opcao) {
                case 1 -> {
                    System.out.println(Color.BLUE.getColorCode() + "-- COMPRAR -- \n" + Color.RESET.getColorCode());
                    MenuCompra.menuCompra();
                }
                case 2 -> {
                    System.out.println(Color.BLUE.getColorCode() + "\n -- ABASTECER -- " + Color.RESET.getColorCode());
                    MenuAbastecer.abastecer();
                }

                case 3 -> {
                    System.out.println(Color.BLUE.getColorCode() + "-- SAIR -- \n" + Color.RESET.getColorCode());
                    fechar.sair();
                }

            }

        } while (opcao != 3);

    }

    public static void menuPrincipal() {
        menu();
    }


}