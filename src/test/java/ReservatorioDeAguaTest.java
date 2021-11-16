import br.com.movimentocodar.maquinadecafe.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ReservatorioDeAguaTest {

    @Test(expected = Exception.class)
    public void deveriaRetornarReservatorioDeAguaVazio() throws Exception {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        for(int i = 0; i<21; i++){
            reservatorioDeAgua.liberarAguaParaUmaBebida();
        }
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Quantidade de água abaixo do esperado"));
    }

    @Test
    public void deveriaCompletarReservatorioDeAgua() throws Exception {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        for(int i = 0; i<20; i++){
            reservatorioDeAgua.liberarAguaParaUmaBebida();
        }
        reservatorioDeAgua.completarReservatorioDeAgua();
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Reservatório de água completo"));

        reservatorioDeAgua.liberarAguaParaUmaBebida();
    }

    @Test
    public void deveriaLiberarAguaParaUmaBebida() throws Exception {
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        reservatorioDeAgua.liberarAguaParaUmaBebida();
    }
}
