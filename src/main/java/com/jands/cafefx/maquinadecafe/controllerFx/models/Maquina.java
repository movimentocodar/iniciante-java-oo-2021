package com.jands.cafefx.maquinadecafe.controllerFx.models;

import com.jands.cafefx.maquinadecafe.controllerFx.models.bebidas.SetStatus;
import com.jands.cafefx.maquinadecafe.controllerFx.models.caixa.Creditos;
import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.MaquinaDeBebida;
import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.Preparar;
import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.ReservatorioDeAgua;
import javafx.event.ActionEvent;

public class Maquina implements MaquinaDeBebida, Creditos, ReservatorioDeAgua {
    private SetStatus setStatus = new SetStatus();
    private double saldoMaquina = 0;
    private double agua = 100;

    @Override
    public boolean prepararBebida(Preparar bebida) throws InterruptedException {
        if (descontarValor(bebida.getValor())) {
            boolean usarAgua = usarAgua();
            if (usarAgua) {
                bebida.obterBebida();
                System.out.println("-----------------------------");
                return true;
            }
            System.out.println("-----------------------------");
            return false;
        } else {
            System.out.println("Sem Saldo o suficiente por favor recarregue");
            return false;
        }
    }

    @Override
    public boolean usarAgua() throws InterruptedException {
        setStatus.setStatusConsole("Usando Água do reservatório");
        if (this.agua >= 50) {
            this.agua -= 50;
            setStatus.setStatusConsole("Agua usada! Atual: "+this.agua);
            return true;
        }else {
            System.out.println("Sem água!");
            return false;
        }

    }

    @Override
    public void abastecerAgua() {
        if (this.agua+100 <= 1000) {
            this.agua += 100;
            System.out.println("Água reabastecida! Atual: "+ this.agua);
        }else {
            System.out.println("Limite 1000L de água!");
        }
    }

    @Override
    public boolean descontarValor(double valor) {
        if (this.saldoMaquina >= valor) {
            this.saldoMaquina -= valor;
            System.out.println("Foi descontado: "+ valor);
            System.out.println("Atual: "+ this.saldoMaquina);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void adicionarCreditos(double valor) {
        this.saldoMaquina = valor;
    }

    @Override
    public double getCreditos() {
        return saldoMaquina;
    }
}
