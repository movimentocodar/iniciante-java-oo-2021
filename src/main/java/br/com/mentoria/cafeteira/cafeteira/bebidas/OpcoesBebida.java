package br.com.mentoria.cafeteira.cafeteira.bebidas;

public enum OpcoesBebida {
	
	AGUA(0.0, 50, "água"),
	CAFE(0.5, 50, "água + filtro + pó de café"),
	CAFE_COM_LEITE(1.0, 50, "água + filtro + pó de café + leite em pó"),
	CAPUCCINO(1.5, 50, "água + filtro + pó de café + leite em pó + chocolate em pó"),
	CHA_DE_LIMAO(1.0, 50, "água + filtro + chá em pó");
	
	private final double preco;
	private final int usoAgua;
	private String ingredientes;

	private OpcoesBebida(double preco, int usoAgua, String ingredientes) {
		this.preco = preco;
		this.usoAgua = usoAgua;
		this.ingredientes = ingredientes;
	}

	public double getPreco() {
		return preco;
	}

	public int getUsoAgua() {
		return usoAgua;
	}
	
	public String getIngredientes() {
		return ingredientes;
	}
	
}
