package menu;

import controller.ControlerReabastecer;

public class MenuAbastecer {
    private static final ControlerReabastecer controlerReabastecer = new ControlerReabastecer();

    public static void abastecer(){
        controlerReabastecer.consultarEstoque();
    }


}
