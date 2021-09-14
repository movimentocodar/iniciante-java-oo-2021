
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
		System.out.println("Ingredientes: Água Quente + Café em pó + Leite em pó "
				+ "+ Chocolate em Pó + Filtro + Nível de Açúcar: " + nivelAcucar);
		System.out.println("Capuccino pronto");
	}
}
