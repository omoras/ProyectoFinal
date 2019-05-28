/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Utilitarios;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

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
    
    public static String generarToken(String user, String correo) {
        String token = Jwts.builder().setSubject(user+ Long.toString(System.currentTimeMillis()))                                    
                                    .setIssuer(correo)
                                    .setExpiration(new Date(2018,1,1))
                                    .signWith(SignatureAlgorithm.HS512, "oEYRRobl6O").compact();
        
        //if it has been specified, let's add the expiration
        return token;
    }
    
    public static void imprimirEstructura(String token){
        Jws parseoClaseJws=Jwts.parser().setSigningKey("oEYRRobl6O").parseClaimsJws(token);
        
        System.out.println("Header: " + parseoClaseJws.getHeader());
        System.out.println("Body: " + parseoClaseJws.getBody());
        System.out.println("Signature: " + parseoClaseJws.getSignature());
    }
    
    public static void imprimirBody(String token){
        
        Claims body=Jwts.parser().setSigningKey("oEYRRobl6O").parseClaimsJws(token).getBody();
        
        System.out.println("Issuer: " + body.getIssuer());
        System.out.println("Subject: " + body.getSubject());
        System.out.println("Expiracion: " + body.getExpiration());
    }
}


