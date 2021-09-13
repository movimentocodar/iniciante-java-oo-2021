
public class Capuccino extends Bebida{
	
	private double preco = 1.5;
	
	public Capuccino(int numeroDaOpcao) {
		super(numeroDaOpcao);
	}
	
	public void prepararCapuccino(Bebida agua){
		if(agua.confereNivelDeAgua(agua)) {
			agua.abastecerAgua(agua);
    	}
		int nivelAcucar = super.solicitarNivelAcucar();
		System.out.println("Adicionando: café em pó + leite em pó + chocolate em pó + filtro + nível de "
				+ "açúcar de: " + nivelAcucar);
		System.out.println("Capuccino pronto.");
	}

	public double getPreco() {
		return preco;
	}
	
}
