import br.com.movimentocodar.maquinadecafe.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class MaquinaDeCafeTest {
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Test
    public void deveriaLiberarCafeComAcucarNivel1() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strBebida = "0";
        final String nivelAcucar = "1";

        Bebida cafe = new Cafe();
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        systemInMock.provideLines(strBebida);
        Assert.assertEquals(maquinaDeCafe.selecionarBebida().getId(), cafe.getId());
        systemInMock.provideLines(nivelAcucar);
        Assert.assertEquals(maquinaDeCafe.determinarNivelDeAcucar(), Acucar.NIVEL_1);
        maquinaDeCafe.liberarBebida();
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Retire a bebida e obrigado por utilizar a máquina de café."));
    }

    @Test
    public void deveriaLiberarCafeComAcucarIndefinido() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strBebida = "0";

        Bebida cafe = new Cafe();
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        systemInMock.provideLines(strBebida);
        Assert.assertEquals(maquinaDeCafe.selecionarBebida().getId(), cafe.getId());
        maquinaDeCafe.liberarBebida();
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Retire a bebida e obrigado por utilizar a máquina de café."));
    }

    @Test
    public void deveriaLiberarCafeComLeiteComAcucarNivel3() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strBebida = "1";
        final String nivelAcucar = "3";

        Bebida cafeComLeite = new CafeComLeite();
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        systemInMock.provideLines(strBebida);
        Assert.assertEquals(maquinaDeCafe.selecionarBebida().getId(), cafeComLeite.getId());
        systemInMock.provideLines(nivelAcucar);
        Assert.assertEquals(maquinaDeCafe.determinarNivelDeAcucar(), Acucar.NIVEL_3);
        maquinaDeCafe.liberarBebida();
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Retire a bebida e obrigado por utilizar a máquina de café."));
    }

    @Test
    public void deveriaLiberarChaDeLimaoComAcucarNivel5() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strBebida = "3";
        final String nivelAcucar = "5";

        Bebida cha = new ChaDeLimao();
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        systemInMock.provideLines(strBebida);
        Assert.assertEquals(maquinaDeCafe.selecionarBebida().getId(), cha.getId());
        systemInMock.provideLines(nivelAcucar);
        Assert.assertEquals(maquinaDeCafe.determinarNivelDeAcucar(), Acucar.NIVEL_5);
        maquinaDeCafe.liberarBebida();
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Retire a bebida e obrigado por utilizar a máquina de café."));
    }

    @Test
    public void deveriaLiberarAguaQuenteEIgnorarAcucar() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strBebida = "4";
        final String nivelAcucar = "2";

        Bebida aguaQuente = new AguaQuente();
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        systemInMock.provideLines(strBebida);
        Assert.assertEquals(maquinaDeCafe.selecionarBebida().getId(), aguaQuente.getId());
        systemInMock.provideLines(nivelAcucar);
        Assert.assertEquals(maquinaDeCafe.determinarNivelDeAcucar(), Acucar.NIVEL_2);
        maquinaDeCafe.liberarBebida();
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Retire a bebida e obrigado por utilizar a máquina de café."));
    }

    @Test
    public void determinarAcucarNivel0() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String nivelAcucar = "0";

        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        systemInMock.provideLines(nivelAcucar);
        Assert.assertEquals(maquinaDeCafe.determinarNivelDeAcucar(), Acucar.NIVEL_0);
    }

    @Test
    public void determinarAcucarNivel2() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String nivelAcucar = "2";

        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        systemInMock.provideLines(nivelAcucar);
        Assert.assertEquals(maquinaDeCafe.determinarNivelDeAcucar(), Acucar.NIVEL_2);
    }

    @Test
    public void determinarAcucarNivel4() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String nivelAcucar = "4";

        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        systemInMock.provideLines(nivelAcucar);
        Assert.assertEquals(maquinaDeCafe.determinarNivelDeAcucar(), Acucar.NIVEL_4);
    }

    @Test
    public void deveriaLiberarCapuccinoEAcucarNaoDefinido() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strBebida = "2";

        Bebida capuccino = new Cappuccino();
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        systemInMock.provideLines(strBebida);
        Assert.assertEquals(maquinaDeCafe.selecionarBebida().getId(), capuccino.getId());
        maquinaDeCafe.liberarBebida();
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("Retire a bebida e obrigado por utilizar a máquina de café."));
    }

    @Test
    public void deveriaRetornarMenu() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        maquinaDeCafe.menu();
        Assert.assertTrue(outputStreamCaptor.toString().trim().contains("0 - Café"));
    }


    @Test(expected = NoSuchElementException.class)
    public void deveriaLiberarFinalizarPrograma() {
        final String strBebida = "testandobebidaquenãoexiste";

        Bebida bebida = new Bebida();
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        systemInMock.provideLines(strBebida);

        Assert.assertEquals(maquinaDeCafe.selecionarBebida().getId(), bebida.getId());
    }
}
