import java.util.Scanner;

public class NivelDeAcucar extends Pedido{
	
	public NivelDeAcucar(int pedidoBebidaUsuario) {
		// TODO Auto-generated constructor stub
	}

	public int solicitarNivelAcucar() {
		Scanner opcaoAcucar = new Scanner(System.in);
	    System.out.println("Como padr�o, o n�vel de a��car ser� 3, qual n�vel gostaria? " + "1, 2, 3, 4, 5");

	    int pedidoAcucarUsuario = opcaoAcucar.nextInt();
	    System.out.println("Obrigado, o n�vel de a��car escolhido foi: " + pedidoAcucarUsuario);
	    return pedidoAcucarUsuario;
	} 
}
