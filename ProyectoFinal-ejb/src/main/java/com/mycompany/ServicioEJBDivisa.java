/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.ControllerEntity.DivisasJpaController;
import com.mycompany.Entity.Divisas;
import com.mycompany.Logica.CambioDivisa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author orlan
 */
@Stateless
public class ServicioEJBDivisa implements ServicioEJBDivisaLocal {

    @Override
    public void guardarDivisa(Divisas divisa) {
        DivisasJpaController jpa = new DivisasJpaController();
        try {
            jpa.create(divisa);
        } catch (Exception ex) {
            Logger.getLogger(ServicioEJBDivisa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Divisas buscarDivisa(String nombreDivisa) {
        System.out.println("Llego a buscarDivisa Interfaz");
        DivisasJpaController jpa = new DivisasJpaController();
        Divisas div;
        div = jpa.busacaDivisasNombre(nombreDivisa);
        System.out.println(div.getNombre());
    //Busqueda
        div = CambioDivisa.cambioDivisa(div);
        return div;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
