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
@Table(name = "divisas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisas.findAll", query = "SELECT d FROM Divisas d"),
    @NamedQuery(name = "Divisas.findByIdDivisa", query = "SELECT d FROM Divisas d WHERE d.idDivisa = :idDivisa"),
    @NamedQuery(name = "Divisas.findByValorOld", query = "SELECT d FROM Divisas d WHERE d.valorOld = :valorOld"),
    @NamedQuery(name = "Divisas.findByValorNew", query = "SELECT d FROM Divisas d WHERE d.valorNew = :valorNew")})
public class Divisas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDivisa")
    private Integer idDivisa;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorOld")
    private float valorOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorNew")
    private float valorNew;

    public Divisas() {
    }

    public Divisas(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public Divisas(Integer idDivisa, String nombre, float valorOld, float valorNew) {
        this.idDivisa = idDivisa;
        this.nombre = nombre;
        this.valorOld = valorOld;
        this.valorNew = valorNew;
    }

    public Integer getIdDivisa() {
        return idDivisa;
    }

    public void setIdDivisa(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValorOld() {
        return valorOld;
    }

    public void setValorOld(float valorOld) {
        this.valorOld = valorOld;
    }

    public float getValorNew() {
        return valorNew;
    }

    public void setValorNew(float valorNew) {
        this.valorNew = valorNew;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDivisa != null ? idDivisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisas)) {
            return false;
        }
        Divisas other = (Divisas) object;
        if ((this.idDivisa == null && other.idDivisa != null) || (this.idDivisa != null && !this.idDivisa.equals(other.idDivisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entity.Divisas[ idDivisa=" + idDivisa + " ]";
    }
    
}
