package enumerator;

public enum MenuPrincipalEnum {
    COMPRAR(1, "Comprar"),
    ABASTECER(2, "Abastecer"),
    SAIR(3, "Sair");

    private final String descricao;
    private final int codigoMenuKey;

    MenuPrincipalEnum(int codigoMenuKey, String descricao) {
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