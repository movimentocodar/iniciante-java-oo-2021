package br.com.movimentocodar.maquinadecafe;

public class ReservatorioDeAgua {
    private int quantidadeDeAgua;

    public ReservatorioDeAgua() {
        this.quantidadeDeAgua = 1000;
    }

    public boolean reservatorioDeAguaVazio(){
        String msgReservatorioDeAgua = this.quantidadeDeAgua >= 50? "suficiente para " + (this.quantidadeDeAgua / 50) + " bebidas." : "vazios.";
        System.out.println("Reservatórios de água " + msgReservatorioDeAgua);

        if(this.quantidadeDeAgua >= 50){
            return false;
        }

        return true;
    }

    public void completarReservatorioDeAgua(){
        this.quantidadeDeAgua = 1000;
        String msgReservatorioDeAgua = "suficiente para " + (this.quantidadeDeAgua / 50) + " bebidas.";
        System.out.println("Reservatório de água completo, " + msgReservatorioDeAgua);
    }

    public void liberarAguaParaUmaBebida() throws Exception {
        if(this.quantidadeDeAgua >= 50){
            this.quantidadeDeAgua -= 50;
        }else {
            System.out.println("Quantidade de água abaixo do esperado");
            throw new Exception();
        }
    }
}
