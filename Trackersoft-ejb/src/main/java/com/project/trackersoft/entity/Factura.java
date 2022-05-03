/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.trackersoft.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author I7PRO
 */
@Entity
@Table(name = "FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByFacId", query = "SELECT f FROM Factura f WHERE f.facId = :facId")
    , @NamedQuery(name = "Factura.findByFacCodigo", query = "SELECT f FROM Factura f WHERE f.facCodigo = :facCodigo")
    , @NamedQuery(name = "Factura.findByFacFechaCreacion", query = "SELECT f FROM Factura f WHERE f.facFechaCreacion = :facFechaCreacion")
    , @NamedQuery(name = "Factura.findByFacFechaVencimiento", query = "SELECT f FROM Factura f WHERE f.facFechaVencimiento = :facFechaVencimiento")
    , @NamedQuery(name = "Factura.findByFacValor", query = "SELECT f FROM Factura f WHERE f.facValor = :facValor")
    , @NamedQuery(name = "Factura.findByFacEstado", query = "SELECT f FROM Factura f WHERE f.facEstado = :facEstado")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_ID")
    private BigDecimal facId;
    @Size(max = 12)
    @Column(name = "FAC_CODIGO")
    private String facCodigo;
    @Column(name = "FAC_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date facFechaCreacion;
    @Column(name = "FAC_FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date facFechaVencimiento;
    @Column(name = "FAC_VALOR")
    private BigDecimal facValor;
    @Size(max = 25)
    @Column(name = "FAC_ESTADO")
    private String facEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facId")
    private Collection<Actividad> actividadCollection;

    public Factura() {
    }

    public Factura(BigDecimal facId) {
        this.facId = facId;
    }

    public BigDecimal getFacId() {
        return facId;
    }

    public void setFacId(BigDecimal facId) {
        this.facId = facId;
    }

    public String getFacCodigo() {
        return facCodigo;
    }

    public void setFacCodigo(String facCodigo) {
        this.facCodigo = facCodigo;
    }

    public Date getFacFechaCreacion() {
        return facFechaCreacion;
    }

    public void setFacFechaCreacion(Date facFechaCreacion) {
        this.facFechaCreacion = facFechaCreacion;
    }

    public Date getFacFechaVencimiento() {
        return facFechaVencimiento;
    }

    public void setFacFechaVencimiento(Date facFechaVencimiento) {
        this.facFechaVencimiento = facFechaVencimiento;
    }

    public BigDecimal getFacValor() {
        return facValor;
    }

    public void setFacValor(BigDecimal facValor) {
        this.facValor = facValor;
    }

    public String getFacEstado() {
        return facEstado;
    }

    public void setFacEstado(String facEstado) {
        this.facEstado = facEstado;
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
        hash += (facId != null ? facId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facId == null && other.facId != null) || (this.facId != null && !this.facId.equals(other.facId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.Factura[ facId=" + facId + " ]";
    }
    
}
