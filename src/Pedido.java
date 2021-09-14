import java.util.Scanner; // Usuário irá inserir o pedido dentre as opções ofereridas

public class Pedido {
	
	public void realizarPedido() {
		Scanner opcaoBebida = new Scanner(System.in);
		System.out.println("Faça seu pedido entre as opções:\n"
				+ "1 - Café por R$0.50" + ", 2 - Café Com Leite por R$1.00" 
				+ ", 3 - Capuccino por R$1.50" + ", 4 - Chá De Limão por R$1.00" + ", 5 - Água quente GRATUITO");
		
		int pedidoBebidaUsuario = opcaoBebida.nextInt();
		System.out.println("Obrigado, seu pedido será: " + pedidoBebidaUsuario);
		NivelDeAcucar agua = new NivelDeAcucar(pedidoBebidaUsuario);
		
		switch (pedidoBebidaUsuario) {
		case 1:
			Cafe cafe = new Cafe(pedidoBebidaUsuario);
			cafe.prepararCafe();
			break;
			
		case 2:
			CafeComLeite cafeComLeite = new CafeComLeite(pedidoBebidaUsuario);
			cafeComLeite.prepararCafeComLeite();
			break;
			
		case 3:
			Capuccino capuccino = new Capuccino(pedidoBebidaUsuario);
			capuccino.prepararCapuccino();
			break;
		
		case 4:
			ChaDeLimao chaDeLimao = new ChaDeLimao(pedidoBebidaUsuario);
			chaDeLimao.prepararChaDeLimao();
			break;
			
		case 5:
			AguaQuente aguaQuente = new AguaQuente(pedidoBebidaUsuario);
			aguaQuente.prepararAguaQuente();
			
			
			if(pedidoBebidaUsuario > 5) {
				System.out.println("Faça o seu pedido dentre as opções disponíveis.");
				break;
			}
			
		}
	}
}
