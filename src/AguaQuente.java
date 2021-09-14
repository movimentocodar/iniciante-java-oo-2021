
public class AguaQuente extends NivelDeAcucar {
	
	private String preco = "Gratuito";
	
	public AguaQuente(int pedidoBebidaUsuario) {
		super(pedidoBebidaUsuario);
	}

	public String getPreco() {
		return preco;
	}
	
	public void prepararAguaQuente() {
		System.out.println("Água Quente é gratuito, obrigado pelo pedido");
	}
}
