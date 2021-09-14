package com.jands.cafefx.maquinadecafe.controllerFx.models.componentes;

import com.jands.cafefx.maquinadecafe.controllerFx.models.bebidas.*;

public enum Preparar {

    AGUAQUENTE {
        @Override
        public BebidaPreparavel obterBebida() throws InterruptedException {
            return new AguaQuente();
        }

        @Override
        public String titulo() {
            return "Água Quente";
        }

        @Override
        public double getValor() {
            return 0;
        }
    },
    CAFE {
        @Override
        public BebidaPreparavel obterBebida() throws InterruptedException {;
            new Cafe();
            new Filtro().filtrar();
            return new SetStatus().setStatusConsole("Seu Café está pronto");
        }

        @Override
        public String titulo() {
            return "Cáfé";
        }

        @Override
        public double getValor() {
            return 0.50;
        }
    },
    CAFECOMLEITE {
        @Override
        public BebidaPreparavel obterBebida() throws InterruptedException {
            new CafeComLeite();
            new Filtro().filtrar();
            return new SetStatus().setStatusConsole("Seu Café com Leite está Pronto!!!");
        }

        @Override
        public String titulo() {
            return "Cáfé com Leite";
        }

        @Override
        public double getValor() {
            return 1.00;
        }

    },
    CAPUCCINO {
        @Override
        public BebidaPreparavel obterBebida() throws InterruptedException {
            new Capuccino();
            new Filtro().filtrar();
            return new SetStatus().setStatusConsole("Seu Capuccino está Pronto!!!");
        }

        @Override
        public String titulo() {
            return "Capuccino";
        }

        @Override
        public double getValor() {
            return 1.50;
        }
    },
    CHADELIMAO {
        @Override
        public BebidaPreparavel obterBebida() throws InterruptedException {
            new ChaDeLimao();
            new Filtro().filtrar();
            return new SetStatus().setStatusConsole("Seu Chá está Pronto!!!");
        }

        @Override
        public String titulo() {
            return "Chá de Limão";
        }

        @Override
        public double getValor() {
            return 1.00;
        }
    };

    public abstract BebidaPreparavel obterBebida() throws InterruptedException;
    public abstract String titulo();
    public abstract double getValor();
}
