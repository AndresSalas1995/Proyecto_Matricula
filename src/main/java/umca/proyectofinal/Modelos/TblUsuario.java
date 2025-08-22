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
@Table(name = "tbl_Usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuario.findAll", query = "SELECT t FROM TblUsuario t"),
    @NamedQuery(name = "TblUsuario.findByPkIdUsuario", query = "SELECT t FROM TblUsuario t WHERE t.pkIdUsuario = :pkIdUsuario"),
    @NamedQuery(name = "TblUsuario.findByNombre", query = "SELECT t FROM TblUsuario t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblUsuario.findByPrimerApellido", query = "SELECT t FROM TblUsuario t WHERE t.primerApellido = :primerApellido"),
    @NamedQuery(name = "TblUsuario.findBySegundoApellido", query = "SELECT t FROM TblUsuario t WHERE t.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "TblUsuario.findByNombreUsuario", query = "SELECT t FROM TblUsuario t WHERE t.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "TblUsuario.findByEmail", query = "SELECT t FROM TblUsuario t WHERE t.email = :email"),
    @NamedQuery(name = "TblUsuario.findByContrasena", query = "SELECT t FROM TblUsuario t WHERE t.contrasena = :contrasena"),
    @NamedQuery(name = "TblUsuario.findByUsuarioRegistro", query = "SELECT t FROM TblUsuario t WHERE t.usuarioRegistro = :usuarioRegistro"),
    @NamedQuery(name = "TblUsuario.findByFechaRegistro", query = "SELECT t FROM TblUsuario t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TblUsuario.findByUltimoUsuarioModifico", query = "SELECT t FROM TblUsuario t WHERE t.ultimoUsuarioModifico = :ultimoUsuarioModifico")})
public class TblUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkIdUsuario")
    private Integer pkIdUsuario;
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
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "usuarioRegistro")
    private String usuarioRegistro;
    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "ultimoUsuarioModifico")
    private String ultimoUsuarioModifico;
    @JoinColumn(name = "fkTipoUsuario", referencedColumnName = "pkIdTipo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TbltipoUsuario fkTipoUsuario;

    public TblUsuario() {
    }

    public TblUsuario(Integer pkIdUsuario) {
        this.pkIdUsuario = pkIdUsuario;
    }

    public TblUsuario(Integer pkIdUsuario, String nombre, String primerApellido, String segundoApellido, String nombreUsuario, String email, String contrasena, String usuarioRegistro, Date fechaRegistro, String ultimoUsuarioModifico) {
        this.pkIdUsuario = pkIdUsuario;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.ultimoUsuarioModifico = ultimoUsuarioModifico;
    }

    public Integer getPkIdUsuario() {
        return pkIdUsuario;
    }

    public void setPkIdUsuario(Integer pkIdUsuario) {
        this.pkIdUsuario = pkIdUsuario;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
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

    public TbltipoUsuario getFkTipoUsuario() {
        return fkTipoUsuario;
    }

    public void setFkTipoUsuario(TbltipoUsuario fkTipoUsuario) {
        this.fkTipoUsuario = fkTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdUsuario != null ? pkIdUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsuario)) {
            return false;
        }
        TblUsuario other = (TblUsuario) object;
        if ((this.pkIdUsuario == null && other.pkIdUsuario != null) || (this.pkIdUsuario != null && !this.pkIdUsuario.equals(other.pkIdUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "umca.proyectofinal.Modelos.TblUsuario[ pkIdUsuario=" + pkIdUsuario + " ]";
    }
    
}
