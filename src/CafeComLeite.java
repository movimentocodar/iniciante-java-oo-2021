
public class CafeComLeite extends NivelDeAcucar{
	
	private double preco = 1.00;

	public CafeComLeite(int pedidoBebidaUsuario) {
		super(pedidoBebidaUsuario);
	}

	public double getPreco() {
		return preco;
	}
	
	public void prepararCafeComLeite() {
		int nivelAcucar = super.solicitarNivelAcucar();
		System.out.println("Ingredientes: Água Quente + Pó de Café + Leite em Pó "
				+ "+ Filtro + Nível de Açúcar: " + nivelAcucar);
		System.out.println("Café com leite finalizado, obrigado e volte sempre!");
	}
}
