/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.ControllerEntity.UsuariosJpaController;
import com.mycompany.Entity.Usuarios;
import com.mycompany.Pojo.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author orlan
 */
@Stateless
public class ServicioEJBUsuario implements ServicioEJBUsuarioLocal {

    @Override
    public void guardarUsuario(Usuarios usuarios) {
        UsuariosJpaController jpa =new UsuariosJpaController();
        try{
            System.out.println("Llego a guardar Usuario");
            jpa.create(usuarios);
            //falta buscar para saber el id asignado
            
        } catch (Exception ex) {
            Logger.getLogger(ServicioEJBUsuario.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }

    @Override
    public String logginUser(User user) {
        System.out.println("Llego a logginUser");
        UsuariosJpaController jpa = new UsuariosJpaController();
        Usuarios usuario=jpa.validarUsuario(user);
        if(usuario!=null){
            ServicioEJBTokens servicio=new ServicioEJBTokens();
            String token=servicio.guardatoken(usuario);
            return token;
            
        }else{
            return "Usuario y/o Clave Incorrectos";
        }
    }

    
}
