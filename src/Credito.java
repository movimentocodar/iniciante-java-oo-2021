import java.util.Scanner;

public class Credito{
	
	private double valorTotalCreditos;
	
	public void AdicionarCredito(Credito credito) {
		Scanner opcaoCredito = new Scanner(System.in);
		System.out.println("Entre com a forma de pagamento desejada:\n"
				+ "1 - Notas\n"
				+ "2 - Débito");
		
		int opcaoInserida = opcaoCredito.nextInt();
		
		if(opcaoInserida == 1) {
			Scanner opcaoNotas = new Scanner(System.in);
			System.out.println("Entre com o número da nota desejada:\n"
					+ "2 - R$ 2,00\n"
					+ "5 - R$ 5,00\n"
					+ "10 - R$ 10,00\n"
					+ "20 - R$ 20,00\n"
					+ "50 - R$ 50,00\n"
					+ "100 - R$ 100,00");
			
			int notaInserida = opcaoNotas.nextInt();			
			credito.setValorTotalCreditos(notaInserida);
			
		} else if(opcaoInserida > 0) {
			
			Scanner opcaoDebito = new Scanner(System.in);
			System.out.println("Entre com o valor de crédito desejado:\n");
			double valorInserido = opcaoDebito.nextInt();
			credito.setValorTotalCreditos(valorInserido);
			
		}
		System.out.println("Valor total de créditos: " + credito.getValorTotalCreditos());
	}

	public double getValorTotalCreditos() {
		return valorTotalCreditos;
	}

	public void setValorTotalCreditos(double valorTotalCreditos) {
		this.valorTotalCreditos = valorTotalCreditos;
	}	

}
