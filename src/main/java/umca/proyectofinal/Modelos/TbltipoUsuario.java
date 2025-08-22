/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umca.proyectofinal.Modelos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Waly
 */
@Entity
@Table(name = "tbl_tipoUsuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbltipoUsuario.findAll", query = "SELECT t FROM TbltipoUsuario t"),
    @NamedQuery(name = "TbltipoUsuario.findByPkIdTipo", query = "SELECT t FROM TbltipoUsuario t WHERE t.pkIdTipo = :pkIdTipo"),
    @NamedQuery(name = "TbltipoUsuario.findByTipoUsuario", query = "SELECT t FROM TbltipoUsuario t WHERE t.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "TbltipoUsuario.findByUsuarioRegistra", query = "SELECT t FROM TbltipoUsuario t WHERE t.usuarioRegistra = :usuarioRegistra"),
    @NamedQuery(name = "TbltipoUsuario.findByFechaRegistro", query = "SELECT t FROM TbltipoUsuario t WHERE t.fechaRegistro = :fechaRegistro")})
public class TbltipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkIdTipo")
    private Integer pkIdTipo;
    @Basic(optional = false)
    @Column(name = "TipoUsuario")
    private String tipoUsuario;
    @Basic(optional = false)
    @Column(name = "usuarioRegistra")
    private String usuarioRegistra;
    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipoUsuario", fetch = FetchType.LAZY)
    private Collection<TblUsuario> tblUsuarioCollection;

    public TbltipoUsuario() {
    }

    public TbltipoUsuario(Integer pkIdTipo) {
        this.pkIdTipo = pkIdTipo;
    }

    public TbltipoUsuario(Integer pkIdTipo, String tipoUsuario, String usuarioRegistra, Date fechaRegistro) {
        this.pkIdTipo = pkIdTipo;
        this.tipoUsuario = tipoUsuario;
        this.usuarioRegistra = usuarioRegistra;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getPkIdTipo() {
        return pkIdTipo;
    }

    public void setPkIdTipo(Integer pkIdTipo) {
        this.pkIdTipo = pkIdTipo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuarioRegistra() {
        return usuarioRegistra;
    }

    public void setUsuarioRegistra(String usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TblUsuario> getTblUsuarioCollection() {
        return tblUsuarioCollection;
    }

    public void setTblUsuarioCollection(Collection<TblUsuario> tblUsuarioCollection) {
        this.tblUsuarioCollection = tblUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipo != null ? pkIdTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbltipoUsuario)) {
            return false;
        }
        TbltipoUsuario other = (TbltipoUsuario) object;
        if ((this.pkIdTipo == null && other.pkIdTipo != null) || (this.pkIdTipo != null && !this.pkIdTipo.equals(other.pkIdTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "umca.proyectofinal.Modelos.TbltipoUsuario[ pkIdTipo=" + pkIdTipo + " ]";
    }
    
}
