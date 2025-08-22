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
@Table(name = "tbl_Estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEstudiantes.findAll", query = "SELECT t FROM TblEstudiantes t"),
    @NamedQuery(name = "TblEstudiantes.findByPkIdEstudiante", query = "SELECT t FROM TblEstudiantes t WHERE t.pkIdEstudiante = :pkIdEstudiante"),
    @NamedQuery(name = "TblEstudiantes.findByNombre", query = "SELECT t FROM TblEstudiantes t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblEstudiantes.findByPrimerApellido", query = "SELECT t FROM TblEstudiantes t WHERE t.primerApellido = :primerApellido"),
    @NamedQuery(name = "TblEstudiantes.findBySegundoApellido", query = "SELECT t FROM TblEstudiantes t WHERE t.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "TblEstudiantes.findByNumeroCedula", query = "SELECT t FROM TblEstudiantes t WHERE t.numeroCedula = :numeroCedula"),
    @NamedQuery(name = "TblEstudiantes.findByFechaNacimiento", query = "SELECT t FROM TblEstudiantes t WHERE t.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "TblEstudiantes.findByDireccionResidencia", query = "SELECT t FROM TblEstudiantes t WHERE t.direccionResidencia = :direccionResidencia"),
    @NamedQuery(name = "TblEstudiantes.findByEmail", query = "SELECT t FROM TblEstudiantes t WHERE t.email = :email"),
    @NamedQuery(name = "TblEstudiantes.findByNumeroTelefono", query = "SELECT t FROM TblEstudiantes t WHERE t.numeroTelefono = :numeroTelefono"),
    @NamedQuery(name = "TblEstudiantes.findByUsuarioRegistra", query = "SELECT t FROM TblEstudiantes t WHERE t.usuarioRegistra = :usuarioRegistra"),
    @NamedQuery(name = "TblEstudiantes.findByFechaRegistro", query = "SELECT t FROM TblEstudiantes t WHERE t.fechaRegistro = :fechaRegistro")})
public class TblEstudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkIdEstudiante")
    private Integer pkIdEstudiante;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "primerApellido")
    private String primerApellido;
    @Basic(optional = false)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "numeroCedula")
    private String numeroCedula;
    @Basic(optional = false)
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "direccionResidencia")
    private String direccionResidencia;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "numeroTelefono")
    private String numeroTelefono;
    @Basic(optional = false)
    @Column(name = "usuarioRegistra")
    private String usuarioRegistra;
    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEstudiante", fetch = FetchType.LAZY)
    private Collection<TblMatricula> tblMatriculaCollection;

    public TblEstudiantes() {
    }

    public TblEstudiantes(Integer pkIdEstudiante) {
        this.pkIdEstudiante = pkIdEstudiante;
    }

    public TblEstudiantes(Integer pkIdEstudiante, String nombre, String primerApellido, String segundoApellido, String numeroCedula, Date fechaNacimiento, String direccionResidencia, String email, String numeroTelefono, String usuarioRegistra, Date fechaRegistro) {
        this.pkIdEstudiante = pkIdEstudiante;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroCedula = numeroCedula;
        this.fechaNacimiento = fechaNacimiento;
        this.direccionResidencia = direccionResidencia;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.usuarioRegistra = usuarioRegistra;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getPkIdEstudiante() {
        return pkIdEstudiante;
    }

    public void setPkIdEstudiante(Integer pkIdEstudiante) {
        this.pkIdEstudiante = pkIdEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
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
    public Collection<TblMatricula> getTblMatriculaCollection() {
        return tblMatriculaCollection;
    }

    public void setTblMatriculaCollection(Collection<TblMatricula> tblMatriculaCollection) {
        this.tblMatriculaCollection = tblMatriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEstudiante != null ? pkIdEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEstudiantes)) {
            return false;
        }
        TblEstudiantes other = (TblEstudiantes) object;
        if ((this.pkIdEstudiante == null && other.pkIdEstudiante != null) || (this.pkIdEstudiante != null && !this.pkIdEstudiante.equals(other.pkIdEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "umca.proyectofinal.Modelos.TblEstudiantes[ pkIdEstudiante=" + pkIdEstudiante + " ]";
    }
    
}
