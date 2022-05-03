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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuId", query = "SELECT u FROM Usuario u WHERE u.usuId = :usuId")
    , @NamedQuery(name = "Usuario.findByUsuToken", query = "SELECT u FROM Usuario u WHERE u.usuToken = :usuToken")
    , @NamedQuery(name = "Usuario.findByUsuNombre", query = "SELECT u FROM Usuario u WHERE u.usuNombre = :usuNombre")
    , @NamedQuery(name = "Usuario.findByUsuTipoDocumento", query = "SELECT u FROM Usuario u WHERE u.usuTipoDocumento = :usuTipoDocumento")
    , @NamedQuery(name = "Usuario.findByUsuNumeroDocumento", query = "SELECT u FROM Usuario u WHERE u.usuNumeroDocumento = :usuNumeroDocumento")
    , @NamedQuery(name = "Usuario.findByUsuCorreo", query = "SELECT u FROM Usuario u WHERE u.usuCorreo = :usuCorreo")
    , @NamedQuery(name = "Usuario.findByUsuUsuarioCreacion", query = "SELECT u FROM Usuario u WHERE u.usuUsuarioCreacion = :usuUsuarioCreacion")
    , @NamedQuery(name = "Usuario.findByUsuFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.usuFechaCreacion = :usuFechaCreacion")
    , @NamedQuery(name = "Usuario.findByUsuUsuarioModificacion", query = "SELECT u FROM Usuario u WHERE u.usuUsuarioModificacion = :usuUsuarioModificacion")
    , @NamedQuery(name = "Usuario.findByUsuFechaModificacion", query = "SELECT u FROM Usuario u WHERE u.usuFechaModificacion = :usuFechaModificacion")
    , @NamedQuery(name = "Usuario.findByUsuEstado", query = "SELECT u FROM Usuario u WHERE u.usuEstado = :usuEstado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="SEQ_USU", sequenceName="SEQ_USU_ID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQ_USU")
    @Column(name = "USU_ID")
    private BigDecimal usuId;
    @Size(max = 200)
    @Column(name = "USU_TOKEN")
    private String usuToken;
    @Size(max = 100)
    @Column(name = "USU_NOMBRE")
    private String usuNombre;
    @Size(max = 5)
    @Column(name = "USU_TIPO_DOCUMENTO")
    private String usuTipoDocumento;
    @Size(max = 50)
    @Column(name = "USU_NUMERO_DOCUMENTO")
    private String usuNumeroDocumento;
    @Size(max = 100)
    @Column(name = "USU_CORREO")
    private String usuCorreo;
    @Column(name = "USU_USUARIO_CREACION")
    private BigInteger usuUsuarioCreacion;
    @Column(name = "USU_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechaCreacion;
    @Column(name = "USU_USUARIO_MODIFICACION")
    private BigInteger usuUsuarioModificacion;
    @Column(name = "USU_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechaModificacion;
    @Size(max = 1)
    @Column(name = "USU_ESTADO")
    private String usuEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private Collection<UsuarioRol> usuarioRolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private Collection<Actividad> actividadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private Collection<Proyecto> proyectoCollection;

    public Usuario() {
    }

    public Usuario(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public BigDecimal getUsuId() {
        return usuId;
    }

    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public String getUsuToken() {
        return usuToken;
    }

    public void setUsuToken(String usuToken) {
        this.usuToken = usuToken;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuTipoDocumento() {
        return usuTipoDocumento;
    }

    public void setUsuTipoDocumento(String usuTipoDocumento) {
        this.usuTipoDocumento = usuTipoDocumento;
    }

    public String getUsuNumeroDocumento() {
        return usuNumeroDocumento;
    }

    public void setUsuNumeroDocumento(String usuNumeroDocumento) {
        this.usuNumeroDocumento = usuNumeroDocumento;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public BigInteger getUsuUsuarioCreacion() {
        return usuUsuarioCreacion;
    }

    public void setUsuUsuarioCreacion(BigInteger usuUsuarioCreacion) {
        this.usuUsuarioCreacion = usuUsuarioCreacion;
    }

    public Date getUsuFechaCreacion() {
        return usuFechaCreacion;
    }

    public void setUsuFechaCreacion(Date usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }

    public BigInteger getUsuUsuarioModificacion() {
        return usuUsuarioModificacion;
    }

    public void setUsuUsuarioModificacion(BigInteger usuUsuarioModificacion) {
        this.usuUsuarioModificacion = usuUsuarioModificacion;
    }

    public Date getUsuFechaModificacion() {
        return usuFechaModificacion;
    }

    public void setUsuFechaModificacion(Date usuFechaModificacion) {
        this.usuFechaModificacion = usuFechaModificacion;
    }

    public String getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }

    @XmlTransient
    public Collection<UsuarioRol> getUsuarioRolCollection() {
        return usuarioRolCollection;
    }

    public void setUsuarioRolCollection(Collection<UsuarioRol> usuarioRolCollection) {
        this.usuarioRolCollection = usuarioRolCollection;
    }

    @XmlTransient
    public Collection<Actividad> getActividadCollection() {
        return actividadCollection;
    }

    public void setActividadCollection(Collection<Actividad> actividadCollection) {
        this.actividadCollection = actividadCollection;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.Usuario[ usuId=" + usuId + " ]";
    }
    
}
