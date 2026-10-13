
package cl.duoc.gestormaquinaria;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("1. Ejecutando init()");
    }

    @Override
    public void start(Stage stage) throws Exception {

        System.out.println("2. Ejecutando start()");

        // GESTOR DE MAQUINARIAS
        GestorMaquina gestor = new GestorMaquina();


        // ============================================
        // PANTALLA 1: INICIO
        // ============================================

        Label titulo = new Label(
                "Sistema de Gestión de Maquinaria"
        );

        Button btnIngresar = new Button("Ingresar");

        Button btnVerMaquinas = new Button(
                "Ver maquinarias registradas"
        );

        VBox root = new VBox(20);

        root.getChildren().addAll(
                titulo,
                btnIngresar,
                btnVerMaquinas
        );

        root.setAlignment(Pos.CENTER);

        Scene sceneInicio = new Scene(root, 600, 550);


        // ============================================
        // PANTALLA 2: REGISTRO
        // ============================================

        Label tituloRegistro = new Label(
                "Registro de Maquinaria"
        );

        Label lblCodigo = new Label("Código:");

        TextField txtCodigo = new TextField();
        txtCodigo.setPromptText("Ejemplo: EXC-001");
        txtCodigo.setMaxWidth(250);


        Label lblTipo = new Label("Tipo de máquina:");

        ComboBox<String> cmbTipo = new ComboBox<>();

        cmbTipo.getItems().addAll(
                "Excavadora",
                "Cargador Frontal"
        );

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

        Button btnVolver = new Button("Volver al inicio");


        VBox rootRegistro = new VBox(10);

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

        Scene sceneRegistro = new Scene(
                rootRegistro,
                600,
                550
        );


        // ============================================
        // PANTALLA 3: LISTADO DE MAQUINARIAS
        // ============================================

        Label tituloListado = new Label(
                "Maquinarias Registradas"
        );

        // Crear la tabla
        TableView<Maquina> tablaMaquinas = new TableView<>();


        // Crear columnas

        TableColumn<Maquina, String> colCodigo =
                new TableColumn<>("Código");

        TableColumn<Maquina, String> colTipo =
                new TableColumn<>("Tipo");

        TableColumn<Maquina, Integer> colHoras =
                new TableColumn<>("Horas de uso");

        TableColumn<Maquina, Integer> colPotencia =
                new TableColumn<>("Potencia");


        // Vincular columnas con los getters de Maquina

        colCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigo")
        );

        colTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo")
        );

        colHoras.setCellValueFactory(
                new PropertyValueFactory<>("horasUso")
        );

        colPotencia.setCellValueFactory(
                new PropertyValueFactory<>("potencia")
        );


        // Agregar columnas a la tabla

        tablaMaquinas.getColumns().addAll(
                colCodigo,
                colTipo,
                colHoras,
                colPotencia
        );

        tablaMaquinas.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );


        // Botón para volver

        Button btnVolverListado = new Button(
                "Volver al inicio"
        );


        // Diseño de la pantalla de listado

        VBox rootListado = new VBox(15);

        rootListado.getChildren().addAll(
                tituloListado,
                tablaMaquinas,
                btnVolverListado
        );

        rootListado.setAlignment(Pos.CENTER);
        rootListado.setStyle("-fx-padding: 20;");


        // Crear tercera escena

        Scene sceneListado = new Scene(
                rootListado,
                750,
                550
        );


        // ============================================
        // EVENTOS DE NAVEGACIÓN
        // ============================================

        // Ir desde inicio al formulario

        btnIngresar.setOnAction(event -> {

            stage.setScene(sceneRegistro);

        });


        // Volver desde registro al inicio

        btnVolver.setOnAction(event -> {

            stage.setScene(sceneInicio);

        });


        // Ver maquinarias registradas

        btnVerMaquinas.setOnAction(event -> {

            tablaMaquinas.setItems(
                    FXCollections.observableArrayList(
                            gestor.listarMaquinas()
                    )
            );

            stage.setScene(sceneListado);

        });


        // Volver desde listado al inicio

        btnVolverListado.setOnAction(event -> {

            stage.setScene(sceneInicio);

        });


        // ============================================
        // EVENTO GUARDAR MAQUINARIA
        // ============================================

        btnGuardar.setOnAction(event -> {

            // 1. VALIDAR CÓDIGO

            String codigo = txtCodigo.getText().trim();

            if (codigo.isEmpty()) {

                Alert alerta = new Alert(
                        Alert.AlertType.ERROR
                );

                alerta.setTitle("Error de validación");
                alerta.setHeaderText("Código obligatorio");
                alerta.setContentText(
                        "Debe ingresar el código de la maquinaria."
                );

                alerta.showAndWait();
                return;
            }


            // 2. VALIDAR TIPO

            String tipo = cmbTipo.getValue();

            if (tipo == null) {

                Alert alerta = new Alert(
                        Alert.AlertType.ERROR
                );

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

                Alert alerta = new Alert(
                        Alert.AlertType.ERROR
                );

                alerta.setTitle("Error de validación");
                alerta.setHeaderText("Horas incorrectas");
                alerta.setContentText(
                        "Las horas de uso deben ser un número entero."
                );

                alerta.showAndWait();
                return;
            }


            if (horas < 0) {

                Alert alerta = new Alert(
                        Alert.AlertType.ERROR
                );

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

                Alert alerta = new Alert(
                        Alert.AlertType.ERROR
                );

                alerta.setTitle("Error de validación");
                alerta.setHeaderText("Potencia incorrecta");
                alerta.setContentText(
                        "La potencia debe ser un número entero."
                );

                alerta.showAndWait();
                return;
            }


            if (potencia <= 0) {

                Alert alerta = new Alert(
                        Alert.AlertType.ERROR
                );

                alerta.setTitle("Error de validación");
                alerta.setHeaderText("Potencia incorrecta");
                alerta.setContentText(
                        "La potencia debe ser mayor que cero."
                );

                alerta.showAndWait();
                return;
            }


            // 5. CREAR OBJETO MAQUINA

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

                Alert alerta = new Alert(
                        Alert.AlertType.ERROR
                );

                alerta.setTitle("Error");
                alerta.setHeaderText("Tipo no reconocido");
                alerta.setContentText(
                        "Seleccione un tipo de maquinaria válido."
                );

                alerta.showAndWait();
                return;
            }


            // 6. REGISTRAR EN EL GESTOR

            boolean registrado =
                    gestor.agregarMaquina(nuevaMaquina);


            if (!registrado) {

                Alert alerta = new Alert(
                        Alert.AlertType.ERROR
                );

                alerta.setTitle("Registro rechazado");
                alerta.setHeaderText("Código duplicado");
                alerta.setContentText(
                        "Ya existe una maquinaria con el código: "
                                + codigo
                );

                alerta.showAndWait();
                return;
            }


            // 7. MOSTRAR CONFIRMACIÓN

            Alert alerta = new Alert(
                    Alert.AlertType.INFORMATION
            );

            alerta.setTitle("Registro correcto");
            alerta.setHeaderText("Maquinaria registrada");

            alerta.setContentText(
                    "Código: " + nuevaMaquina.getCodigo() +
                            "\nTipo: " + nuevaMaquina.getTipo() +
                            "\nHoras de uso: " + nuevaMaquina.getHorasUso() +
                            "\nPotencia: " + nuevaMaquina.getPotencia() +
                            "\n\nTotal registrado: "
                            + gestor.cantidadMaquinas()
            );

            alerta.showAndWait();


            // 8. LIMPIAR FORMULARIO

            txtCodigo.clear();

            cmbTipo.getSelectionModel().clearSelection();

            txtHoras.clear();

            txtPotencia.clear();

            txtCodigo.requestFocus();

        });


        // ============================================
        // CONFIGURACIÓN DE LA VENTANA PRINCIPAL
        // ============================================

        stage.setTitle("Sistema de Gestión de Maquinaria");

        stage.setScene(sceneInicio);

        stage.show();

    }


    @Override
    public void stop() throws Exception {

        System.out.println("3. Ejecutando stop()");

    }


    public static void main(String[] args) {

        launch();

    }
}
