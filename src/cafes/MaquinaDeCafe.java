package cafes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class MaquinaDeCafe {

    public static void main(String[] args) {
        Scanner cafeScanner = new Scanner(System.in);
        Bebida BebidasMenu = new Bebida();
        ReservatorioDeAgua reservaDeAguaAtual = new ReservatorioDeAgua();

        Receita ReceitaDeCafe = new Receita(true, true);
        ReceitaDeCafe.setQuantidadeDePoCafe(10);

        Receita ReceitaDeCafeComLeite = new Receita(true, true);
        ReceitaDeCafeComLeite.setQuantidadeDePoCafe(5);
        ReceitaDeCafeComLeite.setQuantidadeDeLeite(10);

        Receita ReceitaDeCappuccino = new Receita(true, true);
        ReceitaDeCappuccino.setQuantidadeDePoCafe(5);
        ReceitaDeCappuccino.setQuantidadeDeLeite(5);
        ReceitaDeCappuccino.setQuantidadeDeChocolate(5);

        Receita ReceitaDeChaDeLimao = new Receita(true, true);
        ReceitaDeChaDeLimao.setQuantidadeDeLimao(10);

        Receita ReceitaDeAguaQuente = new Receita(true, false);

        Bebida Cafe = new Bebida(0,"Café",ReceitaDeCafe, 0.50);
        Bebida CafeComLeite = new Bebida(1,"Café com leite", ReceitaDeCafeComLeite, 1.00);
        Bebida Capuccino = new Bebida(2,"Capuccino",ReceitaDeCappuccino,1.50);
        Bebida ChaDeLimao = new Bebida(3,"Chá de limão", ReceitaDeChaDeLimao, 1.00);
        Bebida AguaQuente = new Bebida(4, "Água Quente", ReceitaDeAguaQuente, 0.00);

        Inicializacao(cafeScanner, reservaDeAguaAtual, BebidasMenu);

    }

    private static void Inicializacao(Scanner cafeScanner, ReservatorioDeAgua reservaDeAguaAtual, Bebida BebidasMenu){
        String msgReservatorioDeAgua = reservaDeAguaAtual.getQuantidadeDeAguaNoReservatorio() >= 50? "suficiente para " + (reservaDeAguaAtual.getQuantidadeDeAguaNoReservatorio() /50) + " bebidas." : "vazios.";

        System.out.println("-----Seja bem-vindo a máquina de café 2021!-----");
        System.out.println("Atenção: essa máquina não devolve troco.");
        System.out.println("Para sair, digite 'sair' a qualquer momento.");
        System.out.println("Reservatórios de água " + msgReservatorioDeAgua);

        if(reservaDeAguaAtual.getQuantidadeDeAguaNoReservatorio() > 50){
            ProcessoDeAtendimento(cafeScanner, reservaDeAguaAtual, BebidasMenu);
        } else {
            String keyRepor = "repor";
            String repor = "";
            do
            {
                repor = getScanner(cafeScanner, "Por favor, digite 'repor' para repor quantidade de água");
            } while(!keyRepor.equals(repor.toLowerCase()));

            reservaDeAguaAtual.reporQuantidadeDeAguaNoReservatorio();
            System.out.println("Reservatório de água completo!");
            ProcessoDeAtendimento(cafeScanner, reservaDeAguaAtual, BebidasMenu);
        }
    }

    private static void ProcessoDeAtendimento(Scanner cafeScanner, ReservatorioDeAgua reservaDeAguaAtual, Bebida BebidasMenu) {
        NotasEMoedas todasNotaseMoedas = new NotasEMoedas();
        todasNotaseMoedas.getListaDeReais();

        if(reservaDeAguaAtual.getQuantidadeDeAguaNoReservatorio() > 50){
            for (int i = 0; i < BebidasMenu.getMenu().size(); i++) {
                System.out.println(BebidasMenu.getMenu().get(i).getId() + " " + BebidasMenu.getMenu().get(i).getNome() + ", preço: " + (BebidasMenu.getMenu().get(i).getPreco() == 0? "grátis" : moedaEmReais(BebidasMenu.getMenu().get(i).getPreco())));
            }

            String bebidaEscolhida = "";
            do {
                bebidaEscolhida = getScanner(cafeScanner, "Digite o número da bebida escolhida");
            } while(bebidaEncontrada(bebidaEscolhida, BebidasMenu) == -1);

            System.out.println("A bebida escolhida foi " + BebidasMenu.getMenu().get(Integer.parseInt(bebidaEscolhida)).getNome());

            double precoBebidaEscolhida = BebidasMenu.getMenu().get(Integer.parseInt(bebidaEscolhida)).getPreco();

            if(precoBebidaEscolhida == 0){
                System.out.println("A bebida será de graça.");
                BebidasMenu.getMenu().get(Integer.parseInt(bebidaEscolhida)).receita.Processo(Acucar.Nivel0, reservaDeAguaAtual);

                Finalizacao(cafeScanner, reservaDeAguaAtual, BebidasMenu);
            } else {
                System.out.println("O total é de " + moedaEmReais(BebidasMenu.getMenu().get(Integer.parseInt(bebidaEscolhida)).getPreco()) + ".");

                String metodoDePagamentoEscolhido = "";
                do {
                    metodoDePagamentoEscolhido = getScanner(cafeScanner, "Digite 1 para pagamento em dinheiro e 2 para pagamento em cartão de débito.");
                } while(metodoDePagamento(metodoDePagamentoEscolhido) == -1);

                if(String.valueOf(metodoDePagamentoEscolhido).equals("1")){
                    System.out.println("A melhor opção para pagamento em dinheiro é");
                    System.out.println("Sugestão 1 " + SugestoesNotasEMoedasFormatadas(BebidasMenu.getMenu().get(Integer.parseInt(bebidaEscolhida)).getPreco(), todasNotaseMoedas, false));
                    System.out.println("Sugestão 2 " + SugestoesNotasEMoedasFormatadas(BebidasMenu.getMenu().get(Integer.parseInt(bebidaEscolhida)).getPreco(), todasNotaseMoedas, true));

                    String sugestaoMoeda = "";
                    do {
                        sugestaoMoeda = getScanner(cafeScanner, "Digite 1 ou 2 para aceitar a sugestão ou 3 para adicionar qualquer nota ou moeda. Atenção: essa máquina não devolve troco.");
                    } while(aceitarSugestaoMoeda(sugestaoMoeda) == -1);

                    if(String.valueOf(sugestaoMoeda).equals("3")){
                        System.out.println("--Favor digitar o número da nota ou moeda inserida--");
                        for (int i = 0; i < todasNotaseMoedas.getListaDeReais().size(); i=i+2) {
                            if((i+1) == todasNotaseMoedas.getListaDeReais().size()){
                                System.out.println(todasNotaseMoedas.getListaDeReais().get(i).getId() + " - " + todasNotaseMoedas.getListaDeReais().get(i).getNome());
                            } else {
                                System.out.println(todasNotaseMoedas.getListaDeReais().get(i).getId() + " - " + todasNotaseMoedas.getListaDeReais().get(i).getNome() + "    " + todasNotaseMoedas.getListaDeReais().get(i + 1).getId() + " - " + todasNotaseMoedas.getListaDeReais().get(i + 1).getNome());
                            }
                        }

                        String moedaInserida = "";
                        double quantoFalta = BebidasMenu.getMenu().get(Integer.parseInt(bebidaEscolhida)).getPreco();
                        do {
                            moedaInserida = getScanner(cafeScanner, "Favor digitar o número da nota ou moeda inserida. Faltam " + moedaEmReais(quantoFalta) + ". Atenção: essa máquina não devolve troco.");
                            quantoFalta = calcularMoedaInserida(moedaInserida, todasNotaseMoedas, quantoFalta);
                        } while(quantoFalta > 0);

                        System.out.println("Pagamento concluído!");
                        if(quantoFalta != 0){
                            System.out.println("O valor excedente é de " + moedaEmReais(quantoFalta*-1) + " e não poderá ser devolvido.");
                        }
                    }

                } else {
                    String pagamentoEfetuado = "";
                    do {
                        pagamentoEfetuado = getScanner(cafeScanner, "Digite 1 para cartão inserido");
                    } while(pagamentoCartaoDeDebito(pagamentoEfetuado) == -1);
                }

                System.out.println("--Favor escolher um nível de açúcar para sua bebida--");

                for (int i = 0; i < Acucar.getNiveisDeAcucar().size() ; i++) {
                    System.out.println(i + " - " + Acucar.getNiveisDeAcucar().get(i).getQuantidadeDeAcucar());
                }

                String nivelDeAcucarEscolhido = "";
                do {
                    nivelDeAcucarEscolhido = getScanner(cafeScanner, "Digite o número do nível de açúcar escolhido.");
                } while(nivelDeAcucarEncontrada(nivelDeAcucarEscolhido) == -1);

                BebidasMenu.getMenu().get(Integer.parseInt(bebidaEscolhida)).receita.Processo(Acucar.getNiveisDeAcucar().get(Integer.parseInt(nivelDeAcucarEscolhido)), reservaDeAguaAtual);
                Finalizacao(cafeScanner, reservaDeAguaAtual, BebidasMenu);
            }
        }
    }

    public static double calcularMoedaInserida(String moedaInserida, NotasEMoedas todasNotaseMoedas, double quantoFalta){
        for (int i = 0; i < todasNotaseMoedas.getListaDeReais().size(); i++) {
            if(String.valueOf(moedaInserida).equals(Integer.toString(todasNotaseMoedas.getListaDeReais().get(i).getId()))){
                return quantoFalta - todasNotaseMoedas.getListaDeReais().get(i).getValor();
            }
        }
        return quantoFalta;
    }

    public static String SugestoesNotasEMoedasFormatadas(double Preco, NotasEMoedas NotasEMoedasReais, boolean SegundaSugestao){
        String SugestaoDeNotasEMoedas = "";
        NotasEMoedas NotasEMoedasCalculadas = CalcularSugestoes(Preco, NotasEMoedasReais, SegundaSugestao);
        boolean ignorarMaiorValor = false;

        if (SegundaSugestao){
            System.out.println("-- ou --");
            ignorarMaiorValor = true;
        }

        for(int i = 0; i < NotasEMoedasCalculadas.getListaDeReais().size(); i++){
            if (!String.valueOf(NotasEMoedasCalculadas.getListaDeReais().get(i).getQuantidade()).equals("0")){
                if (ignorarMaiorValor){
                    ignorarMaiorValor = false;
                }else {
                    SugestaoDeNotasEMoedas += NotasEMoedasCalculadas.getListaDeReais().get(i).getQuantidade() + " unid. de " + NotasEMoedasCalculadas.getListaDeReais().get(i).getNome() + ", ";
                }
            }
        }
        SugestaoDeNotasEMoedas = SugestaoDeNotasEMoedas.substring(0, (SugestaoDeNotasEMoedas.length() - 2));
        return SugestaoDeNotasEMoedas;
    }

    private static NotasEMoedas CalcularSugestoes(double Preco, NotasEMoedas NotasEMoedasReais, boolean SegundaSugestao){
        double contagemPrecoEmNotas = 0;
        double contagemPrecoEmMoedas = 0;
        double contagemConsiderada;
        boolean encontrouMaiorValor = false;
        int quantidadeDeREAL;
        double precoMoedas = Preco - Math.floor(Preco);
        double precoConsiderado;

        for(int i = 0; i < NotasEMoedasReais.getListaDeReais().size(); i++){
            boolean IsMoeda = NotasEMoedasReais.getListaDeReais().get(i).isMoeda() && NotasEMoedasReais.getListaDeReais().get(i).getId() != 7;

            if(!IsMoeda) {
                precoConsiderado = Preco;
                contagemConsiderada = contagemPrecoEmNotas;
            }else{
                precoConsiderado = precoMoedas;
                contagemConsiderada = contagemPrecoEmMoedas;
            }

            if(SegundaSugestao && !encontrouMaiorValor){
                quantidadeDeREAL = (int)(precoConsiderado / NotasEMoedasReais.getListaDeReais().get(i).getValor());
                if (quantidadeDeREAL >= 1){
                    encontrouMaiorValor = true;
                }
            } else {
                quantidadeDeREAL = (int) ((precoConsiderado - contagemConsiderada) / NotasEMoedasReais.getListaDeReais().get(i).getValor());
                NotasEMoedasReais.getListaDeReais().get(i).setQuantidade(quantidadeDeREAL);

                if(!IsMoeda){
                    contagemPrecoEmNotas += quantidadeDeREAL * NotasEMoedasReais.getListaDeReais().get(i).getValor();
                }else {
                    contagemPrecoEmMoedas += quantidadeDeREAL * NotasEMoedasReais.getListaDeReais().get(i).getValor();
                }
            }

            if((contagemPrecoEmNotas + contagemPrecoEmMoedas) == Preco){
                break;
            }
        }
        return NotasEMoedasReais;
    }

    private static int aceitarSugestaoMoeda(String sugestaoMoeda){
        if(String.valueOf(sugestaoMoeda).equals("1") || String.valueOf(sugestaoMoeda).equals("2")){
            System.out.println("Pagamento efetuado!");
            return 1;
        }

        if(String.valueOf(sugestaoMoeda).equals("3")){
            return 3;
        }

        return -1;
    }

    private static int nivelDeAcucarEncontrada(String nivelDeAcucarEscolhido) {
        for (int i = 0; i < Acucar.getNiveisDeAcucar().size() ; i++) {
            if(nivelDeAcucarEscolhido.equals(String.valueOf(i))){
                return i;
            }
        }
        return -1;
    }

    private static void Finalizacao(Scanner cafeScanner, ReservatorioDeAgua reservaDeAguaAtual, Bebida BebidasMenu){
        System.out.println("Retire a bebida e obrigado por utilizar a máquina de café.");

        String comecar = "";
        Boolean digitouCerto = false;
        do {
            comecar = getScanner(cafeScanner, "Digite 'sair' para sair ou 'começar' para comprar outra bebida.");
            digitouCerto = solicitarRecomeco(comecar);
        } while(digitouCerto);

        Inicializacao(cafeScanner, reservaDeAguaAtual, BebidasMenu);
    }

    private static boolean solicitarRecomeco(String comecar){
        String keyComecarComCidilha = "começar";
        String keyComecar = "comecar";

        if(comecar.toLowerCase().equals(keyComecar)){
            return false;
        }

        if(comecar.toLowerCase().equals(keyComecarComCidilha)){
            return false;
        }

        return true;
    }


    private static int pagamentoCartaoDeDebito(String pagamentoEfetuado){
        if(String.valueOf(pagamentoEfetuado).equals("1")){
            System.out.println("Transação aprovada");
            return 1;
        }

        return -1;
    }

    private static int metodoDePagamento(String metodoDePagamentoEscolhido){
        if(String.valueOf(metodoDePagamentoEscolhido).equals("1")){
            return 1;
        } else if (String.valueOf(metodoDePagamentoEscolhido).equals("2")){
            return 2;
        }

        return -1;
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
        if (entry.equals("sair")){
            System.out.println("Obrigado por utilizar a máquina de café 2021.");
            System.exit(-1);
        }
        return entry;
    }
}
