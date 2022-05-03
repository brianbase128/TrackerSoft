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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCliId", query = "SELECT c FROM Cliente c WHERE c.cliId = :cliId")
    , @NamedQuery(name = "Cliente.findByCliEstado", query = "SELECT c FROM Cliente c WHERE c.cliEstado = :cliEstado")
    , @NamedQuery(name = "Cliente.findByCliNombre", query = "SELECT c FROM Cliente c WHERE c.cliNombre = :cliNombre")
    , @NamedQuery(name = "Cliente.findByCliTipoDocumento", query = "SELECT c FROM Cliente c WHERE c.cliTipoDocumento = :cliTipoDocumento")
    , @NamedQuery(name = "Cliente.findByCliNumeroDocumento", query = "SELECT c FROM Cliente c WHERE c.cliNumeroDocumento = :cliNumeroDocumento")
    , @NamedQuery(name = "Cliente.findByCliCorreo", query = "SELECT c FROM Cliente c WHERE c.cliCorreo = :cliCorreo")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="SEQ_CLI", sequenceName="SEQ_CLI_ID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQ_CLI")
    @Column(name = "CLI_ID")
    private BigDecimal cliId;
    @Size(max = 2)
    @Column(name = "CLI_ESTADO")
    private String cliEstado;
    @Size(max = 100)
    @Column(name = "CLI_NOMBRE")
    private String cliNombre;
    @Size(max = 5)
    @Column(name = "CLI_TIPO_DOCUMENTO")
    private String cliTipoDocumento;
    @Size(max = 50)
    @Column(name = "CLI_NUMERO_DOCUMENTO")
    private String cliNumeroDocumento;
    @Size(max = 100)
    @Column(name = "CLI_CORREO")
    private String cliCorreo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliId")
    private Collection<Proyecto> proyectoCollection;

    public Cliente() {
    }

    public Cliente(BigDecimal cliId) {
        this.cliId = cliId;
    }

    public BigDecimal getCliId() {
        return cliId;
    }

    public void setCliId(BigDecimal cliId) {
        this.cliId = cliId;
    }

    public String getCliEstado() {
        return cliEstado;
    }

    public void setCliEstado(String cliEstado) {
        this.cliEstado = cliEstado;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliTipoDocumento() {
        return cliTipoDocumento;
    }

    public void setCliTipoDocumento(String cliTipoDocumento) {
        this.cliTipoDocumento = cliTipoDocumento;
    }

    public String getCliNumeroDocumento() {
        return cliNumeroDocumento;
    }

    public void setCliNumeroDocumento(String cliNumeroDocumento) {
        this.cliNumeroDocumento = cliNumeroDocumento;
    }

    public String getCliCorreo() {
        return cliCorreo;
    }

    public void setCliCorreo(String cliCorreo) {
        this.cliCorreo = cliCorreo;
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
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.trackersoft.entity.Cliente[ cliId=" + cliId + " ]";
    }
    
}
