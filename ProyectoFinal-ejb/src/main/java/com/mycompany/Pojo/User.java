/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Pojo;

/**
 *
 * @author orlan
 */
public class User {
    private String user,pass;

    public User() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
}
