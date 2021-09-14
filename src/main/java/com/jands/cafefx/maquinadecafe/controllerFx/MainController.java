package com.jands.cafefx.maquinadecafe.controllerFx;


import com.jands.cafefx.maquinadecafe.controllerFx.models.Maquina;
import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.Preparar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable, Deposita, AdicionarAcucar, PrepararBebida, ReceberTroco{
    private int selected;
    private Maquina maquina = new Maquina();
    private DepositaModel depositaModelo = new DepositaModel();
    private AdicionarAcucarModel adicionarAcucarModel = new AdicionarAcucarModel();
    private PrepararBebidaModel prepararBebidaModel = new PrepararBebidaModel();
    private ReceberTrocoModel receberTrocoModel = new ReceberTrocoModel();

    @FXML private ChoiceBox<String> choiceItem;
    private ArrayList<String> items = new ArrayList<>();

    @FXML private ChoiceBox<String> tipoDeposito;
    private String[] tagsCredito = {"Cédula", "Débito"};

    @FXML private ChoiceBox<String> choiceCedulas;
    private String[] cedulas = {"2", "5", "10", "20", "50", "100", "200"};

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

        List<Preparar> prepararList = Arrays.asList(Preparar.values());
        prepararList.forEach(preparar -> {
            items.add(preparar.titulo());
        });

        choiceItem.getItems().addAll(items);
        choiceItem.setOnAction(this::disableAcucar);
        tipoDeposito.getItems().addAll(tagsCredito);
        tipoDeposito.setOnAction(this::switchTipoDeposita);
        choiceCedulas.getItems().addAll(cedulas);
        sliderAcucar.setOnMouseReleased(this::adicionarAcucar);
        btnDepositar.setOnAction(this::deposita);
        trocoBtn.setOnAction(this::receberTroco);
        abastecerBtn.setOnAction(this::abastecerAgua);

        btnPreparar.setOnAction(event -> {
            try {
                prepararBebida(event);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public void deposita(ActionEvent event) {
        depositaModelo.deposita(this.maquina, this.creditValue, this.labelMyCredits, this.choiceCedulas);
    }

    @Override
    public void switchTipoDeposita(ActionEvent event) {
        depositaModelo.switchTipoDeposita(btnDepositar, tipoDeposito, choiceCedulas, creditValue);
    }

    @Override
    public void adicionarAcucar(MouseEvent event) {
        adicionarAcucarModel.adicionarAcucar(sliderAcucar);
    }

    @Override
    public void checkAcucar(boolean preparar) throws InterruptedException {
        adicionarAcucarModel.checkAcucar(sliderAcucar, preparar);
    }

    @Override
    public void prepararBebida(ActionEvent event) throws InterruptedException {
        checkAcucar(prepararBebidaModel.prepararBebida(maquina, selected,labelStatus));
        labelMyCredits.setText("R$ "+maquina.getCreditos());
    }

    @Override
    public void disableAcucar(ActionEvent event) {
        prepararBebidaModel.disableAcucar(choiceItem, items, selected, sliderAcucar, labelValorDaBebida);
        this.selected = prepararBebidaModel.getSelected();
    }

    @Override
    public void receberTroco(ActionEvent event) {
        receberTrocoModel.receberTroco(maquina, labelMyCredits);
    }

    public void abastecerAgua(ActionEvent event) {
        maquina.abastecerAgua();
    }
}
