/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.trackersoft.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author I7PRO
 */
@Entity
@Table(name = "PROVISION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provision.findAll", query = "SELECT p FROM Provision p")
    , @NamedQuery(name = "Provision.findByProvId", query = "SELECT p FROM Provision p WHERE p.provId = :provId")
    , @NamedQuery(name = "Provision.findByProvPeriodo", query = "SELECT p FROM Provision p WHERE p.provPeriodo = :provPeriodo")
    , @NamedQuery(name = "Provision.findByProvValor", query = "SELECT p FROM Provision p WHERE p.provValor = :provValor")
    , @NamedQuery(name = "Provision.findByProvEstado", query = "SELECT p FROM Provision p WHERE p.provEstado = :provEstado")})
public class Provision implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="SEQ_PROV", sequenceName="SEQ_PROV_ID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQ_PROV")
    @Column(name = "PROV_ID")
    private BigDecimal provId;
    @Size(max = 8)
    @Column(name = "PROV_PERIODO")
    private String provPeriodo;
    @Column(name = "PROV_VALOR")
    private BigDecimal provValor;
    @Size(max = 25)
    @Column(name = "PROV_ESTADO")
    private String provEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provId")
    private Collection<Actividad> actividadCollection;

    public Provision() {
    }

    public Provision(BigDecimal provId) {
        this.provId = provId;
    }

    public BigDecimal getProvId() {
        return provId;
    }

    public void setProvId(BigDecimal provId) {
        this.provId = provId;
    }

    public String getProvPeriodo() {
        return provPeriodo;
    }

    public void setProvPeriodo(String provPeriodo) {
        this.provPeriodo = provPeriodo;
    }

    public BigDecimal getProvValor() {
        return provValor;
    }

    public void setProvValor(BigDecimal provValor) {
        this.provValor = provValor;
    }

    public String getProvEstado() {
        return provEstado;
    }

    public void setProvEstado(String provEstado) {
        this.provEstado = provEstado;
    }

    @XmlTransient
    public Collection<Actividad> getActividadCollection() {
        return actividadCollection;
    }

    public void setActividadCollection(Collection<Actividad> actividadCollection) {
        this.actividadCollection = actividadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provId != null ? provId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provision)) {
            return false;
        }
        Provision other = (Provision) object;
        if ((this.provId == null && other.provId != null) || (this.provId != null && !this.provId.equals(other.provId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.Provision[ provId=" + provId + " ]";
    }
    
}
