package cl.duoc.gestormaquinaria;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("1. Ejecutando init()");
    }

    @Override
    public void start(Stage stage) throws Exception {

        GestorMaquina gestor = new GestorMaquina();
        System.out.println("2. Ejecutando start");

        // 1. Ekementos de la pantalla inicial

        Label titulo = new Label("Sistema de Gestión de Maquinaria");

        Button btnIngresar = new Button("Ingresar");

        VBox root = new VBox(20);

        root.getChildren().add(titulo);
        root.getChildren().add(btnIngresar);

        root.setAlignment(Pos.CENTER);

//        btnIngresar.setOnAction(event -> {
//            titulo.setText("Bienvenido a java FX!!!!");
//        });

        Scene sceneInicio = new Scene(root, 600, 550);

        //2. Elementos de la pantalla registro

        Label tituloRegistro = new Label("Registro Maquinaria");

        Label lblCodigo = new Label("Código:");
        TextField txtCodigo = new TextField();
        txtCodigo.setPromptText("Ejemplo: EXC-001");
        txtCodigo.setMaxWidth(250);


        Label lblTipo = new Label("Tipo de máquina:");
        ComboBox<String> cmbTipo = new ComboBox<>();
        cmbTipo.getItems().add("Excavadora");
        cmbTipo.getItems().add("Cargador Frontal");
        cmbTipo.setPromptText("Seleccione un tipo");
        cmbTipo.setMaxWidth(250);


        Label lblHoras = new Label("Horas de uso:");
        TextField txtHoras = new TextField();
        txtHoras.setPromptText("Ejemplo: 1500");
        txtHoras.setMaxWidth(250);
        Label lblPotencia = new Label("Potencia:");
        TextField txtPotencia = new TextField();
        txtPotencia.setPromptText("Ejemplo: 250");
        txtPotencia.setMaxWidth(250);

        Button btnGuardar = new Button("Guardar");
        Button btnVolver = new Button("Volver al Inicio");

        VBox rootRegistro = new VBox(10);

//        rootRegistro.getChildren().add(tituloRegistro);
//        rootRegistro.getChildren().add(btnVolver);

        rootRegistro.getChildren().addAll(
                tituloRegistro,
                lblCodigo,
                txtCodigo,
                lblTipo,
                cmbTipo,
                lblHoras,
                txtHoras,
                lblPotencia,
                txtPotencia,
                btnGuardar,
                btnVolver

        );

        rootRegistro.setAlignment(Pos.CENTER);

        Scene sceneRegistro = new Scene(rootRegistro, 600, 550);

        // 3. Eventos de navegación
        btnIngresar.setOnAction(event -> {
            stage.setScene(sceneRegistro);
        });

        btnVolver.setOnAction(event -> {
            stage.setScene(sceneInicio);
        });

//        btnGuardar.setOnAction(event -> {
//
//            String codigo = txtCodigo.getText();
//
//            String tipo = cmbTipo.getValue();
//
//            String horas = txtHoras.getText();
//
//            String potencia = txtPotencia.getText();
//
//            System.out.println("Código: " + codigo);
//            System.out.println("Tipo: " + tipo);
//            System.out.println("Horas: " + horas);
//            System.out.println("Potencia: " + potencia);
//
//        });

        btnGuardar.setOnAction(event -> {

            // 1. OBTENER EL CÓDIGO

            String codigo = txtCodigo.getText().trim();

            if (codigo.isEmpty()) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error de validación");
                alerta.setHeaderText("Código obligatorio");
                alerta.setContentText(
                        "Debe ingresar el código de la maquinaria."
                );
                alerta.showAndWait();

                return;
            }


            // 2. VALIDAR TIPO DE MAQUINARIA

            String tipo = cmbTipo.getValue();

            if (tipo == null) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error de validación");
                alerta.setHeaderText("Tipo obligatorio");
                alerta.setContentText(
                        "Debe seleccionar un tipo de maquinaria."
                );
                alerta.showAndWait();

                return;
            }


            // 3. VALIDAR HORAS DE USO

            int horas;

            try {

                horas = Integer.parseInt(
                        txtHoras.getText().trim()
                );

            } catch (NumberFormatException e) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error de validación");
                alerta.setHeaderText("Horas incorrectas");
                alerta.setContentText(
                        "Las horas de uso deben ser un número entero."
                );
                alerta.showAndWait();

                return;
            }

            if (horas < 0) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error de validación");
                alerta.setHeaderText("Horas incorrectas");
                alerta.setContentText(
                        "Las horas de uso no pueden ser negativas."
                );
                alerta.showAndWait();

                return;
            }


            // 4. VALIDAR POTENCIA

            int potencia;

            try {

                potencia = Integer.parseInt(
                        txtPotencia.getText().trim()
                );

            } catch (NumberFormatException e) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error de validación");
                alerta.setHeaderText("Potencia incorrecta");
                alerta.setContentText(
                        "La potencia debe ser un número entero."
                );
                alerta.showAndWait();

                return;
            }

            if (potencia <= 0) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error de validación");
                alerta.setHeaderText("Potencia incorrecta");
                alerta.setContentText(
                        "La potencia debe ser mayor que cero."
                );
                alerta.showAndWait();

                return;
            }


