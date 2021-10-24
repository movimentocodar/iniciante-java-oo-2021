package br.com.github.zsguil.maquina_cafe.classes.service.interacao_com_usuario;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScannerService {
	private Scanner input = new Scanner(System.in);

	public int nextInt() {
		return this.input.nextInt();
	}

	public BigDecimal nextBigDecimal() {
		return this.input.nextBigDecimal();
	}

	public String nextLine() {
		return this.input.nextLine();
	}

	public Scanner reset() {
		return this.input.reset();
	}

	public String next() {
		return input.next();
	}
	
}
