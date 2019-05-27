/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Utilitarios;

/**
 *
 * @author orlan
 */
public class Utilitarios {
    public static float numeroRandom() {
        int numero = (int) (Math.random() * 50) + 1;
        float random = 0;
        if (numero <=25) {
            random = (float) (Math.random() * 0.3)*-1;
        } else {
            random = (float) (Math.random() * 0.3);
        }
        return random;
    }
}
