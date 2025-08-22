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
@Table(name = "tbl_DetalleMatricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDetalleMatricula.findAll", query = "SELECT t FROM TblDetalleMatricula t"),
    @NamedQuery(name = "TblDetalleMatricula.findByPkidDetalleMatricula", query = "SELECT t FROM TblDetalleMatricula t WHERE t.pkidDetalleMatricula = :pkidDetalleMatricula"),
    @NamedQuery(name = "TblDetalleMatricula.findByPrecio", query = "SELECT t FROM TblDetalleMatricula t WHERE t.precio = :precio"),
    @NamedQuery(name = "TblDetalleMatricula.findByUsuarioRegistra", query = "SELECT t FROM TblDetalleMatricula t WHERE t.usuarioRegistra = :usuarioRegistra"),
    @NamedQuery(name = "TblDetalleMatricula.findByFecha", query = "SELECT t FROM TblDetalleMatricula t WHERE t.fecha = :fecha")})
public class TblDetalleMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkidDetalleMatricula")
    private Integer pkidDetalleMatricula;
    @Basic(optional = false)
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @Column(name = "usuarioRegistra")
    private String usuarioRegistra;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "fk_curso", referencedColumnName = "pkIdCurso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblCursos fkCurso;
    @JoinColumn(name = "fk_matricula", referencedColumnName = "fkidmatricula")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblMatricula fkMatricula;

    public TblDetalleMatricula() {
    }

    public TblDetalleMatricula(Integer pkidDetalleMatricula) {
        this.pkidDetalleMatricula = pkidDetalleMatricula;
    }

    public TblDetalleMatricula(Integer pkidDetalleMatricula, int precio, String usuarioRegistra, Date fecha) {
        this.pkidDetalleMatricula = pkidDetalleMatricula;
        this.precio = precio;
        this.usuarioRegistra = usuarioRegistra;
        this.fecha = fecha;
    }

    public Integer getPkidDetalleMatricula() {
        return pkidDetalleMatricula;
    }

    public void setPkidDetalleMatricula(Integer pkidDetalleMatricula) {
        this.pkidDetalleMatricula = pkidDetalleMatricula;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUsuarioRegistra() {
        return usuarioRegistra;
    }

    public void setUsuarioRegistra(String usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TblCursos getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(TblCursos fkCurso) {
        this.fkCurso = fkCurso;
    }

    public TblMatricula getFkMatricula() {
        return fkMatricula;
    }

    public void setFkMatricula(TblMatricula fkMatricula) {
        this.fkMatricula = fkMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidDetalleMatricula != null ? pkidDetalleMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleMatricula)) {
            return false;
        }
        TblDetalleMatricula other = (TblDetalleMatricula) object;
        if ((this.pkidDetalleMatricula == null && other.pkidDetalleMatricula != null) || (this.pkidDetalleMatricula != null && !this.pkidDetalleMatricula.equals(other.pkidDetalleMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "umca.proyectofinal.Modelos.TblDetalleMatricula[ pkidDetalleMatricula=" + pkidDetalleMatricula + " ]";
    }
    
}
