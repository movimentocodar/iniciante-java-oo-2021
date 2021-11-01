package br.com.movimentocodar.maquinadecafe;

public enum Acucar {
    NIVEL_0(0,"nenhuma"),
    NIVEL_1(1,"pouquíssima"),
    NIVEL_2(2,"pouca"),
    NIVEL_3(3,"quantidade normal de"),
    NIVEL_4(4,"muita"),
    NIVEL_5(5,"bastante");

    private int id;
    private String descricao;

    private Acucar(int id, String descricao){
        this.descricao = descricao;
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public void imprimirNiveisDeAcucar(){
        System.out.println(this.id + " - " + this.descricao);
    }

}
