package cafes;
import java.util.ArrayList;

public enum Acucar {
    Nivel0("nenhuma"),Nivel1("pouquíssima"),Nivel2("pouca"),Nivel3("quantidade normal de"),Nivel4("muita"),Nivel5("bastante");

    private String quantidadeDeAcucar;

    private Acucar(String quantidade){
        this.quantidadeDeAcucar = quantidade;
    }

    public String getQuantidadeDeAcucar() {
        return this.quantidadeDeAcucar;
    }

    public static ArrayList<Acucar> getNiveisDeAcucar(){
        ArrayList<Acucar> Niveis = new ArrayList<Acucar>();

        Niveis.add(Nivel0);
        Niveis.add(Nivel1);
        Niveis.add(Nivel2);
        Niveis.add(Nivel3);
        Niveis.add(Nivel4);
        Niveis.add(Nivel5);

        return Niveis;
    }
}
