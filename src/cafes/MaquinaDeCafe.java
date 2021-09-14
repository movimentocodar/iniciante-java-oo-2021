package cafes;

import java.util.Scanner;
import java.math.*;

public class MaquinaDeCafe {

    public static void main(String[] args) {
        Scanner cafeScanner = new Scanner(System.in);
        Bebida BebidasMenu = new Bebida();
        ReservatorioDeAgua reservaDeAguaAtual = new ReservatorioDeAgua();

        Receitas ReceitaDeCafe = new Receitas (true, true);
        ReceitaDeCafe.setQuantidadeDePoCafe(10);

        Receitas ReceitaDeCafeComLeite = new Receitas (true, true);
        ReceitaDeCafeComLeite.setQuantidadeDePoCafe(5);
        ReceitaDeCafeComLeite.setQuantidadeDeLeite(10);

        Receitas ReceitaDeCappuccino = new Receitas (true, true);
        ReceitaDeCappuccino.setQuantidadeDePoCafe(5);
        ReceitaDeCappuccino.setQuantidadeDeLeite(5);
        ReceitaDeCappuccino.setQuantidadeDeChocolate(5);

        Receitas ReceitaDeChaDeLimao = new Receitas (true, true);
        ReceitaDeChaDeLimao.setQuantidadeDeLimao(10);

        Receitas ReceitaDeAguaQuente = new Receitas(true, false);

        Bebida Cafe = new Bebida(0,"Café",ReceitaDeCafe, 0.50);
        Bebida CafeComLeite = new Bebida(1,"Café com leite", ReceitaDeCafeComLeite, 1.00);
        Bebida Capuccino = new Bebida(2,"Capuccino",ReceitaDeCappuccino,1.50);
        Bebida ChaDeLimao = new Bebida(3,"Chá de limão", ReceitaDeChaDeLimao, 1.00);
        Bebida AguaQuente = new Bebida(4, "Água Quente", ReceitaDeAguaQuente, 0.00);

        if(reservaDeAguaAtual.getQuantidadeDeAguaNoReservatorio() > 50){
            Inicializacao(cafeScanner, reservaDeAguaAtual.getQuantidadeDeAguaNoReservatorio(), BebidasMenu);
        } else {
            String keyRepor = "repor";
            String repor = "";
            do
            {
               repor = getScanner(cafeScanner, "Por favor, digite 'repor' para repor quantidade de água");
            } while(!keyRepor.equals(repor.toLowerCase()));

            reservaDeAguaAtual.reporQuantidadeDeAguaNoReservatorio();
            System.out.println("Reservatório de água completo!");
            Inicializacao(cafeScanner, reservaDeAguaAtual.getQuantidadeDeAguaNoReservatorio(), BebidasMenu);
        }


    }

    private static void Inicializacao(Scanner cafeScanner, int AtualQuantidadeDeAgua, Bebida BebidasMenu) {

        String msgReservatorioDeAgua = AtualQuantidadeDeAgua > 50? "suficiente para " + (AtualQuantidadeDeAgua /50) + " bebidas" : "vazios, favor repor";

        System.out.println("Seja bem-vindo a máquina de café 2021!");
        System.out.println("Atenção: essa máquina não devolve troco.");
        System.out.println("Reservatórios de água " + msgReservatorioDeAgua);

        if(AtualQuantidadeDeAgua > 50){
            for (int i = 0; i < BebidasMenu.getMenu().size(); i++) {
                System.out.println(BebidasMenu.getMenu().get(i).getId() + " " + BebidasMenu.getMenu().get(i).getNome() + ", preço: " + (BebidasMenu.getMenu().get(i).getPreco() == 0? "grátis" : moedaEmReais(BebidasMenu.getMenu().get(i).getPreco())));
            }

            String bebidaEscolhida = "";
            do {
                bebidaEscolhida = getScanner(cafeScanner, "Digite o número da bebida escolhida");
            } while(bebidaEncontrada(bebidaEscolhida, BebidasMenu) == -1);

            System.out.println("A bebida escolhida foi " + BebidasMenu.getMenu().get(Integer.parseInt(bebidaEscolhida)).getNome());

        }
    }

    private static int bebidaEncontrada(String bebidaEscolhida, Bebida BebidasMenu){
        for(int i = 0; i < BebidasMenu.getMenu().size(); i++){
            int IDdasBebidasDoMenu = BebidasMenu.getMenu().get(i).getId();
            if(String.valueOf(IDdasBebidasDoMenu).equals(bebidaEscolhida)){
                return IDdasBebidasDoMenu;
            }
        }

        return -1;
    }

    private static String moedaEmReais(double valor) {
        BigDecimal b = new BigDecimal(valor);
        return "R$ " + b.setScale(2, RoundingMode.HALF_EVEN);
    }

    private static String getScanner(Scanner cafeScanner, String mensagem) {
        System.out.println(mensagem);
        String entry = cafeScanner.nextLine();
        return entry;
    }
}
