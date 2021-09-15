package cafes;
import java.util.ArrayList;

public class NotasEMoedas {
    private int id;
    private String Nome;
    private double Valor;
    private boolean isMoeda;
    private int Quantidade;
    private static ArrayList<NotasEMoedas> ListaDeReais = new ArrayList<NotasEMoedas>();

    public NotasEMoedas(int id, String Nome, double Valor, boolean isMoeda) {
        this.id = id;
        this.Nome = Nome;
        this.Valor = Valor;
        this.isMoeda = isMoeda;
        ListaDeReais.add(this);
    }

    public NotasEMoedas(){
        NotasEMoedas NotaDe200 = new NotasEMoedas(0,"Nota de R$200", 200.00,false);
        NotasEMoedas NotaDe100 = new NotasEMoedas(1,"Nota de R$100", 100.00,false);
        NotasEMoedas NotaDe50 = new NotasEMoedas(2,"Nota de R$50", 50.00,false);
        NotasEMoedas NotaDe20 = new NotasEMoedas(3,"Nota de R$20", 20.00,false);
        NotasEMoedas NotaDe10 = new NotasEMoedas(4,"Nota de R$10", 10.00,false);
        NotasEMoedas NotaDe5 = new NotasEMoedas(5,"Nota de R$5", 5.00,false);
        NotasEMoedas NotaDe2 = new NotasEMoedas(6,"Nota de R$2", 2.00,false);
        NotasEMoedas NotaDe1 = new NotasEMoedas(8,"Nota de R$1", 1.00,false);
        NotasEMoedas MoedaDe1 = new NotasEMoedas(7,"Moeda de R$1", 1.00,true);
        NotasEMoedas MoedaDe50 = new NotasEMoedas(8,"Moeda de R$0,50", 0.50,true);
        NotasEMoedas MoedaDe25 = new NotasEMoedas(9,"Moeda de R$0,25", 0.25,true);
        NotasEMoedas MoedaDe10 = new NotasEMoedas(10,"Moeda de R$0,10", 0.10,true);
        NotasEMoedas MoedaDe5= new NotasEMoedas(11,"Moeda de R$0,05", 0.05,true);
        NotasEMoedas MoedaDe001= new NotasEMoedas(12,"Moeda de R$0,01", 0.01,true);
    }

    public static ArrayList<NotasEMoedas> getListaDeReais(){
        return ListaDeReais;
    }

    public double getValor() {
        return Valor;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public boolean isMoeda() {
        return isMoeda;
    }

    public String getNome() {
        return Nome;
    }

    public int getId() {
        return id;
    }
}

