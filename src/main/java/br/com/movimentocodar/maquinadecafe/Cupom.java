package br.com.movimentocodar.maquinadecafe;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cupom {
    BigDecimal valor;
    LocalDateTime validade;
    Timestamp agora;
    Boolean ativo;
    String codigo;

    public Cupom(BigDecimal valor, Timestamp agora, Boolean ativo) {
        this.valor = valor;
        this.ativo = ativo;
        this.agora = agora;
        gerarCodigo();
        calcularValidade();
    }

    private void gerarCodigo(){
        LocalDateTime dataString = this.agora.toLocalDateTime();
        long cupomNum = this.agora.getTime() * 3;
        this.codigo = dataString.getMonth().toString().substring(0, 3) + Integer.toString(dataString.getYear()).substring(2, 4) + "-" + Long.toString(cupomNum);
    }

    public void calcularValidade() {
        LocalDateTime dataValidade = this.agora.toLocalDateTime();
        this.validade = dataValidade.plusMonths(3);
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
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.validade.format(formatoData);
    }

    public boolean checaValidade(){
        if (LocalDate.now().compareTo(this.validade.toLocalDate()) < 1){
            return true;
        }
        return false;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

}
