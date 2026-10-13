package cl.duoc.gestormaquinaria.controller;

//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.Node;
//import javafx.event.ActionEvent;
//import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class InicioController {

    @FXML
    private void abrirRegistro() {

        Alert alerta = new Alert(
                Alert.AlertType.INFORMATION
        );

        alerta.setTitle("Navegación MVC");
        alerta.setHeaderText("Botón Ingresar");

        alerta.setContentText(
                "El controlador recibió el evento correctamente."
        );

        alerta.showAndWait();
    }

    @FXML
    private void abrirListado() {

        Alert alerta = new Alert(
                Alert.AlertType.INFORMATION
        );

        alerta.setTitle("Navegación MVC");
        alerta.setHeaderText("Botón Ver maquinarias");

        alerta.setContentText(
                "Próximamente cargaremos la vista de listado."
        );

        alerta.showAndWait();
    }
}
