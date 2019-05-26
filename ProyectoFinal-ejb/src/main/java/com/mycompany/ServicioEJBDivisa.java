/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.ControllerEntity.DivisasJpaController;
import com.mycompany.Entity.Divisas;
import javax.ejb.Stateless;

/**
 *
 * @author orlan
 */
@Stateless
public class ServicioEJBDivisa implements ServicioEJBDivisaLocal {

    @Override
    public void guardarDivisa(Divisas divisa) {
        DivisasJpaController jpa=new DivisasJpaController();
        
    }

    @Override
    public Divisas buscarDivisa(String nombreDivisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
