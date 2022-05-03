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
@Table(name = "ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByRolId", query = "SELECT r FROM Rol r WHERE r.rolId = :rolId")
    , @NamedQuery(name = "Rol.findByRolNombre", query = "SELECT r FROM Rol r WHERE r.rolNombre = :rolNombre")
    , @NamedQuery(name = "Rol.findByRolDescripcion", query = "SELECT r FROM Rol r WHERE r.rolDescripcion = :rolDescripcion")
    , @NamedQuery(name = "Rol.findByRolUsuarioCreacion", query = "SELECT r FROM Rol r WHERE r.rolUsuarioCreacion = :rolUsuarioCreacion")
    , @NamedQuery(name = "Rol.findByRolFechaCreacion", query = "SELECT r FROM Rol r WHERE r.rolFechaCreacion = :rolFechaCreacion")
    , @NamedQuery(name = "Rol.findByRolUsuarioModificacion", query = "SELECT r FROM Rol r WHERE r.rolUsuarioModificacion = :rolUsuarioModificacion")
    , @NamedQuery(name = "Rol.findByRolFechaModificacion", query = "SELECT r FROM Rol r WHERE r.rolFechaModificacion = :rolFechaModificacion")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID")
    private BigDecimal rolId;
    @Size(max = 100)
    @Column(name = "ROL_NOMBRE")
    private String rolNombre;
    @Size(max = 250)
    @Column(name = "ROL_DESCRIPCION")
    private String rolDescripcion;
    @Column(name = "ROL_USUARIO_CREACION")
    private BigInteger rolUsuarioCreacion;
    @Column(name = "ROL_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rolFechaCreacion;
    @Column(name = "ROL_USUARIO_MODIFICACION")
    private BigInteger rolUsuarioModificacion;
    @Column(name = "ROL_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rolFechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private Collection<UsuarioRol> usuarioRolCollection;

    public Rol() {
    }

    public Rol(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public BigDecimal getRolId() {
        return rolId;
    }

    public void setRolId(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public BigInteger getRolUsuarioCreacion() {
        return rolUsuarioCreacion;
    }

    public void setRolUsuarioCreacion(BigInteger rolUsuarioCreacion) {
        this.rolUsuarioCreacion = rolUsuarioCreacion;
    }

    public Date getRolFechaCreacion() {
        return rolFechaCreacion;
    }

    public void setRolFechaCreacion(Date rolFechaCreacion) {
        this.rolFechaCreacion = rolFechaCreacion;
    }

    public BigInteger getRolUsuarioModificacion() {
        return rolUsuarioModificacion;
    }

    public void setRolUsuarioModificacion(BigInteger rolUsuarioModificacion) {
        this.rolUsuarioModificacion = rolUsuarioModificacion;
    }

    public Date getRolFechaModificacion() {
        return rolFechaModificacion;
    }

    public void setRolFechaModificacion(Date rolFechaModificacion) {
        this.rolFechaModificacion = rolFechaModificacion;
    }

    @XmlTransient
    public Collection<UsuarioRol> getUsuarioRolCollection() {
        return usuarioRolCollection;
    }

    public void setUsuarioRolCollection(Collection<UsuarioRol> usuarioRolCollection) {
        this.usuarioRolCollection = usuarioRolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.Rol[ rolId=" + rolId + " ]";
    }
    
}
