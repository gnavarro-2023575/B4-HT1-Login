package org.germannavarro.system.controller;

import org.germannavarro.system.model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.germannavarro.system.model.User;

/**
 * Controlador de la vista principal (MainMenuView.fxml).
 */
public class MainMenuController implements Initializable {

    @FXML
    private Label lblUsuario;

    @FXML
    private Button btnInicio;

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnConfiguracion;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private StackPane contentArea;

    private User usuarioActual;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Inicialización de la interfaz
        lblUsuario.setText("Usuario Actual");
    }

    @FXML
    private void handleInicio(ActionEvent event) {
        System.out.println("Navegando a Inicio...");
        // Cargar vista en el área central: cargarVista("/views/InicioView.fxml");
    }

    @FXML
    private void handlePerfil(ActionEvent event) {
        System.out.println("Navegando a Perfil...");
        // Cargar vista en el área central: cargarVista("/views/PerfilView.fxml");
    }

    @FXML
    private void handleConfiguracion(ActionEvent event) {
        System.out.println("Navegando a Configuración...");
        // Cargar vista en el área central: cargarVista("/views/ConfiguracionView.fxml");
    }

    /**
     * ACCIÓN CRÍTICA: Cerrar Sesión Destruye/reemplaza la escena actual y
     * regresa al LoginView.fxml.
     */
    @FXML
    private void handleCerrarSesion(ActionEvent event) {
        try {
            // 1. Cargar el FXML del Login (Asegúrate de que la ruta sea correcta según tu paquete)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginView.fxml"));
            Parent loginRoot = loader.load();

            // 2. Obtener el Stage (Ventana) actual mediante el evento del botón
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // 3. Crear la nueva escena de Login
            Scene loginScene = new Scene(loginRoot);

            // 4. Asignar la escena y actualizar la ventana (Destruyendo la vista del menú)
            currentStage.setScene(loginScene);
            currentStage.setTitle("Iniciar Sesión");
            currentStage.centerOnScreen();
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Error al cargar la vista de Login: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método auxiliar para cargar vistas dinámicas dentro del contenedor
     * central.
     */
    private void cargarVista(String fxmlPath) {
        try {
            Parent vista = FXMLLoader.load(getClass().getResource(fxmlPath));
            contentArea.getChildren().clear();
            contentArea.getChildren().add(vista);
        } catch (IOException e) {
            System.err.println("Error al cargar la vista central: " + fxmlPath);
            e.printStackTrace();
        }
    }

    public void recibirUsuario(User usuario) {
        usuarioActual = usuario;

        lblUsuario.setText(usuarioActual.getNombre() + " " + usuarioActual.getApellido());

    }
}
