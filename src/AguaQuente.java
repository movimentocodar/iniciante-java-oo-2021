
public class AguaQuente extends NivelDeAcucar {
	
	private String preco = "Gratuito";
	
	public AguaQuente(int pedidoBebidaUsuario) {
		super(pedidoBebidaUsuario);
	}

	public String getPreco() {
		return preco;
	}
	
	public void prepararAguaQuente() {
		System.out.println("�gua Quente � gratuito, obrigado pelo pedido");
	}
}
