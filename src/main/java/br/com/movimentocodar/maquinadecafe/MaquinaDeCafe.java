package br.com.movimentocodar.maquinadecafe;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MaquinaDeCafe {
    ReservatorioDeAgua ReservatorioDeAgua;
    private ArrayList<Bebida> menu = new ArrayList<Bebida>();
    Acucar NivelAcucarEscolhido;
    Bebida BebidaEscolhida;

    public MaquinaDeCafe(ReservatorioDeAgua ReservatorioDeAgua) {
        this.ReservatorioDeAgua = ReservatorioDeAgua;

        Bebida Cafe = new Cafe();
        Bebida CafeComLeite = new CafeComLeite();
        Bebida Cappuccino = new Cappuccino();
        Bebida ChaDeLimao = new ChaDeLimao();
        Bebida AguaQuente = new AguaQuente();
        menu.add(Cafe);
        menu.add(CafeComLeite);
        menu.add(Cappuccino);
        menu.add(ChaDeLimao);
        menu.add(AguaQuente);

        BoasVindas();
    }

    public void BoasVindas(){
        System.out.println("-----Seja bem-vindo a máquina de café 2021!-----");
        System.out.println("Atenção: essa máquina não devolve troco, apenas cupom.");
        System.out.println("Para sair, digite 'sair' a qualquer momento.");
    }

    public boolean encontrarBebidaPeloID(String entry){
        try{
            this.BebidaEscolhida = menu.get(Integer.parseInt(entry));
            assert(this.BebidaEscolhida != null): "Bebida encontrada " + this.BebidaEscolhida.toString();
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    public void menu(){
        for (Bebida bebida : menu) {
            System.out.println(bebida.getId() + " - " + bebida.toString() + " - " + (bebida.getPreco().compareTo(BigDecimal.ZERO) == 0? "grátis" : Pagamento.moedaEmReais(bebida.getPreco())));
        }
    }

    public void liberarBebida(){
        try {
            this.ReservatorioDeAgua.liberarAguaParaUmaBebida();

            if (NivelAcucarEscolhido == null) {
                NivelAcucarEscolhido = Acucar.NIVEL_0;
            }
            this.BebidaEscolhida.receita.preparar(NivelAcucarEscolhido);
            System.out.println("Retire a bebida e obrigado por utilizar a máquina de café.");
        } catch (Exception ex){
            System.out.println("Necessário escolher uma bebida primeiro e ter reservatórios de água cheios");
        }
    }

    public Bebida selecionarBebida(){
        CafeScanner selecionarBebida = new CafeScanner("Digite o número da bebida escolhida");
        selecionarBebida.pedirSelecaoBebidaDoUsuario(this);
        System.out.println("A bebida escolhida foi " + this.BebidaEscolhida.toString());

        return this.BebidaEscolhida;
    }

    public Acucar determinarNivelDeAcucar(){
        System.out.println("--Favor escolher um nível de açúcar para sua bebida--");
        Acucar NiveisDeAcucar[] = Acucar.values();
        for (Acucar nivel : NiveisDeAcucar) {
            nivel.imprimirNiveisDeAcucar();
        }
        CafeScanner nivelDeAcucar = new CafeScanner("Digite o número do nível de açúcar escolhido.");
        return this.NivelAcucarEscolhido = nivelDeAcucar.pedirSelecaoAcucarDoUsuario();
    }

}
