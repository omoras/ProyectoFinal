/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author orlan
 */
@Entity
@Table(name = "tokens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tokens.findAll", query = "SELECT t FROM Tokens t"),
    @NamedQuery(name = "Tokens.findByIdtokens", query = "SELECT t FROM Tokens t WHERE t.idtokens = :idtokens"),
    @NamedQuery(name = "Tokens.findByIdUsuario", query = "SELECT t FROM Tokens t WHERE t.idUsuario = :idUsuario")})
public class Tokens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtokens")
    private Integer idtokens;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private int idUsuario;

    public Tokens() {
    }

    public Tokens(Integer idtokens) {
        this.idtokens = idtokens;
    }

    public Tokens(Integer idtokens, String token, int idUsuario) {
        this.idtokens = idtokens;
        this.token = token;
        this.idUsuario = idUsuario;
    }

    public Integer getIdtokens() {
        return idtokens;
    }

    public void setIdtokens(Integer idtokens) {
        this.idtokens = idtokens;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtokens != null ? idtokens.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tokens)) {
            return false;
        }
        Tokens other = (Tokens) object;
        if ((this.idtokens == null && other.idtokens != null) || (this.idtokens != null && !this.idtokens.equals(other.idtokens))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entity.Tokens[ idtokens=" + idtokens + " ]";
    }
    
}
