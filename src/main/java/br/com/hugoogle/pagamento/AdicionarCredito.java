package pagamento;

import enumerator.ColorEnum;
import util.InputScanner;

public class AdicionarCredito {
    private final InputScanner inputScanner = new InputScanner();
    private double valor;

    public double inserirValor() {
        System.out.print(ColorEnum.RESET.getColorCode() + "*** Inserir Credito ***");
        do {

            System.out.print(ColorEnum.YELLOW.getColorCode() + "\nInforme o valor a pagar: " + ColorEnum.RESET.getColorCode());
            this.valor = inputScanner.entradaDouble();
            ReconhecimentoDeCedula.detectarCedula(valor);
        } while (isCedulaInValida());
        return  this.valor;

    }
    private boolean isCedulaInValida() {
        return !ReconhecimentoDeCedula.isCedulaValida();
    }

    public  double getValor() {
        return this.valor;
    }

}
