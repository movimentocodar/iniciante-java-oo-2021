package cafes;

public class ReservatorioDeAgua {
    private int QuantidadeDeAguaNoReservatorio = 1000;

    public int getQuantidadeDeAguaNoReservatorio() {
        return QuantidadeDeAguaNoReservatorio;
    }

    public void atualizarNiveisDeAgua(int quantidadeDeAguaUtilizada) {
        QuantidadeDeAguaNoReservatorio = QuantidadeDeAguaNoReservatorio - quantidadeDeAguaUtilizada;
    }

    public void reporQuantidadeDeAguaNoReservatorio() {
        QuantidadeDeAguaNoReservatorio = 1000;
    }
}
