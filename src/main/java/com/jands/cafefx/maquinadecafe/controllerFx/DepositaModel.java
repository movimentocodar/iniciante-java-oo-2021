package com.jands.cafefx.maquinadecafe.controllerFx;

import com.jands.cafefx.maquinadecafe.controllerFx.models.Maquina;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepositaModel {

    public void deposita(Maquina maquina, TextField creditValue, Label labelMyCredits, ChoiceBox choiceCedulas){
        if (creditValue.isVisible()) {
            try {
                double val = Double.parseDouble(creditValue.getText());
                if (val > 0) {
                    maquina.adicionarCreditos(val);
                    System.out.println("Créditos atuais: "+ maquina.getCreditos());
                    labelMyCredits.setText("R$ "+maquina.getCreditos());

                }
            } catch (Exception e) {

            }
        }else {
            try {
                double val = Double.parseDouble((String) choiceCedulas.getValue());
                System.out.println(val);
                maquina.adicionarCreditos(val);
                System.out.println("Créditos atuais: "+ maquina.getCreditos());
                labelMyCredits.setText("R$ "+maquina.getCreditos());

            } catch (Exception e) {

            }
        }
    }


    public void switchTipoDeposita(Button btnDepositar, ChoiceBox tipoDeposito, ChoiceBox choiceCedulas, TextField creditValue){
        if (!btnDepositar.isVisible()) btnDepositar.setVisible(true);

        String value = (String) tipoDeposito.getValue();
        if (value.equals("Débito")) {
            choiceCedulas.setVisible(false);
            creditValue.setVisible(true);

        } else {
            choiceCedulas.setVisible(true);
            creditValue.setVisible(false);
        }
    }


}
