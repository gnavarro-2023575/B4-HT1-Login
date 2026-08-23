/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.germannavarro.system.service;

import org.germannavarro.system.model.User;
import org.germannavarro.system.repository.UserRepository;
import org.germannavarro.system.utils.AlertInformation;

/**
 *
 * @author RM20
 */
public class UserService {
    
    private AlertInformation alert = new AlertInformation();
    private UserRepository userRepository = new UserRepository();

    public User validacionUser(String nombreUsuario, String passcode) {
        User usuarioEncontrado = userRepository.busquedaUser(nombreUsuario);
        
        if (usuarioEncontrado == null){
            return null;
        }
        if (!passcode.equals(usuarioEncontrado.getPasscode())) {
            return  null;
        }
        return usuarioEncontrado;

    }
    
    public boolean registrarUsuario(String nombre, String apellido, String email, String username, String password){
        
        User nuevoUsuario = new User();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setNombreUsuario(username);
        nuevoUsuario.setPasscode(password);

        return userRepository.crearUsuario(nuevoUsuario);
    }

}
