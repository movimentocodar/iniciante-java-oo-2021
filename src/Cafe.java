
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
		System.out.println("Ingredientes: �gua Quente + P� de Caf� "
				+ "+ Filtro + N�vel de A��car: " + nivelAcucar);
		System.out.println("Caf� finalizado, obrigado e volte sempre!");
	}
}
