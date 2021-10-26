package com.github.movimentocodar.maquinadecafe;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        try {
            Parent root = FXMLLoader.load(Main.class.getResource("view/pages/main.fxml"));
            Scene scene = new Scene(root, 302, 500);

            scene.getStylesheets().add(Main.class.getResource("view/css/main.css").toExternalForm());
            stage.setTitle("Máquina de Café");
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }

}
