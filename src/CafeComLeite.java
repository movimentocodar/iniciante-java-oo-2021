
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
		System.out.println("Ingredientes: �gua Quente + P� de Caf� + Leite em P� "
				+ "+ Filtro + N�vel de A��car: " + nivelAcucar);
		System.out.println("Caf� com leite finalizado, obrigado e volte sempre!");
	}
}
