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
@Table(name = "tbl_carreras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCarreras.findAll", query = "SELECT t FROM TblCarreras t"),
    @NamedQuery(name = "TblCarreras.findByPkIdCarrera", query = "SELECT t FROM TblCarreras t WHERE t.pkIdCarrera = :pkIdCarrera"),
    @NamedQuery(name = "TblCarreras.findByNombreCarrera", query = "SELECT t FROM TblCarreras t WHERE t.nombreCarrera = :nombreCarrera"),
    @NamedQuery(name = "TblCarreras.findByUsuarioRegistra", query = "SELECT t FROM TblCarreras t WHERE t.usuarioRegistra = :usuarioRegistra"),
    @NamedQuery(name = "TblCarreras.findByFechaRegistro", query = "SELECT t FROM TblCarreras t WHERE t.fechaRegistro = :fechaRegistro")})
public class TblCarreras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkIdCarrera")
    private Integer pkIdCarrera;
    @Basic(optional = false)
    @Column(name = "nombreCarrera")
    private String nombreCarrera;
    @Basic(optional = false)
    @Column(name = "usuarioRegistra")
    private String usuarioRegistra;
    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCarrera", fetch = FetchType.LAZY)
    private Collection<TblCarreraCurso> tblCarreraCursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCarrera", fetch = FetchType.LAZY)
    private Collection<TblMatricula> tblMatriculaCollection;

    public TblCarreras() {
    }

    public TblCarreras(Integer pkIdCarrera) {
        this.pkIdCarrera = pkIdCarrera;
    }

    public TblCarreras(Integer pkIdCarrera, String nombreCarrera, String usuarioRegistra, Date fechaRegistro) {
        this.pkIdCarrera = pkIdCarrera;
        this.nombreCarrera = nombreCarrera;
        this.usuarioRegistra = usuarioRegistra;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getPkIdCarrera() {
        return pkIdCarrera;
    }

    public void setPkIdCarrera(Integer pkIdCarrera) {
        this.pkIdCarrera = pkIdCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
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
    public Collection<TblCarreraCurso> getTblCarreraCursoCollection() {
        return tblCarreraCursoCollection;
    }

    public void setTblCarreraCursoCollection(Collection<TblCarreraCurso> tblCarreraCursoCollection) {
        this.tblCarreraCursoCollection = tblCarreraCursoCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TblMatricula> getTblMatriculaCollection() {
        return tblMatriculaCollection;
    }

    public void setTblMatriculaCollection(Collection<TblMatricula> tblMatriculaCollection) {
        this.tblMatriculaCollection = tblMatriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCarrera != null ? pkIdCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCarreras)) {
            return false;
        }
        TblCarreras other = (TblCarreras) object;
        if ((this.pkIdCarrera == null && other.pkIdCarrera != null) || (this.pkIdCarrera != null && !this.pkIdCarrera.equals(other.pkIdCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "umca.proyectofinal.Modelos.TblCarreras[ pkIdCarrera=" + pkIdCarrera + " ]";
    }
    
}
