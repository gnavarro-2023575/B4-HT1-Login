/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.germannavarro.system.utils;

import javafx.scene.control.Alert;

/**
 *
 * @author RM20
 */
public class AlertInformation {
    
    public AlertInformation() {
    }

    public void mostrarAlerta(String tipoAlert, String mensaje, String titulo) {
        Alert.AlertType tipo = switch (tipoAlert) {
            case "error" ->
                Alert.AlertType.ERROR;
            case "confirm" ->
                Alert.AlertType.CONFIRMATION;
            case "info" ->
                Alert.AlertType.INFORMATION;
            case "warning" ->
                Alert.AlertType.WARNING;

            default ->
                Alert.AlertType.NONE;
        };

        Alert Alerta = new Alert(tipo);
        
        Alerta.setContentText(mensaje);
        Alerta.setHeaderText(titulo);
        Alerta.showAndWait();
    }
    
}
