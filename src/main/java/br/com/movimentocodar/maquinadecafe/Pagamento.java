package br.com.movimentocodar.maquinadecafe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pagamento {
    private BigDecimal valor;
    private boolean encontrouMaiorValor = false;
    private int metodoDePagamento;
    private List<Cupom> cupons;

    public Pagamento(BigDecimal valor){
        this.valor = valor;
    }

    public boolean Cortesia(){
        if (this.valor.compareTo(BigDecimal.ZERO) == 0){
            return true;
        }

        return false;
    }

    public String moedaEmReais() {
        return "R$ " + this.valor.setScale(2, RoundingMode.HALF_EVEN);
    }

    public static String moedaEmReais(BigDecimal valor) {
        return "R$ " + valor.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void lerJSON() throws IOException {
        byte[] mapData = Files.readAllBytes(Paths.get("target/cupom.json"));
        ObjectMapper mapper = new ObjectMapper();
        if (mapData.length > 0){
            this.cupons = new ArrayList<Cupom>(Arrays.asList(mapper.readValue(mapData, Cupom[].class)));
        } else {
            this.cupons = new ArrayList<Cupom>();
        }
    }

    public void gravarJSON() throws IOException {
        File file = new File("target/cupom.json");
        FileWriter fileWriter = new FileWriter(file, false);
        ObjectMapper mapper = new ObjectMapper();
        try {
            SequenceWriter seqWriter = mapper.writerWithDefaultPrettyPrinter().writeValues(fileWriter);
            seqWriter.write(this.cupons);

            seqWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cupom encontrarCupom(String codigo){
        return this.cupons.stream().filter(c -> c.getCodigo().equals(codigo)).findAny().get();
    }

    public boolean executarCobranca(int MetodoDePagamento) throws IOException {
        this.metodoDePagamento = MetodoDePagamento;
        if(this.cupons == null){ lerJSON();} //quando executar app
        // 1: Pagamento em dinheiro
        // 2: Pagamento em cartão de débito
        // 3: Utilizar voucher

            if(this.metodoDePagamento == 1) {
                imprimirSugestoesDePagamentoEmDinheiro();

                CafeScanner selecionarSugestaoDePagamentoComDinheiro = new CafeScanner("Digite 1 ou 2 para aceitar a sugestão referente ou 3 para escolher qualquer nota ou moeda. Atenção: caso o valor exceda o valor da compra será gerado um cupom válido por 3 meses.");
                int sugestaoDePagamentoComDinheiro = selecionarSugestaoDePagamentoComDinheiro.pedirMetodoDePagamentoAoUsuario();

                if(sugestaoDePagamentoComDinheiro == 3){
                    NotasEMoedas Reais[] = NotasEMoedas.values();
                    for (NotasEMoedas real: Reais) {
                        real.imprimir();
                    }

                    CafeScanner selecionarReais = new CafeScanner("Favor digitar o número da nota ou moeda inserida. Atenção: essa máquina não devolve troco, apenas cupom válido por 3 meses.");
                    BigDecimal troco = selecionarReais.pedirSelecaoReaisAoUsuario(this.valor);

                    if(troco.compareTo(BigDecimal.ZERO) > 0){
                        Cupom novoCupom = new Cupom(troco);
                        this.cupons.add(novoCupom);
                        gravarJSON();
                    }
                    return true;

                } else {
                    System.out.println("Pagamento aceito!");
                    return true;
                }
            }else if(MetodoDePagamento == 2){
                CafeScanner confirmarPagamentoCartaoDeDebito = new CafeScanner("Digite 1 para cartão inserido", "1");
                confirmarPagamentoCartaoDeDebito.pedirConfirmacaoUsuario();
                System.out.println("Transação aprovada");
                return true;
            }else if(MetodoDePagamento == 3) {
                //Cupom.lerJSON();
                CafeScanner procurarCupom = new CafeScanner("Favor digitar o código do cupom.");
                Cupom cupom = procurarCupom.pedirCodigoCupom(this);
                if(cupom.getAtivo()) {
                    if (cupom.checaValidade()) {
                        cupom.inativarCupom();
                        BigDecimal troco = this.valor.subtract(cupom.getValor());
                        if (troco.compareTo(BigDecimal.ZERO) < 0) {
                            troco = cupom.getValor().subtract(this.valor);
                            Cupom novoCupom = new Cupom(troco);
                            this.cupons.add(novoCupom);
                            gravarJSON();
                            return true;
                        } else if (troco.compareTo(BigDecimal.ZERO) == 0) {
                            System.out.println("Cupom aceito com sucesso!");
                            gravarJSON();
                            return true;
                        } else {
                            System.out.println("Cupom aceito com sucesso. Faltam " + moedaEmReais(troco) + ".");
                            this.valor = troco;
                            gravarJSON();
                        }
                    } else {
                        System.out.println("Cupom expirado! Favor escolher utilizar outro cupom ou escolher outro método de pagamento.");
                        gravarJSON();
                    }
                } else {
                    gravarJSON();
                    System.out.println("Cupom expirado! Utilize um código ativo e dentro da validade, ou outro método de pagamento.");
                    System.out.println("Caso tenha tentado utilizar o cupom com troco de outro cupom, verifique se foi gerado um novo código.");
                }
            }
            return false;
        }

    public BigDecimal calcularQuantidadeDeDinheiro(BigDecimal valor, NotasEMoedas Real, BigDecimal contagem, boolean SegundaSugestao){
        int quantidadeDeREAL;
        Real.setQuantidade(0);

        if(SegundaSugestao && !this.encontrouMaiorValor){
            quantidadeDeREAL = valor.divide(Real.getValor()).intValue();
            if (quantidadeDeREAL >= 1){
                this.encontrouMaiorValor = true;
            }
        } else {
            quantidadeDeREAL = valor.subtract(contagem).divide(Real.getValor()).intValue();
            Real.setQuantidade(quantidadeDeREAL);

            return BigDecimal.valueOf(quantidadeDeREAL).multiply(Real.getValor());
        }

        return BigDecimal.ZERO;
    }

    private void imprimirSugestoesDePagamentoEmDinheiro(){
        System.out.println("A melhor opção para pagamento em dinheiro é");
        System.out.println("Sugestão 1 - " + sugestaoPagamentoEmDinheiro(false));
        System.out.println("Sugestão 2 - " + sugestaoPagamentoEmDinheiro(true));
    }

    private String sugestaoPagamentoEmDinheiro(Boolean SegundaSugestao){
        BigDecimal contagemPrecoEmNotas = BigDecimal.ZERO;
        BigDecimal contagemPrecoEmMoedas = BigDecimal.ZERO;
        this.encontrouMaiorValor = false;
        String SugestaoDeNotasEMoedas = "";

        Integer precoInteger = this.valor.intValue();
        BigDecimal precoMoedas = this.valor.subtract(BigDecimal.valueOf(precoInteger));

        NotasEMoedas Real[] = NotasEMoedas.values();

        for (NotasEMoedas real : Real) {
            boolean IsMoeda = (real.isMoeda() && real.getId() != 8); //ID da moeda de um real

            if(IsMoeda) {
                contagemPrecoEmMoedas = contagemPrecoEmMoedas.add(calcularQuantidadeDeDinheiro(precoMoedas, real, contagemPrecoEmMoedas, SegundaSugestao));
            }else{
                contagemPrecoEmNotas = contagemPrecoEmNotas.add(calcularQuantidadeDeDinheiro(this.valor, real, contagemPrecoEmNotas, SegundaSugestao));
            }
        }

        if (SegundaSugestao){
            System.out.println("-- ou --");
        }

        BigDecimal contagem = BigDecimal.ZERO;
        for (NotasEMoedas real : Real) {
            if (!String.valueOf(real.getQuantidade()).equals("0")){
                SugestaoDeNotasEMoedas += real.getQuantidade() + " unid. de " + real.toString() + ", ";
                contagem = contagem.add(real.getValor().multiply(BigDecimal.valueOf(real.getQuantidade())));
                if(contagem.compareTo(this.valor) == 0){ break;}
            }
        }

        SugestaoDeNotasEMoedas = SugestaoDeNotasEMoedas.substring(0, (SugestaoDeNotasEMoedas.length() - 2));
        return SugestaoDeNotasEMoedas;
    }

}
