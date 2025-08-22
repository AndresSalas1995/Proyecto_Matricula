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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMatricula.findAll", query = "SELECT t FROM TblMatricula t"),
    @NamedQuery(name = "TblMatricula.findByFkidmatricula", query = "SELECT t FROM TblMatricula t WHERE t.fkidmatricula = :fkidmatricula"),
    @NamedQuery(name = "TblMatricula.findBySubtotal", query = "SELECT t FROM TblMatricula t WHERE t.subtotal = :subtotal"),
    @NamedQuery(name = "TblMatricula.findByIva", query = "SELECT t FROM TblMatricula t WHERE t.iva = :iva"),
    @NamedQuery(name = "TblMatricula.findByTotal", query = "SELECT t FROM TblMatricula t WHERE t.total = :total"),
    @NamedQuery(name = "TblMatricula.findByUsuarioRegistra", query = "SELECT t FROM TblMatricula t WHERE t.usuarioRegistra = :usuarioRegistra"),
    @NamedQuery(name = "TblMatricula.findByFechaRegistro", query = "SELECT t FROM TblMatricula t WHERE t.fechaRegistro = :fechaRegistro")})
public class TblMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fkidmatricula")
    private Integer fkidmatricula;
    @Basic(optional = false)
    @Column(name = "subtotal")
    private int subtotal;
    @Basic(optional = false)
    @Column(name = "iva")
    private int iva;
    @Basic(optional = false)
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @Column(name = "usuarioRegistra")
    private String usuarioRegistra;
    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "fk_carrera", referencedColumnName = "pkIdCarrera")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblCarreras fkCarrera;
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "pkIdEstudiante")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblEstudiantes fkEstudiante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMatricula", fetch = FetchType.LAZY)
    private Collection<TblDetalleMatricula> tblDetalleMatriculaCollection;

    public TblMatricula() {
    }

    public TblMatricula(Integer fkidmatricula) {
        this.fkidmatricula = fkidmatricula;
    }

    public TblMatricula(Integer fkidmatricula, int subtotal, int iva, int total, String usuarioRegistra, Date fechaRegistro) {
        this.fkidmatricula = fkidmatricula;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.usuarioRegistra = usuarioRegistra;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getFkidmatricula() {
        return fkidmatricula;
    }

    public void setFkidmatricula(Integer fkidmatricula) {
        this.fkidmatricula = fkidmatricula;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public TblEstudiantes getFkEstudiante() {
        return fkEstudiante;
    }

    public void setFkEstudiante(TblEstudiantes fkEstudiante) {
        this.fkEstudiante = fkEstudiante;
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
        hash += (fkidmatricula != null ? fkidmatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMatricula)) {
            return false;
        }
        TblMatricula other = (TblMatricula) object;
        if ((this.fkidmatricula == null && other.fkidmatricula != null) || (this.fkidmatricula != null && !this.fkidmatricula.equals(other.fkidmatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "umca.proyectofinal.Modelos.TblMatricula[ fkidmatricula=" + fkidmatricula + " ]";
    }
    
}
