/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.trackersoft.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author I7PRO
 */
@Entity
@Table(name = "CENTRO_COSTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroCosto.findAll", query = "SELECT c FROM CentroCosto c")
    , @NamedQuery(name = "CentroCosto.findByCcostId", query = "SELECT c FROM CentroCosto c WHERE c.ccostId = :ccostId")
    , @NamedQuery(name = "CentroCosto.findByCcostNombre", query = "SELECT c FROM CentroCosto c WHERE c.ccostNombre = :ccostNombre")
    , @NamedQuery(name = "CentroCosto.findByCcostDescripcion", query = "SELECT c FROM CentroCosto c WHERE c.ccostDescripcion = :ccostDescripcion")
    , @NamedQuery(name = "CentroCosto.findByCcostUsuarioCreacion", query = "SELECT c FROM CentroCosto c WHERE c.ccostUsuarioCreacion = :ccostUsuarioCreacion")
    , @NamedQuery(name = "CentroCosto.findByCcostFechaCreacion", query = "SELECT c FROM CentroCosto c WHERE c.ccostFechaCreacion = :ccostFechaCreacion")
    , @NamedQuery(name = "CentroCosto.findByCcostUsuarioModificacion", query = "SELECT c FROM CentroCosto c WHERE c.ccostUsuarioModificacion = :ccostUsuarioModificacion")
    , @NamedQuery(name = "CentroCosto.findByCcostFechaModificacion", query = "SELECT c FROM CentroCosto c WHERE c.ccostFechaModificacion = :ccostFechaModificacion")
    , @NamedQuery(name = "CentroCosto.findByCcostEstado", query = "SELECT c FROM CentroCosto c WHERE c.ccostEstado = :ccostEstado")})
public class CentroCosto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="SEQ_CC", sequenceName="SEQ_CCOST_ID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQ_CC")
    @Column(name = "CCOST_ID")
    private BigDecimal ccostId;
    @Size(max = 100)
    @Column(name = "CCOST_NOMBRE")
    private String ccostNombre;
    @Size(max = 250)
    @Column(name = "CCOST_DESCRIPCION")
    private String ccostDescripcion;
    @Column(name = "CCOST_USUARIO_CREACION")
    private BigInteger ccostUsuarioCreacion;
    @Column(name = "CCOST_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccostFechaCreacion;
    @Column(name = "CCOST_USUARIO_MODIFICACION")
    private BigInteger ccostUsuarioModificacion;
    @Column(name = "CCOST_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccostFechaModificacion;
    @Size(max = 1)
    @Column(name = "CCOST_ESTADO")
    private String ccostEstado;
    

    public CentroCosto() {
    }

    public CentroCosto(BigDecimal ccostId) {
        this.ccostId = ccostId;
    }

    public CentroCosto(BigDecimal ccostId, BigInteger proyId) {
        this.ccostId = ccostId;
      
    }

    public BigDecimal getCcostId() {
        return ccostId;
    }

    public void setCcostId(BigDecimal ccostId) {
        this.ccostId = ccostId;
    }

    public String getCcostNombre() {
        return ccostNombre;
    }

    public void setCcostNombre(String ccostNombre) {
        this.ccostNombre = ccostNombre;
    }

    public String getCcostDescripcion() {
        return ccostDescripcion;
    }

    public void setCcostDescripcion(String ccostDescripcion) {
        this.ccostDescripcion = ccostDescripcion;
    }

    public BigInteger getCcostUsuarioCreacion() {
        return ccostUsuarioCreacion;
    }

    public void setCcostUsuarioCreacion(BigInteger ccostUsuarioCreacion) {
        this.ccostUsuarioCreacion = ccostUsuarioCreacion;
    }

    public Date getCcostFechaCreacion() {
        return ccostFechaCreacion;
    }

    public void setCcostFechaCreacion(Date ccostFechaCreacion) {
        this.ccostFechaCreacion = ccostFechaCreacion;
    }

    public BigInteger getCcostUsuarioModificacion() {
        return ccostUsuarioModificacion;
    }

    public void setCcostUsuarioModificacion(BigInteger ccostUsuarioModificacion) {
        this.ccostUsuarioModificacion = ccostUsuarioModificacion;
    }

    public Date getCcostFechaModificacion() {
        return ccostFechaModificacion;
    }

    public void setCcostFechaModificacion(Date ccostFechaModificacion) {
        this.ccostFechaModificacion = ccostFechaModificacion;
    }

    public String getCcostEstado() {
        return ccostEstado;
    }

    public void setCcostEstado(String ccostEstado) {
        this.ccostEstado = ccostEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccostId != null ? ccostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroCosto)) {
            return false;
        }
        CentroCosto other = (CentroCosto) object;
        if ((this.ccostId == null && other.ccostId != null) || (this.ccostId != null && !this.ccostId.equals(other.ccostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.CentroCosto[ ccostId=" + ccostId + " ]";
    }
    
}
