/**
 *
 */
module com.jands.cafefx.maquinadecafe {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jands.cafefx.maquinadecafe to javafx.fxml;
    exports com.jands.cafefx.maquinadecafe;
    exports com.jands.cafefx.maquinadecafe.controllerFx;
    opens com.jands.cafefx.maquinadecafe.controllerFx to javafx.fxml;
}