package br.com.movimentocodar.maquinadecafe;

import java.math.BigDecimal;
import java.util.Scanner;

public class CafeScanner {
    Scanner Scanner = new Scanner(System.in);

    private String mensagem;
    private String respostaEsperada;

    public CafeScanner(String mensagem, String respostaEsperada) {
        this.mensagem = mensagem;
        this.respostaEsperada = respostaEsperada;
    }

    public CafeScanner(String mensagem) {
        this.mensagem = mensagem;
    }

    public void pedirConfirmacaoUsuario(){
        String entry = "";
        do
        {
            System.out.println(this.mensagem);
            entry = Scanner.next();
            checarSair(entry);
        } while(!entry.equals(this.respostaEsperada.toLowerCase()));
    }

    public void pedirSelecaoBebidaDoUsuario(MaquinaDeCafe MaquinaDeCafe){
        String entry = "";
        do
        {
            System.out.println(this.mensagem);
            entry = Scanner.next();
            checarSair(entry);
        } while(!MaquinaDeCafe.encontrarBebidaPeloID(entry));
    }

    public BigDecimal pedirSelecaoReaisAoUsuario(BigDecimal preco){
        String entry = "";
        BigDecimal valorInserido = BigDecimal.ZERO;
        BigDecimal valorAPagar = preco;
        BigDecimal valorPago = BigDecimal.ZERO;
        do
        {
            valorAPagar = preco.subtract(valorPago);
            System.out.println(this.mensagem);
            System.out.println("Faltam " + Pagamento.moedaEmReais(valorAPagar));
            entry = Scanner.next();
            checarSair(entry);
            valorInserido = calcularValorInserido(entry);
            valorPago = valorPago.add(valorInserido);
        } while(valorPago.compareTo(preco) < 0);


        return valorPago.subtract(preco);
    }

    private BigDecimal calcularValorInserido(String entry){

        NotasEMoedas Reais[] = NotasEMoedas.values();
        for (NotasEMoedas real: Reais) {
            if(entry.equals(Integer.toString(real.getId()))){
                return real.getValor();
            }
        }

        return BigDecimal.ZERO;
    }

    public Acucar pedirSelecaoAcucarDoUsuario(){
        Acucar AcucarEscolhida = Acucar.NIVEL_0;
        String entry = "";
        do
        {
            System.out.println(this.mensagem);
            entry = Scanner.next();
            checarSair(entry);
        } while(!acucarEncontrada(entry));

        Acucar NiveisAcucar[] = Acucar.values();
        for (Acucar nivel: NiveisAcucar) {
            if (entry.equals(Integer.toString(nivel.getId()))){
                AcucarEscolhida = nivel;
            }
        }

        return AcucarEscolhida;
    }

    private boolean acucarEncontrada(String entry){
        Acucar NiveisAcucar[] = Acucar.values();
        for (Acucar nivel: NiveisAcucar) {
            if (entry.equals(Integer.toString(nivel.getId()))){
                return true;
            }
        }

        return false;
    }

    public int pedirMetodoDePagamentoAoUsuario(){
        String entry = "";
        do
        {
            System.out.println(this.mensagem);
            entry = Scanner.next();
            checarSair(entry);
        } while(!metodoEncontrado(entry));

        return Integer.parseInt(entry);
    }

    private boolean metodoEncontrado(String entry){
        if (entry.equals("1") || entry.equals("2") || entry.equals("3")){
            return true;
        }

        return false;
    }



    private void checarSair(String entry){
        if (entry.equals("sair")){
            System.out.println("Obrigado por utilizar a máquina de café 2021, o programa irá encerrar agora.");
            System.exit(-1);
        }
    }

    public Cupom pedirCodigoCupomAoUsuario(Cupons cupons) {
        String entry = "";
        do
        {
            System.out.println(this.mensagem);
            entry = Scanner.next();
            checarSair(entry);
        } while(!cupomEncontrado(entry, cupons));

        return cupons.encontrarCupom(entry);
    }

    private boolean cupomEncontrado(String entry, Cupons cupons){
        if(cupons.encontrarCupom(entry) != null){
            return true;
        }
        return false;
    }
}
