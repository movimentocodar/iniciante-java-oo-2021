package br.com.mentoria.cafeteira.cafeteira.bebidas;

public enum OpcoesBebida {
	
	AGUA(5, 0.0, 50, "água"),
	CAFE(1, 0.5, 50, "água + filtro + pó de café"),
	CAFE_COM_LEITE(2, 1.0, 50, "água + filtro + pó de café + leite em pó"),
	CAPUCCINO(3, 1.5, 50, "água + filtro + pó de café + leite em pó + chocolate em pó"),
	CHA_DE_LIMAO(4, 1.0, 50, "água + filtro + chá em pó");
	
	private final int index;
	private final double preco;
	private final int usoAgua;
	private String ingredientes;

	private OpcoesBebida(int index, double preco, int usoAgua, String ingredientes) {
		this.index = index;
		this.preco = preco;
		this.usoAgua = usoAgua;
		this.ingredientes = ingredientes;
	}
	
	public int getIndex() {
		return index;
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
