import br.com.movimentocodar.maquinadecafe.Cupom;
import br.com.movimentocodar.maquinadecafe.Cupons;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.math.BigDecimal;

public class CupomTest {
    @Test
    public void deveriaInativarCupom() throws IOException {
        Cupons cupons = new Cupons();

        BigDecimal valor = BigDecimal.valueOf(1.00);
        Cupom novoCupom = new Cupom(valor);
        cupons.addNovoCupom(novoCupom);
        cupons.encontrarCupom(cupons.encontrarUltimoCupom()).inativarCupom();

        Assert.assertFalse(cupons.encontrarCupom(cupons.encontrarUltimoCupom()).getAtivo());
    }

    @Test
    public void deveriaChecarValidade() throws IOException {
        Cupons cupons = new Cupons();

        BigDecimal valor = BigDecimal.valueOf(1.00);
        Cupom novoCupom = new Cupom(valor);
        cupons.addNovoCupom(novoCupom);

        Assert.assertTrue(cupons.encontrarCupom(cupons.encontrarUltimoCupom()).checaValidade());
    }

    @Test
    public void deveriaChecarValidadeVencido() {
        BigDecimal valor = BigDecimal.valueOf(1.00);

        final Cupom novoCupom = Mockito.mock(Cupom.class);
        novoCupom.setValor(valor);
        Mockito.when(novoCupom.calcularValidade()).thenReturn("07/11/2021");

        Assert.assertFalse(novoCupom.checaValidade());
    }
}
