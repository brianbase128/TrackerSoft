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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author I7PRO
 */
@Entity
@Table(name = "USUARIO_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u")
    , @NamedQuery(name = "UsuarioRol.findByUsurolId", query = "SELECT u FROM UsuarioRol u WHERE u.usurolId = :usurolId")
    , @NamedQuery(name = "UsuarioRol.findByUsurolDescripcion", query = "SELECT u FROM UsuarioRol u WHERE u.usurolDescripcion = :usurolDescripcion")
    , @NamedQuery(name = "UsuarioRol.findByUsurolEstado", query = "SELECT u FROM UsuarioRol u WHERE u.usurolEstado = :usurolEstado")})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="SEQ_USUROL", sequenceName="SEQ_USUROL_ID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQ_USUROL")
    @Column(name = "USUROL_ID")
    private BigDecimal usurolId;
    @Size(max = 250)
    @Column(name = "USUROL_DESCRIPCION")
    private String usurolDescripcion;
    @Size(max = 25)
    @Column(name = "USUROL_ESTADO")
    private String usurolEstado;
    @JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID")
    @ManyToOne(optional = false)
    private Rol rolId;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(optional = false)
    private Usuario usuId;

    public UsuarioRol() {
    }

    public UsuarioRol(BigDecimal usurolId) {
        this.usurolId = usurolId;
    }

    public BigDecimal getUsurolId() {
        return usurolId;
    }

    public void setUsurolId(BigDecimal usurolId) {
        this.usurolId = usurolId;
    }

    public String getUsurolDescripcion() {
        return usurolDescripcion;
    }

    public void setUsurolDescripcion(String usurolDescripcion) {
        this.usurolDescripcion = usurolDescripcion;
    }

    public String getUsurolEstado() {
        return usurolEstado;
    }

    public void setUsurolEstado(String usurolEstado) {
        this.usurolEstado = usurolEstado;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
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
        hash += (usurolId != null ? usurolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.usurolId == null && other.usurolId != null) || (this.usurolId != null && !this.usurolId.equals(other.usurolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.UsuarioRol[ usurolId=" + usurolId + " ]";
    }
    
}
