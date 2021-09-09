import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class SistemaInterno {
	private Scanner prompt = new Scanner(System.in);
	private int escolha;
	
	public void pausa(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
        	Thread.currentThread().interrupt();
        	System.out.println("Oh oh, algo aconteceu aqui...");
        	ex.printStackTrace();
        }
    }

	public void tryEscolha() {

		try {
			this.escolha = prompt.nextInt();
		} catch(InputMismatchException ex) {
			System.out.println("\n ");
			System.out.println("Tente novamente e insira um número válido!!");
			pausa(3000);
			escolha = prompt.nextInt();
		}
	}
	
}