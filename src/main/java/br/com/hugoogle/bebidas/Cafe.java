package br.com.hugoogle.bebidas;

import br.com.hugoogle.menu.fabrica.Bebida;
import br.com.hugoogle.model.Ingrediente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cafe extends Bebida {
    private final List<Ingrediente> ingredientes = new ArrayList<>();

    public Cafe(){
        Ingrediente agua = new Ingrediente(1, 50);
        Ingrediente poDeCafe = new Ingrediente(2, 5);
        Ingrediente filtro  = new Ingrediente(3, 1);
        Ingrediente copo = new Ingrediente(7, 1);
        Ingrediente acucar = new Ingrediente(8, 3);
        ingredientes.add(agua);
        ingredientes.add(poDeCafe);
        ingredientes.add(copo);
        ingredientes.add(filtro);
        ingredientes.add(acucar);
    }

    @Override
    public List<Ingrediente> getIngredients() {
        return Collections.unmodifiableList(this.ingredientes);
    }

    @Override
    public double getPreco() {
        return 0.50;
    }

}
