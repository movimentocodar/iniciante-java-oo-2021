package br.com.movimentocodar.maquinadecafe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.codec.binary.Base32;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cupom {
    BigDecimal valor;
    String validade;
    Boolean ativo;
    String codigo;

    Timestamp agora;

    @JsonCreator
    public Cupom(@JsonProperty("valor") BigDecimal valor,@JsonProperty("ativo") Boolean ativo,@JsonProperty("codigo") String codigo,@JsonProperty("validade") String validade) {
        this.valor = valor;
        this.ativo = ativo;
        this.codigo = codigo;
        this.validade = validade;
    }

    public Cupom(BigDecimal valor) {
        this.agora = new Timestamp(System.currentTimeMillis());
        this.valor = valor;
        this.ativo = true;
        gerarCodigo();
        calcularValidade();
        cupomCriado();
    }

    private void cupomCriado() {
        System.out.println("O valor excedente é de " + Pagamento.moedaEmReais(this.valor) + ".");
        System.out.println("ATENÇÃO: anote o código do cupom no valor de " + Pagamento.moedaEmReais(this.valor) + ": " + this.getCodigo());
        System.out.println("Válido apenas para compras na Máquina de Café até " + this.getValidade());
    }

    private void gerarCodigo(){
        LocalDateTime dataString = this.agora.toLocalDateTime();
        long cupomNum = this.agora.getTime() * 3;
        Base32 base32 = new Base32(-1,null,false);
        String cupomStr = base32.encodeAsString(BigInteger.valueOf(cupomNum).toByteArray());
        //cupomStr = DigestUtils.sha1Hex(cupomStr);
        this.codigo = dataString.getMonth().toString().substring(0, 3) + Integer.toString(dataString.getYear()).substring(2, 4) + "-" + cupomStr.substring(0,9);
    }

    public void calcularValidade() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime dataValidade = this.agora.toLocalDateTime();
        this.validade = dataValidade.plusMonths(3).format(formatoData);
    }

    public void inativarCupom(){
        this.ativo = false;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public String getValidade() {
        return this.validade;
    }

    public boolean checaValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = this.validade;
        LocalDate localDate = LocalDate.parse(date, formatter);
        if (LocalDate.now().compareTo(localDate) < 1){
            return true;
        }
        return false;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

}
