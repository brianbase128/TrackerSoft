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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findByActId", query = "SELECT a FROM Actividad a WHERE a.actId = :actId")
    , @NamedQuery(name = "Actividad.findByActNombre", query = "SELECT a FROM Actividad a WHERE a.actNombre = :actNombre")
    , @NamedQuery(name = "Actividad.findByActDescripcion", query = "SELECT a FROM Actividad a WHERE a.actDescripcion = :actDescripcion")
    , @NamedQuery(name = "Actividad.findByActResponsable", query = "SELECT a FROM Actividad a WHERE a.actResponsable = :actResponsable")
    , @NamedQuery(name = "Actividad.findByActTiempoEstimado", query = "SELECT a FROM Actividad a WHERE a.actTiempoEstimado = :actTiempoEstimado")
    , @NamedQuery(name = "Actividad.findByActTiempoInvertido", query = "SELECT a FROM Actividad a WHERE a.actTiempoInvertido = :actTiempoInvertido")
    , @NamedQuery(name = "Actividad.findByActFechaEntrega", query = "SELECT a FROM Actividad a WHERE a.actFechaEntrega = :actFechaEntrega")
    , @NamedQuery(name = "Actividad.findByActComentario", query = "SELECT a FROM Actividad a WHERE a.actComentario = :actComentario")
    , @NamedQuery(name = "Actividad.findByActUsuarioCreacion", query = "SELECT a FROM Actividad a WHERE a.actUsuarioCreacion = :actUsuarioCreacion")
    , @NamedQuery(name = "Actividad.findByActFechaCreacion", query = "SELECT a FROM Actividad a WHERE a.actFechaCreacion = :actFechaCreacion")
    , @NamedQuery(name = "Actividad.findByActUsuarioModificacion", query = "SELECT a FROM Actividad a WHERE a.actUsuarioModificacion = :actUsuarioModificacion")
    , @NamedQuery(name = "Actividad.findByActFechaModificacion", query = "SELECT a FROM Actividad a WHERE a.actFechaModificacion = :actFechaModificacion")
    , @NamedQuery(name = "Actividad.findByActEstado", query = "SELECT a FROM Actividad a WHERE a.actEstado = :actEstado")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="SEQ_ACT", sequenceName="SEQ_ACT_ID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQ_ACT")
    @Column(name = "ACT_ID")
    private BigDecimal actId;
    @Size(max = 100)
    @Column(name = "ACT_NOMBRE")
    private String actNombre;
    @Size(max = 250)
    @Column(name = "ACT_DESCRIPCION")
    private String actDescripcion;
    @Column(name = "ACT_RESPONSABLE")
    private BigInteger actResponsable;
    @Column(name = "ACT_TIEMPO_ESTIMADO")
    private BigInteger actTiempoEstimado;
    @Column(name = "ACT_TIEMPO_INVERTIDO")
    private BigInteger actTiempoInvertido;
    @Column(name = "ACT_FECHA_ENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechaEntrega;
    @Size(max = 500)
    @Column(name = "ACT_COMENTARIO")
    private String actComentario;
    @Column(name = "ACT_USUARIO_CREACION")
    private BigInteger actUsuarioCreacion;
    @Column(name = "ACT_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechaCreacion;
    @Column(name = "ACT_USUARIO_MODIFICACION")
    private BigInteger actUsuarioModificacion;
    @Column(name = "ACT_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechaModificacion;
    @Size(max = 25)
    @Column(name = "ACT_ESTADO")
    private String actEstado;
    @JoinColumn(name = "FAC_ID", referencedColumnName = "FAC_ID")
    @ManyToOne(optional = false)
    private Factura facId;
    @JoinColumn(name = "PROV_ID", referencedColumnName = "PROV_ID")
    @ManyToOne(optional = false)
    private Provision provId;
    @JoinColumn(name = "PROY_ID", referencedColumnName = "PROY_ID")
    @ManyToOne(optional = false)
    private Proyecto proyId;
    @JoinColumn(name = "TAR_ID", referencedColumnName = "TAR_ID")
    @ManyToOne(optional = false)
    private Tarifa tarId;
    @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
    @ManyToOne(optional = false)
    private Usuario usuId;

    public Actividad() {
    }

    public Actividad(BigDecimal actId) {
        this.actId = actId;
    }

    public BigDecimal getActId() {
        return actId;
    }

    public void setActId(BigDecimal actId) {
        this.actId = actId;
    }

    public String getActNombre() {
        return actNombre;
    }

    public void setActNombre(String actNombre) {
        this.actNombre = actNombre;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public BigInteger getActResponsable() {
        return actResponsable;
    }

    public void setActResponsable(BigInteger actResponsable) {
        this.actResponsable = actResponsable;
    }

    public BigInteger getActTiempoEstimado() {
        return actTiempoEstimado;
    }

    public void setActTiempoEstimado(BigInteger actTiempoEstimado) {
        this.actTiempoEstimado = actTiempoEstimado;
    }

    public BigInteger getActTiempoInvertido() {
        return actTiempoInvertido;
    }

    public void setActTiempoInvertido(BigInteger actTiempoInvertido) {
        this.actTiempoInvertido = actTiempoInvertido;
    }

    public Date getActFechaEntrega() {
        return actFechaEntrega;
    }

    public void setActFechaEntrega(Date actFechaEntrega) {
        this.actFechaEntrega = actFechaEntrega;
    }

    public String getActComentario() {
        return actComentario;
    }

    public void setActComentario(String actComentario) {
        this.actComentario = actComentario;
    }

    public BigInteger getActUsuarioCreacion() {
        return actUsuarioCreacion;
    }

    public void setActUsuarioCreacion(BigInteger actUsuarioCreacion) {
        this.actUsuarioCreacion = actUsuarioCreacion;
    }

    public Date getActFechaCreacion() {
        return actFechaCreacion;
    }

    public void setActFechaCreacion(Date actFechaCreacion) {
        this.actFechaCreacion = actFechaCreacion;
    }

    public BigInteger getActUsuarioModificacion() {
        return actUsuarioModificacion;
    }

    public void setActUsuarioModificacion(BigInteger actUsuarioModificacion) {
        this.actUsuarioModificacion = actUsuarioModificacion;
    }

    public Date getActFechaModificacion() {
        return actFechaModificacion;
    }

    public void setActFechaModificacion(Date actFechaModificacion) {
        this.actFechaModificacion = actFechaModificacion;
    }

    public String getActEstado() {
        return actEstado;
    }

    public void setActEstado(String actEstado) {
        this.actEstado = actEstado;
    }

    public Factura getFacId() {
        return facId;
    }

    public void setFacId(Factura facId) {
        this.facId = facId;
    }

    public Provision getProvId() {
        return provId;
    }

    public void setProvId(Provision provId) {
        this.provId = provId;
    }

    public Proyecto getProyId() {
        return proyId;
    }

    public void setProyId(Proyecto proyId) {
        this.proyId = proyId;
    }

    public Tarifa getTarId() {
        return tarId;
    }

    public void setTarId(Tarifa tarId) {
        this.tarId = tarId;
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
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.Actividad[ actId=" + actId + " ]";
    }
    
}
