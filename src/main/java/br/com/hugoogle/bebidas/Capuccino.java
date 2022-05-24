package bebidas;
import menu.fabrica.Bebida;
import model.Ingrediente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Capuccino extends Bebida {
    private final List<Ingrediente> ingredientes = new ArrayList<>();

    public Capuccino(){
        Ingrediente agua = new Ingrediente(1, 50);
        Ingrediente poDeCafe = new Ingrediente(2, 5);
        Ingrediente filtro  = new Ingrediente(3, 1);
        Ingrediente leiteEmPo  = new Ingrediente(4, 5);
        Ingrediente choColateEmPo  = new Ingrediente(5, 7);
        Ingrediente copo = new Ingrediente(7, 1);
        Ingrediente acucar = new Ingrediente(8, 3);
        ingredientes.add(agua);
        ingredientes.add(poDeCafe);
        ingredientes.add(filtro);
        ingredientes.add(leiteEmPo);
        ingredientes.add(choColateEmPo);
        ingredientes.add(copo);
        ingredientes.add(acucar);
    }

    @Override
    public  List<Ingrediente> getIngredients() {
        return  Collections.unmodifiableList(this.ingredientes);
    }

    @Override
    public double getPreco() {
        return 1.50;
    }

}

