package com.github.movimentocodar.maquinadecafe.controller;

import com.github.movimentocodar.maquinadecafe.maquinadecafe.MaquinaCafe;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas.*;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.creditos.FormaDePagamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private MaquinaCafe maquinadecafe = new MaquinaCafe();

    @FXML
    private ChoiceBox<BebidaImpl> bebidasPreparaveis;
    private BebidaImpl[] bebidas = {new AguaQuente(), new Cafe(), new CafeComLeite(), new Capuccino(), new ChaDeLimao()};

    @FXML private ChoiceBox<FormaDePagamento> tipoDeposito;
    private FormaDePagamento[] formaDePagamentos = {FormaDePagamento.CEDULA, FormaDePagamento.DEBITO};

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
        labelStatus.setText("");
        try {
            maquinadecafe.comprarBebida(bebidasPreparaveis.getValue(), sliderAcucar.getValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            labelStatus.setText(e.getMessage());
        }
    }
//
    private void switchTipoDeposita(ActionEvent event) {
        if (!btnDepositar.isVisible()) btnDepositar.setVisible(true);

        if (tipoDeposito.getValue().equals(FormaDePagamento.DEBITO)) {
            choiceCedulas.setVisible(false);
            creditValue.setVisible(true);
            return;
        }
            choiceCedulas.setVisible(true);
            creditValue.setVisible(false);
    }

    private void reabastecerAgua(ActionEvent event) {
        try {
            maquinadecafe.abastecerMaquina(200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            labelStatus.setText(e.getMessage());
        }
    }

    private void depositar(ActionEvent event) {
        try {
            if (creditValue.isVisible()) {
                maquinadecafe.adicionarCredito(new BigDecimal(creditValue.getText()), tipoDeposito.getValue());
                labelMyCredits.setText("R$ " + maquinadecafe.getCredito());
                return;
            }

            maquinadecafe.adicionarCredito(new BigDecimal(choiceCedulas.getValue()), tipoDeposito.getValue());
            labelMyCredits.setText("R$ " + maquinadecafe.getCredito());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            labelStatus.setText(e.getMessage());
        }
    }

    private void receberTroco(ActionEvent event) {
        try {
            maquinadecafe.sacarDinheiro(maquinadecafe.getCredito());
            labelMyCredits.setText("R$ " + maquinadecafe.getCredito());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            labelStatus.setText(e.getMessage());
        }
    }

    private void switchSliderAcucar(ActionEvent event) {
        try {
            labelValorDaBebida.setText("Valor do(a) " + bebidasPreparaveis.getValue().nome()+ " R$: " + bebidasPreparaveis.getValue().preco());
            sliderAcucar.setDisable(!bebidasPreparaveis.getValue().isAcucaravel());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            labelStatus.setText(e.getMessage());
        }
    }
}
