import java.util.Scanner;

public class NivelDeAcucar extends Pedido{
	
	public NivelDeAcucar(int pedidoBebidaUsuario) {
		// TODO Auto-generated constructor stub
	}

	public int solicitarNivelAcucar() {
		Scanner opcaoAcucar = new Scanner(System.in);
	    System.out.println("Como padrão, o nível de açúcar será 3, qual nível gostaria? " + "1, 2, 3, 4, 5");

	    int pedidoAcucarUsuario = opcaoAcucar.nextInt();
	    System.out.println("Obrigado, o nível de açúcar escolhido foi: " + pedidoAcucarUsuario);
	    return pedidoAcucarUsuario;
	} 
}
