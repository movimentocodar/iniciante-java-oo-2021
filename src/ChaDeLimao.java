
public class ChaDeLimao extends NivelDeAcucar{

	private double preco = 1.00;

	public ChaDeLimao(int pedidoBebidaUsuario) {
		super(pedidoBebidaUsuario);
	}

	public double getPreco() {
		return preco;
	}
	
	public void prepararChaDeLimao() {
		int nivelAcucar = super.solicitarNivelAcucar();
		System.out.println("Ingredientes: Água Quente + Chá em pó "
				+ "+ Filtro + Nível de Açúcar: " + nivelAcucar);
		System.out.println("Chá de Limão finalizado, obrigado e volte sempre!");
	}
}
