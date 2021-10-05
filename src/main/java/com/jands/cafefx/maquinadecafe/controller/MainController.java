package com.jands.cafefx.maquinadecafe.controller;


import com.jands.cafefx.maquinadecafe.model.MaquinaDeCafe;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.*;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.Cedulas;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.Debito;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();
    ICreditavel cedula, debito;

    @FXML private ChoiceBox<IBebida> bebidasPreparaveis;
    private IBebida[] bebidas = {new AguaQuente(), new Cafe(), new CafeComLeite(), new Capuccino(), new ChaDeLimao()};

    @FXML private ChoiceBox<ICreditavel> tipoDeposito;
    private ICreditavel[] formaDePagamentos = {debito = new Debito(), cedula = new Cedulas()};

    @FXML private ChoiceBox<Double> choiceCedulas;
    private Double[] cedulas = {2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 200.0};

    @FXML private TextField creditValue;
    @FXML private Button btnDepositar;
    @FXML private Slider sliderAcucar;
    @FXML private Button btnPreparar;
    @FXML private Label labelMyCredits;
    @FXML private Button trocoBtn;
    @FXML private Label labelStatus;
    @FXML private Label labelValorDaBebida;
    @FXML private Button abastecerBtn;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tipoDeposito.getItems().addAll(formaDePagamentos);
        bebidasPreparaveis.getItems().addAll(bebidas);
        choiceCedulas.getItems().addAll(cedulas);
        tipoDeposito.setOnAction(this::switchTipoDeposita);
        btnDepositar.setOnAction(this::depositar);
        trocoBtn.setOnAction( this::receberTroco);
        btnPreparar.setOnAction(this::prepararBebida);
        abastecerBtn.setOnAction(this::reabastecerAgua);
        bebidasPreparaveis.setOnAction(this::switchSliderAcucar);
    }

    private void prepararBebida(ActionEvent event) {
        ControllerEvents.PrepararBebidaEvent(maquinaDeCafe, bebidasPreparaveis, labelMyCredits, sliderAcucar, labelStatus);
    }

    private void switchTipoDeposita(ActionEvent event) {
        ControllerEvents.SwitchTipoDeposita(btnDepositar, tipoDeposito, choiceCedulas, creditValue, debito);
    }

    private void reabastecerAgua(ActionEvent event) {
        ControllerEvents.ReabastecerEvent();
    }

    private void depositar(ActionEvent event) {
        ControllerEvents.DepositarEvent(tipoDeposito, maquinaDeCafe, creditValue, debito, labelMyCredits, choiceCedulas);
    }

    private void receberTroco(ActionEvent event) {
        ControllerEvents.ReceberTrocoEvent(maquinaDeCafe, labelMyCredits);
    }

    private void switchSliderAcucar(ActionEvent event) {
        labelValorDaBebida.setText("Valor do(a) " + bebidasPreparaveis.getValue().getNome()+ " R$: " + bebidasPreparaveis.getValue().getPreco());
        sliderAcucar.setDisable(!bebidasPreparaveis.getValue().isAcucaravel());
    }

}
