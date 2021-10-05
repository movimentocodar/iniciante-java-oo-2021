package com.jands.cafefx.maquinadecafe.model.componentes;

public class ReservatorioDeAgua {
    private static double agua = 100;

    public static void usarAgua() {
        if (getAguaReservatorio() < 50) {
            System.out.println("Agua Insuficiente, Por Favor Reabasteça!");
            throw new ReservatorioException("Agua Insuficiente!");
        }
        System.out.println("Reservatorio: "+ getAguaReservatorio()
                + "\nUsando 50ml de Água do Reservatório");
        agua -= 50;
        System.out.println("Água usada, Atual: " + getAguaReservatorio());
    }

    public static boolean abastercerAgua() {
        if (getAguaReservatorio() + 200 >= 1000) {
            System.out.println("Reservatorio Já está Abastecido!");
            return false;
        }
        agua += 200;
        System.out.println("Água abastecida, Atual: " + getAguaReservatorio());
        return true;

    }

    public static double getAguaReservatorio() {
        return agua;
    }

}
