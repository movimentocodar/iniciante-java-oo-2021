
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
		System.out.println("Ingredientes: �gua Quente + Ch� em p� "
				+ "+ Filtro + N�vel de A��car: " + nivelAcucar);
		System.out.println("Ch� de Lim�o finalizado, obrigado e volte sempre!");
	}
}
