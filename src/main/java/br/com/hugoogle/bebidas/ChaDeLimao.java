package bebidas;
import menu.fabrica.Bebida;
import model.Ingrediente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChaDeLimao extends Bebida {
    private final List<Ingrediente> ingredientes = new ArrayList<>();

    public ChaDeLimao(){
        Ingrediente agua = new Ingrediente(1, 50);
        Ingrediente filtro  = new Ingrediente(3, 5);
        Ingrediente chaEmPo  = new Ingrediente(6, 1);
        Ingrediente copo = new Ingrediente(7, 1);
        Ingrediente acucar = new Ingrediente(8, 3);
        ingredientes.add(agua);
        ingredientes.add(filtro);
        ingredientes.add(chaEmPo);
        ingredientes.add(copo);
        ingredientes.add(acucar);
    }

    @Override
    public  List<Ingrediente> getIngredients() {
              return  Collections.unmodifiableList(this.ingredientes);
    }

    @Override
    public double getPreco() {
        return 1.00;
    }

}

