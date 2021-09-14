
public class Cafe extends NivelDeAcucar{
	
	private double preco = 0.50;
	
	public Cafe(int pedidoBebidaUsuario) {
		super(pedidoBebidaUsuario);
	}

	public double getPreco() {
		return preco;
	}
	
	public void prepararCafe() {
		int nivelAcucar = super.solicitarNivelAcucar();
		System.out.println("Ingredientes: Água Quente + Pó de Café "
				+ "+ Filtro + Nível de Açúcar: " + nivelAcucar);
		System.out.println("Café finalizado, obrigado e volte sempre!");
	}
}
