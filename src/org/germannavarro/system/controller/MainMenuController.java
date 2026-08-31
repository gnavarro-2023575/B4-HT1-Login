package org.germannavarro.system.controller;

import org.germannavarro.system.model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import org.germannavarro.system.utils.ViewFactory;

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

    // Guarda el usuario que inicio sesion, para poder usarlo en cualquier boton
    private User usuarioActual;

    // Se usa para volver al Login al cerrar sesion (misma clase que usa LoginController)
    private final ViewFactory viewFactory = new ViewFactory();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // OJO: aqui YA NO se pone un texto fijo tipo "Usuario Actual".
        // El nombre real se asigna despues, cuando LoginController llama a recibirUsuario().
        mostrarContenido("Bienvenido", "Selecciona una opcion del menu para comenzar.");
    }

    @FXML
    private void handleInicio(ActionEvent event) {
        mostrarContenido("Inicio", "Este es el panel de inicio del sistema.");
    }

    @FXML
    private void handlePerfil(ActionEvent event) {
        String nombreCompleto = usuarioActual != null
                ? usuarioActual.getNombre() + " " + usuarioActual.getApellido()
                : "Usuario";
        mostrarContenido("Perfil", "Datos del usuario: " + nombreCompleto);
    }

    @FXML
    private void handleConfiguracion(ActionEvent event) {
        mostrarContenido("Configuracion", "Aqui podras ajustar las preferencias del sistema.");
    }

    /**
     * ACCION CRITICA: Cerrar Sesion.
     * Regresa a la vista de Login reutilizando el SceneManager/ViewFactory,
     * igual que el resto de la navegacion de la aplicacion (ANTES esto
     * cargaba el FXML "a mano" con una ruta equivocada y nunca funcionaba).
     */
    @FXML
    private void handleCerrarSesion(ActionEvent event) {
        usuarioActual = null;
        viewFactory.viewLogin();
    }

    /**
     * Metodo auxiliar: cambia el contenido del panel central (contentArea)
     * por un titulo + un mensaje. Lo usan los 3 botones de navegacion.
     */
    private void mostrarContenido(String titulo, String mensaje) {
        Label lblTitulo = new Label(titulo);
        lblTitulo.getStyleClass().add("Menu Principal");

        Label lblMensaje = new Label(mensaje);
        lblMensaje.setWrapText(true);

        javafx.scene.layout.VBox contenedor = new javafx.scene.layout.VBox(10, lblTitulo, lblMensaje);
        contenedor.setAlignment(javafx.geometry.Pos.TOP_LEFT);

        contentArea.getChildren().clear();
        contentArea.getChildren().add(contenedor);
    }

    /**
     * Llamado desde ViewFactory.viewMenu() justo despues del login exitoso.
     * Recibe el usuario autenticado y actualiza el label de bienvenida.
     */
    public void recibirUsuario(User usuario) {
        usuarioActual = usuario;

        String nombre = usuario.getNombre() != null ? usuario.getNombre() : "";
        String apellido = usuario.getApellido() != null ? usuario.getApellido() : "";
        String nombreCompleto = (nombre + " " + apellido).trim();

        // Si por alguna razon no llega nombre/apellido, muestra al menos el username
        lblUsuario.setText(nombreCompleto.isEmpty() ? usuario.getNombreUsuario() : nombreCompleto);
    }
}