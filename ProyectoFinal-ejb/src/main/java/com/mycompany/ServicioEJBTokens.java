/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.ControllerEntity.TokensJpaController;
import com.mycompany.Entity.Tokens;
import com.mycompany.Entity.Usuarios;
import com.mycompany.Utilitarios.Utilitarios;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author orlan
 */
@Stateless
public class ServicioEJBTokens implements ServicioEJBTokensLocal {

    @Override
    public String guardatoken(Usuarios user) {
        try {
            String token = Utilitarios.generarToken(user.getNombre(), user.getEmail());
            TokensJpaController jpa = new TokensJpaController();
            Tokens tok = new Tokens(1, token, user.getIdUsuarios());
            jpa.create(tok);
            return token;
        } catch (Exception ex) {
            Logger.getLogger(ServicioEJBTokens.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

    // Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")

