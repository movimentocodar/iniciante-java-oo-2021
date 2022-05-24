package service;

import br.com.hugoogle.mensagem.MensagemMaquinaAbastecida;
import br.com.hugoogle.model.Produto;
import br.com.hugoogle.service.AbastecimentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbastecimentoServiceTest {


    @InjectMocks
    private AbastecimentoService abastecimentoService;

    @Mock
    private MensagemMaquinaAbastecida mensagemMaquinaAbastecida;

    @Captor
    private ArgumentCaptor<Boolean> abastecidaCaptor;


    private Map<Produto, List<Double>> produtoListMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void DadoUmaListaDeProdutoSemQuantidadeQuandoAbastecerDeveVerificarSeAMaquinaEstaDesabastecidaEAQuantidadeDeveSerAtualizadaPara1000() {
        dadoUmaListaDeProdutoSemQuantidade();
        quandoAbastecer();
        DeveVerificarSeAMaquinaEstaDesabastecida();
        eAQuantidadeDeveSer1000();
    }

    @Test
    void DadoUmaListaDeProdutoComQuantidadeIgualQuantidadeMaximaQuandoAbastecerAQuantidadeNaoDeveSerAtualizada() {
        dadoUmaListaDeProdutoComQuantidadeIgualAQuantidadeMaxima();
        quandoAbastecer();
        DeveVerificarSeAMaquinaEstaAbastecida();
        eAQuantidadeDeveSer1000();
    }


    public void DeveVerificarSeAMaquinaEstaDesabastecida() {
        Mockito.verify(mensagemMaquinaAbastecida, Mockito.times(3)).maquinaAbastecida(abastecidaCaptor.capture());
        Boolean abastecida = abastecidaCaptor.getValue();
        assertEquals(true, abastecida);

    }

    public void DeveVerificarSeAMaquinaEstaAbastecida() {
        Mockito.verify(mensagemMaquinaAbastecida).maquinaAbastecida(abastecidaCaptor.capture());
        Boolean abastecida = abastecidaCaptor.getValue();
        assertEquals(true, abastecida);

    }

    private void dadoUmaListaDeProdutoSemQuantidade(){
      produtoListMap = this.listMapProdutoEQuantidades();
    }

    private void dadoUmaListaDeProdutoComQuantidadeIgualAQuantidadeMaxima(){
        produtoListMap = this.listMapProdutoEQuantidades();
        produtoListMap.forEach((produto1, doubles) -> produto1.setQuantidade(1000));
    }

    private void quandoAbastecer(){
        abastecimentoService.abastecer(produtoListMap);
    }


    private void eAQuantidadeDeveSer1000(){
        List<Produto> produto = new ArrayList<>(produtoListMap.keySet());
        produto.sort(Comparator.comparingInt(Produto::getProdutoKey));
        assertEquals(1, produto.get(0).getProdutoKey());
        assertEquals("Po de Cafe", produto.get(0).getDescricao());
        assertEquals(1000, produto.get(0).getQuantidade());
        assertEquals(1000, produto.get(0).getQuantidadeMaxima());
        assertEquals("un", produto.get(0).getEmbalagem());

        assertEquals(2, produto.get(1).getProdutoKey());
        assertEquals("Filtro", produto.get(1).getDescricao());
        assertEquals(1000, produto.get(1).getQuantidade());
        assertEquals(1000, produto.get(1).getQuantidadeMaxima());
        assertEquals("un", produto.get(1).getEmbalagem());
    }


    private Map<Produto, List<Double>> listMapProdutoEQuantidades() {
        Map<Produto, List<Double>> produtoEQuantidade = new HashMap<>();
        List<Double> quantidade = new LinkedList<>();
        Produto agua = new Produto(1, "Po de Cafe", 0, 1000, "un");
        Produto poDeCafe = new Produto(2, "Filtro", 0, 1000, "un");
        quantidade.add(2.00);
        quantidade.add(3.00);
        produtoEQuantidade.put(agua, quantidade);
        produtoEQuantidade.put(poDeCafe, quantidade);
        return produtoEQuantidade;


    }

}