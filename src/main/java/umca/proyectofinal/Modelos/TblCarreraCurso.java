/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umca.proyectofinal.Modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Waly
 */
@Entity
@Table(name = "tbl_CarreraCurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCarreraCurso.findAll", query = "SELECT t FROM TblCarreraCurso t"),
    @NamedQuery(name = "TblCarreraCurso.findByPkIdCarreraCurso", query = "SELECT t FROM TblCarreraCurso t WHERE t.pkIdCarreraCurso = :pkIdCarreraCurso"),
    @NamedQuery(name = "TblCarreraCurso.findByUsuarioRegistra", query = "SELECT t FROM TblCarreraCurso t WHERE t.usuarioRegistra = :usuarioRegistra"),
    @NamedQuery(name = "TblCarreraCurso.findByFechaRegistro", query = "SELECT t FROM TblCarreraCurso t WHERE t.fechaRegistro = :fechaRegistro")})
public class TblCarreraCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkIdCarreraCurso")
    private Integer pkIdCarreraCurso;
    @Basic(optional = false)
    @Column(name = "usuarioRegistra")
    private String usuarioRegistra;
    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "fkCarrera", referencedColumnName = "pkIdCarrera")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblCarreras fkCarrera;
    @JoinColumn(name = "fkCurso", referencedColumnName = "pkIdCurso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblCursos fkCurso;

    public TblCarreraCurso() {
    }

    public TblCarreraCurso(Integer pkIdCarreraCurso) {
        this.pkIdCarreraCurso = pkIdCarreraCurso;
    }

    public TblCarreraCurso(Integer pkIdCarreraCurso, String usuarioRegistra, Date fechaRegistro) {
        this.pkIdCarreraCurso = pkIdCarreraCurso;
        this.usuarioRegistra = usuarioRegistra;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getPkIdCarreraCurso() {
        return pkIdCarreraCurso;
    }

    public void setPkIdCarreraCurso(Integer pkIdCarreraCurso) {
        this.pkIdCarreraCurso = pkIdCarreraCurso;
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

    public TblCarreras getFkCarrera() {
        return fkCarrera;
    }

    public void setFkCarrera(TblCarreras fkCarrera) {
        this.fkCarrera = fkCarrera;
    }

    public TblCursos getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(TblCursos fkCurso) {
        this.fkCurso = fkCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCarreraCurso != null ? pkIdCarreraCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCarreraCurso)) {
            return false;
        }
        TblCarreraCurso other = (TblCarreraCurso) object;
        if ((this.pkIdCarreraCurso == null && other.pkIdCarreraCurso != null) || (this.pkIdCarreraCurso != null && !this.pkIdCarreraCurso.equals(other.pkIdCarreraCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "umca.proyectofinal.Modelos.TblCarreraCurso[ pkIdCarreraCurso=" + pkIdCarreraCurso + " ]";
    }
    
}
