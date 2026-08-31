/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.germannavarro.system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.germannavarro.system.utils.AlertInformation;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.germannavarro.system.model.User;
import org.germannavarro.system.service.UserService;
import org.germannavarro.system.utils.ViewFactory;

/**
 *
 * @author RM20
 */
public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField pwdPasscode;

    @FXML
    private Button btnLogin;

    @FXML
    private Hyperlink linkRegistro;

    private AlertInformation alert = new AlertInformation();
    private UserService service = new UserService();

    private ViewFactory viewFactory = new ViewFactory();

    @FXML
    private void iniciarSesion(ActionEvent evento) {
        boolean usuarioValido = validarUsuario();
        boolean passcodeValido = validarPasscode();

        if (usuarioValido && passcodeValido) {
            User usuarioEncontrado = service.validacionUser(txtUsuario.getText(), pwdPasscode.getText());

            if (usuarioEncontrado == null) {
                alert.mostrarAlerta("warning", "ADVERTENCIA", "CREDENCIALES INVALIDAS");

            } else {
                alert.mostrarAlerta("confirm", "Inicio de sesion exitoso", "LOGIN");
                viewFactory.viewMenu(usuarioEncontrado);   // <-- navega al menu, DENTRO del else

            }
        }
    }

    private boolean validarUsuario() {
        if (txtUsuario.getText().isEmpty()) {
            alert.mostrarAlerta("error", "HAY CAMPOS VACIOS", "ERROR DE CAMPO");
            txtUsuario.getStyleClass().add("error-campo");
            return false;
        }
        return true;
    }

    public boolean validarPasscode() {
        if (pwdPasscode.getText().isEmpty()) {
            alert.mostrarAlerta("error", "CAMPO VACIO!", "CONTRASEÑA INCORRECTA");
            pwdPasscode.getStyleClass().add("error-campo");
            return false;
        }
        return true;
    }

    @FXML
    private void irARegistro(ActionEvent evento) {
        viewFactory.viewRegistro();
    }

}
