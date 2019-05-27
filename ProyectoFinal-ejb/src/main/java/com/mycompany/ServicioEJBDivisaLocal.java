/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.Entity.Divisas;
import javax.ejb.Local;

/**
 *
 * @author orlan
 */
@Local
public interface ServicioEJBDivisaLocal {
    public void guardarDivisa(Divisas divisa);
    public Divisas buscarDivisa();
}
