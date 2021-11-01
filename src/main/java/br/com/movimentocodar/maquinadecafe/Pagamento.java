package br.com.movimentocodar.maquinadecafe;

import com.fasterxml.jackson.core.JsonParseException;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

public class Pagamento {
    private BigDecimal valor;
    private boolean encontrouMaiorValor = false;
    private int metodoDePagamento;

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

    public boolean executarCobranca(int MetodoDePagamento, Cupons cupons) throws JsonParseException, IOException {
        this.metodoDePagamento = MetodoDePagamento;
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
                        //cupons.lerJSON();
                        gerarCupom(troco, cupons);
                        cupons.gravarJSON();
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
                //cupons.lerJSON();
                CafeScanner procurarCupom = new CafeScanner("Favor digitar o código do cupom.");
                Cupom cupom = procurarCupom.pedirCodigoCupom(cupons);
                if(cupom.getAtivo()) {
                    if (cupom.checaValidade()) {
                        cupom.inativarCupom();
                        BigDecimal troco = this.valor.subtract(cupom.getValor());
                        if (troco.compareTo(BigDecimal.ZERO) < 0) {
                            troco = cupom.getValor().subtract(this.valor);
                            gerarCupom(troco, cupons);
                            cupons.gravarJSON();
                            return true;
                        } else if (troco.compareTo(BigDecimal.ZERO) == 0) {
                            System.out.println("Cupom aceito com sucesso!");
                            cupons.gravarJSON();
                            return true;
                        } else {
                            System.out.println("Cupom aceito com sucesso. Faltam " + moedaEmReais(troco) + ".");
                            this.valor = troco;
                            cupons.gravarJSON();
                        }
                    } else {
                        System.out.println("Cupom expirado! Favor escolher utilizar outro cupom ou escolher outro método de pagamento.");
                        cupons.gravarJSON();
                    }
                } else {
                    cupons.gravarJSON();
                    System.out.println("Cupom expirado! Utilize um código ativo e dentro da validade, ou outro método de pagamento.");
                    System.out.println("Caso tenha tentado utilizar o cupom com troco de outro cupom, verifique se foi gerado um novo código.");
                }
            }
            return false;
        }

    private void gerarCupom(BigDecimal troco, Cupons cupons) {
        Timestamp agora = new Timestamp(System.currentTimeMillis());
        Cupom novoCupom = new Cupom(troco, agora, true);
        cupons.addCupom(novoCupom.getCodigo(), novoCupom);

        System.out.println("O valor excedente é de " + moedaEmReais(troco) + ".");
        System.out.println("ATENÇÃO: anote o código do cupom no valor de " + moedaEmReais(troco) + ": " + novoCupom.getCodigo());
        System.out.println("Válido apenas para compras na Máquina de Café até " + novoCupom.getValidade());
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
