package controller;

import br.com.hugoogle.controller.AbastecimentoController;
import br.com.hugoogle.mensagem.MensagemMaquinaAbastecida;
import br.com.hugoogle.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AbastecimentoControllerTest {

    @Spy
    AbastecimentoController abastecimentoController;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    MensagemMaquinaAbastecida mensagemMaquinaAbastecida;

    private Map<Produto, List<Double>> listaDeProdutosParaAbastecer;

    private ArgumentCaptor<Map<Produto, List<Double>>> valueCapture;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));
        this.mensagemMaquinaAbastecida = new MensagemMaquinaAbastecida();
        this.mensagemMaquinaAbastecida = Mockito.spy(mensagemMaquinaAbastecida);
    }

    @Test
    public void dadoUmaListaDeProdutosParaAbastecerquandoAbastecerAMaquinaDeCafeverifiqueSeFoiAbastecidoEValideAListaDeProdutosEExibeMensagemDoProdutoAbastecido() {
        dadoUmaListaDeProdutosParaAbastecer();
        quandoAbastecerAMaquinaDeCafe();
        verifiqueSeFoiAbastecido();
        valideAListaDeProdutos();
        eExibeMensagemDoProdutoAbastecido();

    }

    private void dadoUmaListaDeProdutosParaAbastecer(){
        this.listaDeProdutosParaAbastecer = listaDeProdutosParaAbastecer();
    }

    private void quandoAbastecerAMaquinaDeCafe(){
        this.valueCapture = ArgumentCaptor.forClass(Map.class) ;
        doCallRealMethod().when(abastecimentoController).abastecer(valueCapture.capture());
        abastecimentoController.abastecer(listaDeProdutosParaAbastecer);
    }

    private void verifiqueSeFoiAbastecido(){
        verify(abastecimentoController, times(1)).abastecer(valueCapture.capture());
    }

    private void valideAListaDeProdutos (){
        assertEquals(listaDeProdutosParaAbastecer, valueCapture.getValue());
    }

    private void eExibeMensagemDoProdutoAbastecido(){
        String outputCaptor = outputStreamCaptor.toString().replace("[32m", "" ).replace("\u001B[0m", "").replace("\u001B[31m", "").trim();
        String msgMaquinaDesabastecida = outputCaptor.substring(0,43).trim();
        String msgItemReabastecido = outputCaptor.substring(47,73);
        String produto = outputCaptor.substring(75,80).trim();
        String qtaAtualizada = outputCaptor.trim().substring(81,122);
        String msgMaquinaAbastecida = outputCaptor.substring(125,165);

        assertEquals("*** Maquina se encontra desabastecida!  ***", msgMaquinaDesabastecida);
        assertEquals("*** Item reabastecido  ***", msgItemReabastecido);
        assertEquals("Cafe", produto);
        assertEquals("Quantidade atualizada: de 100.0 para 10.0", qtaAtualizada);
        assertEquals("*** Maquina se encontra abastecida!  ***", msgMaquinaAbastecida);

    }

    private Map<Produto, List<Double>> listaDeProdutosParaAbastecer() {
        Map<Produto, List<Double>> produtoListMap = new HashMap<>();
        List<Double> list = new ArrayList<>();
        list.add(1000.00);
        list.add(120.00);
        Produto produto = new Produto(1, "Cafe", 100, 10, "un");
        produtoListMap.put(produto, list);
        return produtoListMap;
    }
}