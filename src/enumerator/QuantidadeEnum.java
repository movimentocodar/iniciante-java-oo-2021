package enumerator;

public enum QuantidadeEnum {
    QUANTIDADETOTAL(0),
    QUANTIDADEPADRAO(1);

    private final int valor;

    QuantidadeEnum(int valor) {
        this.valor = valor;
    }

    public int getvalor() {
        return valor;
    }
}
