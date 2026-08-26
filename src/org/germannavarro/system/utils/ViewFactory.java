/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.germannavarro.system.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import org.germannavarro.system.ClasePrincipal;

/**
 *
 * @author informatica
 */
public class ViewFactory {

    private final String PATH_VIEWS = "/org/germannavarro/system/view/";

    public Scene LoadFileFXML(String nameFXML, int width, int height) {
        String pathOffFile = PATH_VIEWS + nameFXML;
        try {

            //FXMLLoader
            FXMLLoader loaderFXML = new FXMLLoader();
            //Leer URL del archivo
            //Llamada al archivo Main
            URL urFile = ClasePrincipal.class.getResource(pathOffFile);
            loaderFXML.setBuilderFactory(new JavaFXBuilderFactory());
            loaderFXML.setLocation(urFile);

            return new Scene(loaderFXML.load(), width, height);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public FXMLLoader LoadFXML(String nameFXML) {
        String pathOffFile = PATH_VIEWS + nameFXML;

        FXMLLoader loaderFXML = new FXMLLoader();

        URL urFile = ClasePrincipal.class.getResource(pathOffFile);

        loaderFXML.setBuilderFactory(new JavaFXBuilderFactory());

        loaderFXML.setLocation(urFile);
        try {
            loaderFXML.load();
            return loaderFXML;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void loadScene(String nameFXML) {
        Scene scene = null;
        try {
            switch (nameFXML) {
                case "login" -> {
                    SceneManager.getInstanciaScenerManager().getStagePrincipal().setTitle("LOGIN USER");
                    SceneManager.getInstanciaScenerManager().getStagePrincipal().setResizable(false);
                    scene = LoadFileFXML("LoginView.fxml", 400, 500);
                }
                case "registro" -> {
                    SceneManager.getInstanciaScenerManager().getStagePrincipal().setTitle("REGISTRO DE USUARIO");
                    SceneManager.getInstanciaScenerManager().getStagePrincipal().setResizable(false);
                    scene = LoadFileFXML("RegistroView.fxml", 420, 550);
                }
                default ->
                    scene = LoadFileFXML("LoginView.fxml", 400, 500);
            }

            SceneManager.getInstanciaScenerManager().changeScene(scene);

        } catch (NullPointerException objetoNulo) {
            //ALERT
            System.out.println("error load scene");
        }
    }

    public void viewLogin() {
        loadScene("login");
    }

    public void viewRegistro() {
        loadScene("registro");
    }
}
