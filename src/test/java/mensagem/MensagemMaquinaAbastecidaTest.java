package mensagem;

import br.com.hugoogle.mensagem.MensagemMaquinaAbastecida;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

class MensagemMaquinaAbastecidaTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @InjectMocks
    MensagemMaquinaAbastecida mensagemMaquinaAbastecida;

    @Captor
    private ArgumentCaptor<Boolean> abastecidaCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mensagemMaquinaAbastecida = new MensagemMaquinaAbastecida();
        this.mensagemMaquinaAbastecida = Mockito.spy(mensagemMaquinaAbastecida);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void DadoUmaMaquinaAbastecidaVerifiqueSeDeveAbastecerDeveInfomarQueAMaquinaSeEncontraAbastecida() {
        dadoUmaMaquinaAbastecida();
        verifiqueSeAMaquinaEstaAbastecida();
        entaoExibiAMensagemMaquinaSeEncontraAbastecida();
    }

    @Test
    public void DadoUmaMaquinaDesabastecidaVerifiqueSeEncontraDesabastecidaEDeveInfomarOsProdutosParaAbastecer() {
        dadoUmaMaquinaDesabastecida();
        verifiqueSeAMaquinaEstaDesabastecida();
        entaoExibiAMensagemMaquinaSeEncontraDesabastecida();
    }


    private void dadoUmaMaquinaAbastecida(){
        this.mensagemMaquinaAbastecida.maquinaAbastecida(true);
    }
    private void dadoUmaMaquinaDesabastecida(){
        this.mensagemMaquinaAbastecida.maquinaAbastecida(false);
    }
    public void verifiqueSeAMaquinaEstaAbastecida() {
        verify(this.mensagemMaquinaAbastecida, times(1)).maquinaAbastecida(true);
        verify(this.mensagemMaquinaAbastecida).maquinaAbastecida(abastecidaCaptor.capture());
    }

    public void verifiqueSeAMaquinaEstaDesabastecida() {
        verify(this.mensagemMaquinaAbastecida, times(1)).maquinaAbastecida(false);
        verify(this.mensagemMaquinaAbastecida).maquinaAbastecida(abastecidaCaptor.capture());
    }

    private void entaoExibiAMensagemMaquinaSeEncontraAbastecida(){
        String mensagem = "*** Maquina se encontra abastecida!  ***";
        String outputCaptor = outputStreamCaptor.toString().replace("[32m", "" ).replace("\u001B[0m", "").trim();
        Assertions.assertEquals(mensagem, outputCaptor);
    }

    private void entaoExibiAMensagemMaquinaSeEncontraDesabastecida(){
        String mensagem = "*** Maquina se encontra desabastecida!  ***";
        String outputCaptor = outputStreamCaptor.toString().replace("[32m", "" ).replace("\u001B[0m", "").trim();
        Assertions.assertEquals(mensagem, outputCaptor);
    }


}