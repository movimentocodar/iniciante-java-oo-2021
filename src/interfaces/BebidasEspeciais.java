package interfaces;

// Bebidas que requerem um preparo. Todas exceto Água Quente.

public interface BebidasEspeciais {

	public void preparo(int acucar);
		
	@Override
	public String toString();
}
