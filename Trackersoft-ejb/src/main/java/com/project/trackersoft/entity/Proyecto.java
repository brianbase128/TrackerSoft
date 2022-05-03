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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByProyId", query = "SELECT p FROM Proyecto p WHERE p.proyId = :proyId")
    , @NamedQuery(name = "Proyecto.findByProyNombre", query = "SELECT p FROM Proyecto p WHERE p.proyNombre = :proyNombre")
    , @NamedQuery(name = "Proyecto.findByProyDescripcion", query = "SELECT p FROM Proyecto p WHERE p.proyDescripcion = :proyDescripcion")
    , @NamedQuery(name = "Proyecto.findByProyUsuarioCreacion", query = "SELECT p FROM Proyecto p WHERE p.proyUsuarioCreacion = :proyUsuarioCreacion")
    , @NamedQuery(name = "Proyecto.findByProyFechaCreacion", query = "SELECT p FROM Proyecto p WHERE p.proyFechaCreacion = :proyFechaCreacion")
    , @NamedQuery(name = "Proyecto.findByProyUsuarioModificacion", query = "SELECT p FROM Proyecto p WHERE p.proyUsuarioModificacion = :proyUsuarioModificacion")
    , @NamedQuery(name = "Proyecto.findByFechaModificacion", query = "SELECT p FROM Proyecto p WHERE p.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Proyecto.findByProyEstado", query = "SELECT p FROM Proyecto p WHERE p.proyEstado = :proyEstado")
    , @NamedQuery(name = "Proyecto.findByProyResponsable", query = "SELECT p FROM Proyecto p WHERE p.proyResponsable = :proyResponsable")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="SEQ_PROY", sequenceName="SEQ_PROY_ID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQ_PROY")
    @Column(name = "PROY_ID")
    private BigDecimal proyId;
    @Size(max = 100)
    @Column(name = "PROY_NOMBRE")
    private String proyNombre;
    @Size(max = 250)
    @Column(name = "PROY_DESCRIPCION")
    private String proyDescripcion;
    @Column(name = "PROY_USUARIO_CREACION")
    private BigInteger proyUsuarioCreacion;
    @Column(name = "PROY_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proyFechaCreacion;
    @Column(name = "PROY_USUARIO_MODIFICACION")
    private BigInteger proyUsuarioModificacion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 1)
    @Column(name = "PROY_ESTADO")
    private String proyEstado;
    @Column(name = "PROY_RESPONSABLE")
    private String proyResponsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyId")
    private Collection<Actividad> actividadCollection;
    @JoinColumn(name = "CCOST_ID", referencedColumnName = "CCOST_ID")
    @ManyToOne(optional = false)
    private CentroCosto ccostId;
    @JoinColumn(name = "CLI_ID", referencedColumnName = "CLI_ID")
    @ManyToOne(optional = false)
    private Cliente cliId;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(optional = false)
    private Usuario usuId;

    public Proyecto() {
    }

    public Proyecto(BigDecimal proyId) {
        this.proyId = proyId;
    }

    public BigDecimal getProyId() {
        return proyId;
    }

    public void setProyId(BigDecimal proyId) {
        this.proyId = proyId;
    }

    public String getProyNombre() {
        return proyNombre;
    }

    public void setProyNombre(String proyNombre) {
        this.proyNombre = proyNombre;
    }

    public String getProyDescripcion() {
        return proyDescripcion;
    }

    public void setProyDescripcion(String proyDescripcion) {
        this.proyDescripcion = proyDescripcion;
    }

    public BigInteger getProyUsuarioCreacion() {
        return proyUsuarioCreacion;
    }

    public void setProyUsuarioCreacion(BigInteger proyUsuarioCreacion) {
        this.proyUsuarioCreacion = proyUsuarioCreacion;
    }

    public Date getProyFechaCreacion() {
        return proyFechaCreacion;
    }

    public void setProyFechaCreacion(Date proyFechaCreacion) {
        this.proyFechaCreacion = proyFechaCreacion;
    }

    public BigInteger getProyUsuarioModificacion() {
        return proyUsuarioModificacion;
    }

    public void setProyUsuarioModificacion(BigInteger proyUsuarioModificacion) {
        this.proyUsuarioModificacion = proyUsuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getProyEstado() {
        return proyEstado;
    }

    public void setProyEstado(String proyEstado) {
        this.proyEstado = proyEstado;
    }

    public String getProyResponsable() {
        return proyResponsable;
    }

    public void setProyResponsable(String proyResponsable) {
        this.proyResponsable = proyResponsable;
    }

    @XmlTransient
    public Collection<Actividad> getActividadCollection() {
        return actividadCollection;
    }

    public void setActividadCollection(Collection<Actividad> actividadCollection) {
        this.actividadCollection = actividadCollection;
    }

    public CentroCosto getCcostId() {
        return ccostId;
    }

    public void setCcostId(CentroCosto ccostId) {
        this.ccostId = ccostId;
    }

    public Cliente getCliId() {
        return cliId;
    }

    public void setCliId(Cliente cliId) {
        this.cliId = cliId;
    }

    public Usuario getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuario usuId) {
        this.usuId = usuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyId != null ? proyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proyId == null && other.proyId != null) || (this.proyId != null && !this.proyId.equals(other.proyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.Proyecto[ proyId=" + proyId + " ]";
    }
    
}
