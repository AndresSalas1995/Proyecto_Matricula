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
@Table(name = "tbl_cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCursos.findAll", query = "SELECT t FROM TblCursos t"),
    @NamedQuery(name = "TblCursos.findByPkIdCurso", query = "SELECT t FROM TblCursos t WHERE t.pkIdCurso = :pkIdCurso"),
    @NamedQuery(name = "TblCursos.findByNombreCurso", query = "SELECT t FROM TblCursos t WHERE t.nombreCurso = :nombreCurso"),
    @NamedQuery(name = "TblCursos.findByCodigoCurso", query = "SELECT t FROM TblCursos t WHERE t.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "TblCursos.findByCreditosCurso", query = "SELECT t FROM TblCursos t WHERE t.creditosCurso = :creditosCurso"),
    @NamedQuery(name = "TblCursos.findByPrecioCurso", query = "SELECT t FROM TblCursos t WHERE t.precioCurso = :precioCurso"),
    @NamedQuery(name = "TblCursos.findByUsuarioRegistra", query = "SELECT t FROM TblCursos t WHERE t.usuarioRegistra = :usuarioRegistra"),
    @NamedQuery(name = "TblCursos.findByFechaRegistro", query = "SELECT t FROM TblCursos t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TblCursos.findByUltimoUsuarioModifico", query = "SELECT t FROM TblCursos t WHERE t.ultimoUsuarioModifico = :ultimoUsuarioModifico")})
public class TblCursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkIdCurso")
    private Integer pkIdCurso;
    @Basic(optional = false)
    @Column(name = "nombreCurso")
    private String nombreCurso;
    @Basic(optional = false)
    @Column(name = "codigoCurso")
    private String codigoCurso;
    @Basic(optional = false)
    @Column(name = "creditosCurso")
    private int creditosCurso;
    @Basic(optional = false)
    @Column(name = "precioCurso")
    private int precioCurso;
    @Basic(optional = false)
    @Column(name = "usuarioRegistra")
    private String usuarioRegistra;
    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "ultimoUsuarioModifico")
    private String ultimoUsuarioModifico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCurso", fetch = FetchType.LAZY)
    private Collection<TblCarreraCurso> tblCarreraCursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCurso", fetch = FetchType.LAZY)
    private Collection<TblDetalleMatricula> tblDetalleMatriculaCollection;

    public TblCursos() {
    }

    public TblCursos(Integer pkIdCurso) {
        this.pkIdCurso = pkIdCurso;
    }

    public TblCursos(Integer pkIdCurso, String nombreCurso, String codigoCurso, int creditosCurso, int precioCurso, String usuarioRegistra, Date fechaRegistro, String ultimoUsuarioModifico) {
        this.pkIdCurso = pkIdCurso;
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.creditosCurso = creditosCurso;
        this.precioCurso = precioCurso;
        this.usuarioRegistra = usuarioRegistra;
        this.fechaRegistro = fechaRegistro;
        this.ultimoUsuarioModifico = ultimoUsuarioModifico;
    }

    public Integer getPkIdCurso() {
        return pkIdCurso;
    }

    public void setPkIdCurso(Integer pkIdCurso) {
        this.pkIdCurso = pkIdCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCreditosCurso() {
        return creditosCurso;
    }

    public void setCreditosCurso(int creditosCurso) {
        this.creditosCurso = creditosCurso;
    }

    public int getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(int precioCurso) {
        this.precioCurso = precioCurso;
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

    public String getUltimoUsuarioModifico() {
        return ultimoUsuarioModifico;
    }

    public void setUltimoUsuarioModifico(String ultimoUsuarioModifico) {
        this.ultimoUsuarioModifico = ultimoUsuarioModifico;
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
    public Collection<TblDetalleMatricula> getTblDetalleMatriculaCollection() {
        return tblDetalleMatriculaCollection;
    }

    public void setTblDetalleMatriculaCollection(Collection<TblDetalleMatricula> tblDetalleMatriculaCollection) {
        this.tblDetalleMatriculaCollection = tblDetalleMatriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCurso != null ? pkIdCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCursos)) {
            return false;
        }
        TblCursos other = (TblCursos) object;
        if ((this.pkIdCurso == null && other.pkIdCurso != null) || (this.pkIdCurso != null && !this.pkIdCurso.equals(other.pkIdCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "umca.proyectofinal.Modelos.TblCursos[ pkIdCurso=" + pkIdCurso + " ]";
    }
    
}
