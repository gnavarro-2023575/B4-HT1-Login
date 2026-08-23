/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.germannavarro.system;

import javafx.application.Application;
import javafx.stage.Stage;
import org.germannavarro.system.utils.SceneManager;
import org.germannavarro.system.utils.ViewFactory;

public class ClasePrincipal extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stageRoot){
        SceneManager.getInstanciaScenerManager().setStagePrincipal(stageRoot);
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }
    
}