//            // 5. TODOS LOS DATOS SON VÁLIDOS
//
//            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//
//            alerta.setTitle("Registro correcto");
//            alerta.setHeaderText("Datos validados");
//
//            alerta.setContentText(
//                    "Código: " + codigo +
//                            "\nTipo: " + tipo +
//                            "\nHoras de uso: " + horas +
//                            "\nPotencia: " + potencia
//            );
//
//            alerta.showAndWait();
//
//        });


        // 5. CREAR EL OBJETO SEGÚN EL TIPO SELECCIONADO

            Maquina nuevaMaquina;

            if (tipo.equals("Excavadora")) {

                nuevaMaquina = new Excavadora(
                        codigo,
                        horas,
                        potencia
                );

            } else if (tipo.equals("Cargador Frontal")) {

                nuevaMaquina = new CargadorFrontal(
                        codigo,
                        horas,
                        potencia
                );

            } else {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Tipo no reconocido");
                alerta.setContentText("Seleccione un tipo de maquinaria válido.");
                alerta.showAndWait();

                return;
            }

            // 6. REGISTRAR LA MAQUINARIA

            boolean registrado = gestor.agregarMaquina(nuevaMaquina);

            if (!registrado) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Registro rechazado");
                alerta.setHeaderText("Código duplicado");
                alerta.setContentText(
                        "Ya existe una maquinaria con el código: " + codigo
                );
                alerta.showAndWait();

                return;
            }


            // 7. CONFIRMAR EL REGISTRO

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);

            alerta.setTitle("Registro correcto");
            alerta.setHeaderText("Maquinaria registrada");

            alerta.setContentText(
                    "Código: " + nuevaMaquina.getCodigo() +
                            "\nTipo: " + nuevaMaquina.getTipo() +
                            "\nHoras de uso: " + nuevaMaquina.getHorasUso() +
                            "\nPotencia: " + nuevaMaquina.getPotencia() +
                            "\n\nTotal registrado: " + gestor.cantidadMaquinas()
            );

            alerta.showAndWait();


        // 8. LIMPIAR EL FORMULARIO

            txtCodigo.clear();
            cmbTipo.getSelectionModel().clearSelection();
            txtHoras.clear();
            txtPotencia.clear();

            txtCodigo.requestFocus();

        });

        // 4. Configuración de la ventana

        stage.setTitle("Sistema de Gestión de Maquinaria");

        stage.setScene(sceneInicio);

        stage.show();

    }

    @Override
    public void stop() throws Exception {
        System.out.println("3. Ejecutando stop()");
    }

    //main + tab
    public static void main(String[] args) {
        launch();
    }


}