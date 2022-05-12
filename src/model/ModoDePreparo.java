package model;

public class ModoDePreparo {

    private final String modo;

    private final String descricao;

    public ModoDePreparo(String descricao, String modo) {
        this.descricao = descricao;
        this.modo = modo;
    }

    public String getModo() {
        return modo;
    }

    public String getDescricao() {
        return descricao;
    }
}
