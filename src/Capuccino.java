
public class Capuccino extends NivelDeAcucar{
	
	private double preco = 1.50;
	
	public Capuccino(int pedidoBebidaUsuario) {
		super(pedidoBebidaUsuario);
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void prepararCapuccino() {
		int nivelAcucar = super.solicitarNivelAcucar();
		System.out.println("Ingredientes: �gua Quente + Caf� em p� + Leite em p� "
				+ "+ Chocolate em P� + Filtro + N�vel de A��car: " + nivelAcucar);
		System.out.println("Capuccino pronto");
	}
}
