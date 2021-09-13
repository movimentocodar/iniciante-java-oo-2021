
public class Cafe extends Bebida{
	
	private double preco = 0.5;
	
	public Cafe(int numeroDaOpcao) {
		super(numeroDaOpcao);
	}
	
	public void prepararCafe(Bebida agua) {
		if(agua.confereNivelDeAgua(agua)){
			agua.abastecerAgua(agua);
		}
		int nivelAcucar = super.solicitarNivelAcucar();
		System.out.println("Adicionando: café em pó + filtro + nível de açúcar de: " + nivelAcucar);
		System.out.println("Café pronto.");
		
	}

	public double getPreco() {
		return preco;
	}
	
}
