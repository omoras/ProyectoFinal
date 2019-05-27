/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Logica;

import com.mycompany.ControllerEntity.DivisasJpaController;
import com.mycompany.Entity.Divisas;
import static com.mycompany.Utilitarios.Utilitarios.numeroRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlan
 */
public class CambioDivisa {
    public static Divisas cambioDivisa(Divisas divisa){
        Divisas divisaNew=new Divisas();
        divisaNew.setValorOld(divisa.getValorNew());
        divisaNew.setNombre(divisa.getNombre());
        divisaNew.setValorNew(divisa.getValorNew()+numeroRandom());
        DivisasJpaController jpa=new DivisasJpaController();
        try {
            jpa.create(divisaNew);
        } catch (Exception ex) {
            Logger.getLogger(CambioDivisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return divisaNew;
    }
}
