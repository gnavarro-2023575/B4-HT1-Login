/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.germannavarro.system.utils;

/**
 *
 * @author informatica
 */
public class Validations {
    
    public static Boolean validateLenghtText(String text, int lengthMax) {
        return text.length() <= lengthMax;
    }

    public static Boolean validateEmail(String email) {
        String regexEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(regexEmail);
    }
}
