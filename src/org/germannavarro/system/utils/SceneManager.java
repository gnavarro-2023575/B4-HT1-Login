/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.germannavarro.system.utils;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author informatica
 */
public class SceneManager {
    
    private static SceneManager instanciaSceneManager;
    private Stage stagePrincipal;
    
    private SceneManager(){
    
    }
    
    public static SceneManager getInstanciaScenerManager(){
        if( instanciaSceneManager == null)
            instanciaSceneManager = new SceneManager();
        return instanciaSceneManager;
    }
    
    /**
     * Este metodo nos permite recibir un parametro de tipo Scene y
     * es la escena que se mostrara en el Stage
     * @param scene 
     */
    
    public void changeScene(Scene scene){
        try {
            stagePrincipal.setScene(scene);
            stagePrincipal.sizeToScene();
            stagePrincipal.show();
            
        } catch (NullPointerException objetoNulo) {
            //ALERT
        }
    }

    public Stage getStagePrincipal() {
        return stagePrincipal;
    }

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }
    
}
