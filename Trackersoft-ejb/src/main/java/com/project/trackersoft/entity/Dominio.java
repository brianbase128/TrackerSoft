/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.trackersoft.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author I7PRO
 */
@Entity
@Table(name = "DOMINIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dominio.findAll", query = "SELECT d FROM Dominio d")
    , @NamedQuery(name = "Dominio.findByDomId", query = "SELECT d FROM Dominio d WHERE d.domId = :domId")
    , @NamedQuery(name = "Dominio.findByDomCodigo", query = "SELECT d FROM Dominio d WHERE d.domCodigo = :domCodigo")
    , @NamedQuery(name = "Dominio.findByDomDescripcion", query = "SELECT d FROM Dominio d WHERE d.domDescripcion = :domDescripcion")
    , @NamedQuery(name = "Dominio.findByDomEstado", query = "SELECT d FROM Dominio d WHERE d.domEstado = :domEstado")})
public class Dominio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOM_ID")
    private BigDecimal domId;
    @Size(max = 50)
    @Column(name = "DOM_CODIGO")
    private String domCodigo;
    @Size(max = 200)
    @Column(name = "DOM_DESCRIPCION")
    private String domDescripcion;
    @Size(max = 2)
    @Column(name = "DOM_ESTADO")
    private String domEstado;

    public Dominio() {
    }

    public Dominio(BigDecimal domId) {
        this.domId = domId;
    }

    public BigDecimal getDomId() {
        return domId;
    }

    public void setDomId(BigDecimal domId) {
        this.domId = domId;
    }

    public String getDomCodigo() {
        return domCodigo;
    }

    public void setDomCodigo(String domCodigo) {
        this.domCodigo = domCodigo;
    }

    public String getDomDescripcion() {
        return domDescripcion;
    }

    public void setDomDescripcion(String domDescripcion) {
        this.domDescripcion = domDescripcion;
    }

    public String getDomEstado() {
        return domEstado;
    }

    public void setDomEstado(String domEstado) {
        this.domEstado = domEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domId != null ? domId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dominio)) {
            return false;
        }
        Dominio other = (Dominio) object;
        if ((this.domId == null && other.domId != null) || (this.domId != null && !this.domId.equals(other.domId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.Dominio[ domId=" + domId + " ]";
    }
    
}
