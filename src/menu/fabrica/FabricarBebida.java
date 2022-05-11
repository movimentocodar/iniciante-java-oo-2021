package menu.fabrica;

import bebidas.*;

public class FabricarBebida {

    public static final int CAFE = 1;
    public static final int CAFECOMLEITE = 2;
    public static final int CAPUCCINO = 3;
    public static final int CHADELIMAO = 4;
    public static final int AGUAQUENTE = 5;

    public Bebida getBebida(int opcaoDeBebida) {
        return switch (opcaoDeBebida) {
            case CAFE -> new Cafe();
            case CAFECOMLEITE -> new CafeComLeite();
            case CAPUCCINO -> new Capuccino();
            case CHADELIMAO -> new ChaDeLimao();
            case AGUAQUENTE -> new AguaQuente();
            default -> null;
        };
    }
}
