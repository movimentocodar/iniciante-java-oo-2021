import br.com.movimentocodar.maquinadecafe.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class PagamentoTest {
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Test
    public void deveriaRetornarCortesia() {
        Bebida aguaQuente = new AguaQuente();
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        Assert.assertEquals(maquinaDeCafe.selecionarBebida().getId(), aguaQuente.getId());
        Pagamento pagamento = new Pagamento(aguaQuente.getPreco());

        Assert.assertTrue(pagamento.cortesia());
    }

    @Test
    public void naoDeveriaRetornarCortesia() {
        Bebida cafe = new Cafe();
        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);

        Assert.assertEquals(maquinaDeCafe.selecionarBebida().getId(), cafe.getId());
        Pagamento pagamento = new Pagamento(cafe.getPreco());

        Assert.assertFalse(pagamento.cortesia());
    }


    @Test
    public void deveriaPagarComDinheiroAceitandoSugestao1() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strChaDeLimao = "3";
        final String pgtoDinheiro = "1";
        final String aceitarSugestaoDinheiro1 = "1";

        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);
        Cupons cupons = new Cupons();

        systemInMock.provideLines(strChaDeLimao);
        Pagamento pagamento = new Pagamento(maquinaDeCafe.selecionarBebida().getPreco());

        systemInMock.provideLines(pgtoDinheiro, aceitarSugestaoDinheiro1);
        Assert.assertTrue(pagamento.executarCobranca(cupons));
    }

    @Test
    public void deveriaPagarComDinheiroAceitandoSugestao2() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strCafe = "0";
        final String pgtoDinheiro = "1";
        final String aceitarSugestaoDinheiro2 = "2";

        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);
        Cupons cupons = new Cupons();

        systemInMock.provideLines(strCafe);
        Pagamento pagamento = new Pagamento(maquinaDeCafe.selecionarBebida().getPreco());

        systemInMock.provideLines(pgtoDinheiro, aceitarSugestaoDinheiro2);
        Assert.assertTrue(pagamento.executarCobranca(cupons));
    }


    @Test
    public void deveriaPagarComDinheiroEscolherReaisEUsarCupomAteAcabar() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strCafe = "0";
        final String strCapuccino = "2";
        final String strChaDeLimao = "3";
        final String pgtoDinheiro = "1";
        final String pgtoCupom= "3";
        final String escolherQualquerNotaouMoeda = "3";
        final String IDdaNotaDe5 = "5";
        final String IDdaMoedaDe1 = "8";

        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);
        Cupons cupons = new Cupons();

        systemInMock.provideLines(strCafe);
        Pagamento pagamento = new Pagamento(maquinaDeCafe.selecionarBebida().getPreco());

        systemInMock.provideLines(pgtoDinheiro, escolherQualquerNotaouMoeda, IDdaNotaDe5);
        Assert.assertTrue(pagamento.executarCobranca(cupons));

        systemInMock.provideLines(strCapuccino);
        Pagamento pagamento2 = new Pagamento(maquinaDeCafe.selecionarBebida().getPreco());

        systemInMock.provideLines(pgtoCupom, cupons.encontrarUltimoCupom());
        Assert.assertTrue(pagamento2.executarCobranca(cupons));

        systemInMock.provideLines(strCapuccino);
        Pagamento pagamento3 = new Pagamento(maquinaDeCafe.selecionarBebida().getPreco());

        systemInMock.provideLines(pgtoCupom, cupons.encontrarUltimoCupom());
        Assert.assertTrue(pagamento3.executarCobranca(cupons));

        systemInMock.provideLines(strChaDeLimao);
        Pagamento pagamento4 = new Pagamento(maquinaDeCafe.selecionarBebida().getPreco());

        systemInMock.provideLines(pgtoCupom, cupons.encontrarUltimoCupom());
        Assert.assertTrue(pagamento4.executarCobranca(cupons));

        systemInMock.provideLines(strCapuccino);
        Pagamento pagamento5 = new Pagamento(maquinaDeCafe.selecionarBebida().getPreco());

        systemInMock.provideLines(pgtoCupom, cupons.encontrarUltimoCupom(), pgtoDinheiro, escolherQualquerNotaouMoeda, IDdaMoedaDe1);
        Assert.assertTrue(pagamento5.executarCobranca(cupons));

        Assert.assertFalse(cupons.encontrarCupom(cupons.encontrarUltimoCupom()).getAtivo());
    }

    @Test
    public void deveriaPagarComCartaoDeDebito() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strCafe = "0";
        final String pgtoCartaoDeDebito = "2";
        final String cartaoInserido= "1";

        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);
        Cupons cupons = new Cupons();

        systemInMock.provideLines(strCafe);
        Pagamento pagamento = new Pagamento(maquinaDeCafe.selecionarBebida().getPreco());

        systemInMock.provideLines(pgtoCartaoDeDebito, cartaoInserido);
        Assert.assertTrue(pagamento.executarCobranca(cupons));
    }

    @Test
    public void deveriaPagarComCupom() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final String strCafe = "0";
        final String pgtoCupom= "3";

        ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe(reservatorioDeAgua);
        Cupons cupons = new Cupons();

        BigDecimal valor = BigDecimal.valueOf(2.00);
        Cupom novoCupom = new Cupom(valor);
        cupons.addNovoCupom(novoCupom);

        systemInMock.provideLines(strCafe);
        Pagamento pagamento = new Pagamento(maquinaDeCafe.selecionarBebida().getPreco());

        systemInMock.provideLines(pgtoCupom, cupons.encontrarUltimoCupom());
        Assert.assertTrue(pagamento.executarCobranca(cupons));

        Assert.assertTrue(cupons.encontrarCupom(cupons.encontrarUltimoCupom()).getAtivo());
    }
}
