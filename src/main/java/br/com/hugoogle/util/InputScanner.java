package br.com.hugoogle.util;

import java.util.Scanner;

public  class InputScanner {

    private final Scanner scanner = new Scanner(System.in);


    private int validarERetornarOpcaoInformada(){
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        } else {
            return 0;
        }
    }

    public int entrada(){
        return  validarERetornarOpcaoInformada();
    }
    public void sair(){
        fechar();
    }
    private double validarERetornarValorInformado(){
        if (scanner.hasNextDouble()){
            return scanner.nextDouble();
        } else {
            return 0;
        }
    }

    public double entradaDouble(){
        return  validarERetornarValorInformado();
    }
    public void fechar(){
        System.exit(0);


    }

}