import java.util.Scanner; // Usu�rio ir� inserir o pedido dentre as op��es ofereridas

public class Pedido {
	
	public void realizarPedido() {
		Scanner opcaoBebida = new Scanner(System.in);
		System.out.println("Fa�a seu pedido entre as op��es:\n"
				+ "1 - Caf� por R$0.50" + ", 2 - Caf� Com Leite por R$1.00" 
				+ ", 3 - Capuccino por R$1.50" + ", 4 - Ch� De Lim�o por R$1.00" + ", 5 - �gua quente GRATUITO");
		
		int pedidoBebidaUsuario = opcaoBebida.nextInt();
		System.out.println("Obrigado, seu pedido ser�: " + pedidoBebidaUsuario);
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
				System.out.println("Fa�a o seu pedido dentre as op��es dispon�veis.");
				break;
			}
			
		}
	}
}
