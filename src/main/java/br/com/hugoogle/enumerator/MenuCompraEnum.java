package br.com.hugoogle.enumerator;

public enum  MenuCompraEnum {
    CAFE(1, "Cafe"),
    CAFECOMLEITE(2, "Cafe com Leite"),
    CAPUCCINO(3, "Capuccino"),
    CHA(4, "Cha de Limao"),
    AGUAQUENTE(5, "Agua Quente");

    private final String descricao;
    private final int codigoMenuKey;

    MenuCompraEnum(int codigoMenuKey, String descricao) {
        this.descricao = descricao;
        this.codigoMenuKey = codigoMenuKey;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public int getCodigoMenuKey() {
        return this.codigoMenuKey;
    }

}