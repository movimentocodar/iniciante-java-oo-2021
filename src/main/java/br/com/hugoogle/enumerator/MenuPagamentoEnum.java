package enumerator;

public enum MenuPagamentoEnum  {
    DINHEIRO(1, "Dinheiro"),
    DEBITO(2, "Debito"),
    SAIR(3, "Sair");

    private final String tipoPagamento;
    private final int codigoMenuPagamentoKey;

    MenuPagamentoEnum(int codigoMenuKey, String tipoPagamento) {
        this.codigoMenuPagamentoKey = codigoMenuKey;
        this.tipoPagamento = tipoPagamento;
    }

    public String getTipoPagamento() {
        return this.tipoPagamento;
    }

    public int getCodigoMenuPagamentoKey() {
        return this.codigoMenuPagamentoKey;
    }

}