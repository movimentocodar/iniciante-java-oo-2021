package br.com.codar.maquinacafe;

public abstract class Bebida {
	
	public Bebida(int pedidoBebidaUsuario) {
	}
	
	public abstract void preparaBebida(Credito credito, ReservatorioAgua reservatorio);
	public abstract int solicitaNivelAcucar();
}
