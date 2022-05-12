package bebidas;
import menu.fabrica.Bebida;
import model.Ingrediente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CafeComLeite extends Bebida {
    private final List<Ingrediente> ingredientes = new ArrayList<>();


    public CafeComLeite(){
        Ingrediente agua = new Ingrediente(1, 50);
        Ingrediente poDeCafe = new Ingrediente(2, 7);
        Ingrediente filtro  = new Ingrediente(3, 1);
        Ingrediente leiteEmPo  = new Ingrediente(4, 8);
        Ingrediente copo = new Ingrediente(7, 1);
        Ingrediente acucar = new Ingrediente(8, 3);
        ingredientes.add(agua);
        ingredientes.add(poDeCafe);
        ingredientes.add(filtro);
        ingredientes.add(leiteEmPo);
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

