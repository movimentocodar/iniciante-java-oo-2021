package bebidas;

import menu.fabrica.Bebida;
import model.Ingrediente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AguaQuente extends Bebida {
    private final List<Ingrediente> ingredientes = new ArrayList<>();

    public AguaQuente() {
        Ingrediente agua = new Ingrediente(1, 50);
        Ingrediente copo = new Ingrediente(7, 1);
        ingredientes.add(agua);
        ingredientes.add(copo);
    }

    @Override
    public List<Ingrediente> getIngredients() {
        return Collections.unmodifiableList(ingredientes);
    }

    @Override
    public double getPreco() {
        return 0;
    }

    @Override
    public boolean isNotGratis(){return  true;}

}

