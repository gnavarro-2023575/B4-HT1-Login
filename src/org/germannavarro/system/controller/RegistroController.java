package org.germannavarro.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.germannavarro.system.service.UserService;
import org.germannavarro.system.utils.AlertInformation;
import org.germannavarro.system.utils.SceneManager;
import org.germannavarro.system.utils.Validations;
import org.germannavarro.system.utils.ViewFactory;

public class RegistroController implements Initializable {

    private ViewFactory viewFactory = new ViewFactory();

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField pwdPassword;

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnVolver;

    private UserService userService;
    private AlertInformation alert;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.userService = new UserService();
        this.alert = new AlertInformation();
    }

    @FXML
    private void handleGuardar(ActionEvent event) {
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String email = txtEmail.getText().trim();
        String user = txtUser.getText().trim();
        String password = pwdPassword.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || user.isEmpty() || password.isEmpty()) {
            alert.mostrarAlerta("warning", "Campos Incompletos", "Por favor llena todos los campos antes de continuar.");
            return;
        }

        if (!Validations.validateLenghtText(nombre, 50)) {
            alert.mostrarAlerta("error", "Nombre muy largo", "El nombre no puede exceder 50 caracteres.");
            return;
        }

        if (!Validations.validateLenghtText(apellido, 50)) {
            alert.mostrarAlerta("error", "Apellido muy largo", "El apellido no puede exceder 50 caracteres.");
            return;
        }

        if (!Validations.validateLenghtText(email, 50)) {
            alert.mostrarAlerta("error", "Email muy largo", "El email no puede exceder 50 caracteres.");
            return;
        }

        //Validacion del email: caracteres
        if (!Validations.validateEmail(email)) {
            alert.mostrarAlerta("error", "Email mal ingresado", "El email debe de contener los caracteres: @, . ");
            return;
        }

        if (!Validations.validateLenghtText(user, 25)) {
            alert.mostrarAlerta("error", "User muy largo", "El user no puede exceder 25 caracteres.");
            return;
        }

        if (!Validations.validateLenghtText(password, 35)) {
            alert.mostrarAlerta("error", "Password muy largo", "El password no puede exceder 35 caracteres.");
            return;
        }

        boolean exito = userService.registrarUsuario(nombre, apellido, email, user, password);

        if (exito) {
            alert.mostrarAlerta("info", "Registro Exitoso", "El usuario ha sido registrado correctamente.");
            // Código para cambiar a la vista de Login
            viewFactory.viewLogin();
        } else {
            alert.mostrarAlerta("error", "Error de Registro", "No se pudo registrar el usuario en la base de datos.");
        }

    }

    @FXML
    private void handleVolver(ActionEvent event) {
        viewFactory.viewLogin();
    }
}
