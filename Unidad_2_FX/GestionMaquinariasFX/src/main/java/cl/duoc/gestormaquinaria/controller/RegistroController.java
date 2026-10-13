
package cl.duoc.gestormaquinaria.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegistroController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private ComboBox<String> cmbTipo;

    @FXML
    private TextField txtHoras;

    @FXML
    private TextField txtPotencia;


    @FXML
    private void initialize() {

        cmbTipo.getItems().addAll(
                "Excavadora",
                "Cargador Frontal"
        );

        System.out.println(
                "Formulario de registro inicializado"
        );
    }


    @FXML
    private void guardarMaquina() {

        String codigo = txtCodigo.getText().trim();
        String tipo = cmbTipo.getValue();

        if (codigo.isEmpty() || tipo == null) {

            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Validación",
                    "Debe ingresar un código y seleccionar un tipo."
            );

            return;
        }

        int horas;
        int potencia;

        try {

            horas = Integer.parseInt(
                    txtHoras.getText().trim()
            );

            potencia = Integer.parseInt(
                    txtPotencia.getText().trim()
            );

        } catch (NumberFormatException e) {

            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Validación",
                    "Horas y potencia deben ser números enteros."
            );

            return;
        }

        if (horas < 0 || potencia <= 0) {

            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Validación",
                    "Horas debe ser >= 0 y potencia mayor que 0."
            );

            return;
        }

        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Datos validados",
                "Código: " + codigo +
                        "\nTipo: " + tipo +
                        "\nHoras: " + horas +
                        "\nPotencia: " + potencia
        );
    }


    @FXML
    private void volverInicio() {

        System.out.println("Volver al inicio");

    }


    private void mostrarAlerta(
            Alert.AlertType tipo,
            String titulo,
            String mensaje) {

        Alert alerta = new Alert(tipo);

        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
}

