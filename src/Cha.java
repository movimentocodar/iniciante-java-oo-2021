
public class Cha extends Bebida{
	
	private double preco = 1.0;
	
	public Cha(int numeroDaOpcao) {
		super(numeroDaOpcao);
	}
	
	public void prepararCha(Bebida agua) {
		if(agua.confereNivelDeAgua(agua)) {
			agua.abastecerAgua(agua);
		}
		int nivelAcucar = super.solicitarNivelAcucar();
		System.out.println("Adicionando: chá em pó + filtro + nível de açúcar de: " + nivelAcucar);
		System.out.println("Chá de limão pronto.");
	}

	public double getPreco() {
		return preco;
	}
	
}
