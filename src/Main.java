import classes.EscolhaPedido;
import classes.abstracts.SistemaInterno;
import classes.abstracts.SistemaPagamento;

public class Main extends SistemaInterno {
	
	
	public static void main(String[] args) {				
		
		while(true) {
			new EscolhaPedido().escolha();
			SistemaPagamento.resetVerificacaoSaldo();
		}
	}
}
