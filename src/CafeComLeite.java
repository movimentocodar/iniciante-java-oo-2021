
public class CafeComLeite extends Bebida{
	
	double preco = 1.0;
	
	public CafeComLeite(int numeroDaOpcao) {
		super(numeroDaOpcao);
	}
	
	public void prepararCafeComLeite(Bebida agua) {
		if(agua.confereNivelDeAgua(agua)) {
    		agua.abastecerAgua(agua);
    	}
		int nivelAcucar = super.solicitarNivelAcucar();
		System.out.println("Adicionando: café em pó + leite em pó + filtro + nível de açúcar de: " 
				+ nivelAcucar);
		System.out.println("Café com leite pronto.");
	}

	public double getPreco() {
		return preco;
	}

}
