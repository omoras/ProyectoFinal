/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.Entity.Usuarios;
import com.mycompany.Pojo.User;
import javax.ejb.Local;

/**
 *
 * @author orlan
 */
@Local
public interface ServicioEJBUsuarioLocal {
    public void guardarUsuario(Usuarios usuarios);
    public String logginUser(User user);
}
