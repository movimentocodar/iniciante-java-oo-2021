package command;

import br.com.hugoogle.Validacao.ValidarEstoque;
import br.com.hugoogle.bebidas.Cafe;
import br.com.hugoogle.command.EstoqueCommand;
import br.com.hugoogle.menu.fabrica.Bebida;
import br.com.hugoogle.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;


class EstoqueCommandTest {


    private Bebida bebida;
    private Map<Produto, List<Double>> produtoEQuantidade;
    @InjectMocks
    private EstoqueCommand estoqueCommand;
    @Mock
    private ValidarEstoque validarEstoque;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void dadoUmaBebidaEUmListaDeProdutosQueCompoeIngredientesQuandoCalcularAQuantidadeEmEstoqueVerifiqueSeFoiCalculado() {
        dadoUmaBebida();
        eUmaListaDeProdutoQueCompoeOIngredientes();
        quandoCalcularAQuantidadeEmEstoque();
        verifiqueSeFoiCalculado();
    }

    private void dadoUmaBebida() {
         this.bebida = new Cafe();

    }

    private void eUmaListaDeProdutoQueCompoeOIngredientes() {
       this.produtoEQuantidade = listaListMap();
    }

    private void quandoCalcularAQuantidadeEmEstoque() {
        this.estoqueCommand = new EstoqueCommand(bebida, produtoEQuantidade, validarEstoque);
        estoqueCommand.execute();
    }

    private void verifiqueSeFoiCalculado() {
        verify(validarEstoque, times(1)).calcular(bebida, produtoEQuantidade);

    }

    @Test
    public void dadoUmaBebidaEUmaListaDeProdutoQUeCompoeOIgredientesQuandoExecutarOCalculoVerifiqueSeFoiExecutado() {
        dadoUmaBebida();
        eUmaListaDeProdutoQueCompoeOIngredientes();
        quandoExecutarOCalculo();
        verifiqueSeFoiExecutado();
    }

private void quandoExecutarOCalculo(){
    estoqueCommand =  spy(new EstoqueCommand(bebida, produtoEQuantidade, validarEstoque));
    estoqueCommand.execute();
}

private void verifiqueSeFoiExecutado(){
    verify(estoqueCommand, times(1)).execute();
}

    private Map<Produto, List<Double>> listaListMap() {
        Map<Produto, List<Double>> produtoListMap = new HashMap<>();
        List<Double> list = new ArrayList<>();
        list.add(1000.00);
        list.add(120.00);
        Produto produto = new Produto(1, "Cafe", 100, 10, "un");
        produtoListMap.put(produto, list);


        return produtoListMap;


    }

}