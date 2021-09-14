package cafes;

public enum Acucar {
    Nivel0("nenhuma"),Nivel1("pouquíssima"),Nivel2("pouca"),Nivel3("normal"),Nivel4("muito"),Nivel5("bastante");

    private String quantidadeDeAcucar;

    private Acucar(String quantidade){
        this.quantidadeDeAcucar = quantidade;
    }

    public String getQuantidadeDeAcucar() {
        return this.quantidadeDeAcucar;
    }
}
