/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.trackersoft.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "TARIFA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifa.findAll", query = "SELECT t FROM Tarifa t")
    , @NamedQuery(name = "Tarifa.findByTarId", query = "SELECT t FROM Tarifa t WHERE t.tarId = :tarId")
    , @NamedQuery(name = "Tarifa.findByTarNombre", query = "SELECT t FROM Tarifa t WHERE t.tarNombre = :tarNombre")
    , @NamedQuery(name = "Tarifa.findByTarTipo", query = "SELECT t FROM Tarifa t WHERE t.tarTipo = :tarTipo")
    , @NamedQuery(name = "Tarifa.findByTarValor", query = "SELECT t FROM Tarifa t WHERE t.tarValor = :tarValor")
    , @NamedQuery(name = "Tarifa.findByTarFechaInicio", query = "SELECT t FROM Tarifa t WHERE t.tarFechaInicio = :tarFechaInicio")
    , @NamedQuery(name = "Tarifa.findByTarFechaFin", query = "SELECT t FROM Tarifa t WHERE t.tarFechaFin = :tarFechaFin")
    , @NamedQuery(name = "Tarifa.findByTarUsuarioCreacion", query = "SELECT t FROM Tarifa t WHERE t.tarUsuarioCreacion = :tarUsuarioCreacion")
    , @NamedQuery(name = "Tarifa.findByTarFechaCreacion", query = "SELECT t FROM Tarifa t WHERE t.tarFechaCreacion = :tarFechaCreacion")
    , @NamedQuery(name = "Tarifa.findByTarUsuarioModificacion", query = "SELECT t FROM Tarifa t WHERE t.tarUsuarioModificacion = :tarUsuarioModificacion")
    , @NamedQuery(name = "Tarifa.findByTarFechaModificacion", query = "SELECT t FROM Tarifa t WHERE t.tarFechaModificacion = :tarFechaModificacion")
    , @NamedQuery(name = "Tarifa.findByTarEstado", query = "SELECT t FROM Tarifa t WHERE t.tarEstado = :tarEstado")})
public class Tarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="SEQ_TARI", sequenceName="SEQ_TARI_ID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQ_TARI")
    @Column(name = "TAR_ID")
    private BigDecimal tarId;
    @Size(max = 50)
    @Column(name = "TAR_NOMBRE")
    private String tarNombre;
    @Size(max = 25)
    @Column(name = "TAR_TIPO")
    private String tarTipo;
    @Column(name = "TAR_VALOR")
    private BigDecimal tarValor;
    @Column(name = "TAR_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarFechaInicio;
    @Column(name = "TAR_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarFechaFin;
    @Column(name = "TAR_USUARIO_CREACION")
    private BigInteger tarUsuarioCreacion;
    @Column(name = "TAR_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarFechaCreacion;
    @Column(name = "TAR_USUARIO_MODIFICACION")
    private BigInteger tarUsuarioModificacion;
    @Column(name = "TAR_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarFechaModificacion;
    @Column(name = "TAR_ESTADO")
    private String tarEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarId")
    private Collection<Actividad> actividadCollection;

    public Tarifa() {
    }

    public Tarifa(BigDecimal tarId) {
        this.tarId = tarId;
    }

    public BigDecimal getTarId() {
        return tarId;
    }

    public void setTarId(BigDecimal tarId) {
        this.tarId = tarId;
    }

    public String getTarNombre() {
        return tarNombre;
    }

    public void setTarNombre(String tarNombre) {
        this.tarNombre = tarNombre;
    }

    public String getTarTipo() {
        return tarTipo;
    }

    public void setTarTipo(String tarTipo) {
        this.tarTipo = tarTipo;
    }

    public BigDecimal getTarValor() {
        return tarValor;
    }

    public void setTarValor(BigDecimal tarValor) {
        this.tarValor = tarValor;
    }

    public Date getTarFechaInicio() {
        return tarFechaInicio;
    }

    public void setTarFechaInicio(Date tarFechaInicio) {
        this.tarFechaInicio = tarFechaInicio;
    }

    public Date getTarFechaFin() {
        return tarFechaFin;
    }

    public void setTarFechaFin(Date tarFechaFin) {
        this.tarFechaFin = tarFechaFin;
    }

    public BigInteger getTarUsuarioCreacion() {
        return tarUsuarioCreacion;
    }

    public void setTarUsuarioCreacion(BigInteger tarUsuarioCreacion) {
        this.tarUsuarioCreacion = tarUsuarioCreacion;
    }

    public Date getTarFechaCreacion() {
        return tarFechaCreacion;
    }

    public void setTarFechaCreacion(Date tarFechaCreacion) {
        this.tarFechaCreacion = tarFechaCreacion;
    }

    public BigInteger getTarUsuarioModificacion() {
        return tarUsuarioModificacion;
    }

    public void setTarUsuarioModificacion(BigInteger tarUsuarioModificacion) {
        this.tarUsuarioModificacion = tarUsuarioModificacion;
    }

    public Date getTarFechaModificacion() {
        return tarFechaModificacion;
    }

    public void setTarFechaModificacion(Date tarFechaModificacion) {
        this.tarFechaModificacion = tarFechaModificacion;
    }

    public String getTarEstado() {
        return tarEstado;
    }

    public void setTarEstado(String tarEstado) {
        this.tarEstado = tarEstado;
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
        hash += (tarId != null ? tarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifa)) {
            return false;
        }
        Tarifa other = (Tarifa) object;
        if ((this.tarId == null && other.tarId != null) || (this.tarId != null && !this.tarId.equals(other.tarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.Tarifa[ tarId=" + tarId + " ]";
    }
    
}
