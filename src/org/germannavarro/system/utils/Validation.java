/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.germannavarro.system.utils;

/**
 *
 * @author informatica
 */
public class Validation {
    
    public Validation(){}
    
    public Boolean equalsText(String textoOriginal, String textCompare){
        
        return textoOriginal.equals(textCompare);
    }
    
    public Boolean validateLenghtText (String text, int lengthMax){
        return text.length() <= lengthMax;
    }
    
    public Boolean validateEmail(String email){
        
    }
}
