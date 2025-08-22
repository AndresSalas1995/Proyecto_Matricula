/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umca.proyectofinal.Core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import umca.proyectofinal.Conexion.ConexionDB;
import umca.proyectofinal.Modelos.TblCursos;
import umca.proyectofinal.Modelos.TblUsuario;
import umca.proyectofinal.Modelos.TbltipoUsuario;
import umca.proyectofinal.ViewModel.TipoUsuario;
import umca.proyectofinal.ViewModel.UsuarioVM;

/**
 *
 * @author Waly
 */
public class Usuarios {

    public Usuarios() {
    }

    public TblUsuario crearUsuario(TblUsuario usuario) {

        EntityManager entityManager = ConexionDB.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.flush();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Usuarios.crearUsuario(TblUsuario)" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return usuario;
    }

    public List<TipoUsuario> consultaTiposUsuario() {

        EntityManager entityManager = ConexionDB.createEntityManager();
        List<TbltipoUsuario> tipoUsuarios = new ArrayList<TbltipoUsuario>();
        List vmTipoUsuarios = new ArrayList<TipoUsuario>();
        try {
            Query sql = entityManager.createQuery("SELECT t FROM TbltipoUsuario t");

            tipoUsuarios = sql.getResultList();

            for (TbltipoUsuario fila : tipoUsuarios) {
                TipoUsuario tipoUsuario = new TipoUsuario();

                tipoUsuario.setIdTipo(fila.getPkIdTipo());
                tipoUsuario.setNombre(fila.getTipoUsuario());

                vmTipoUsuarios.add(tipoUsuario);
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Usuarios.consultaTiposUsuario()" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return vmTipoUsuarios;
    }

    public List<UsuarioVM> consultaUsuarios() {
        EntityManager entityManager = ConexionDB.createEntityManager();
        List<TblUsuario> usuarios = new ArrayList<TblUsuario>();
        List vmUsuarios = new ArrayList<UsuarioVM>();
        try {
            Query sql = entityManager.createQuery("SELECT u FROM TblUsuario u");

            usuarios = sql.getResultList();

            for (TblUsuario fila : usuarios) {
                UsuarioVM usuario = new UsuarioVM();

                usuario.setIdUsuario(fila.getPkIdUsuario());
                usuario.setNombre(fila.getNombre());
                usuario.setNombreUsuario(fila.getNombreUsuario());
                usuario.setEmail(fila.getEmail());
                usuario.setTipoUsuario(fila.getFkTipoUsuario().getPkIdTipo());

                vmUsuarios.add(usuario);
            }

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Usuarios.consultaUsuarios()" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return vmUsuarios;
    }

    public boolean login(TblUsuario usuario) {

        EntityManager entityManager = ConexionDB.createEntityManager();
        try {
            Query sql = entityManager.createNativeQuery(
                    "SELECT * FROM tbl_Usuario WHERE nombreUsuario = '"
                    + usuario.getNombreUsuario() + "' AND contrasena = '" + usuario.getContrasena() + "'");

            List<TblUsuario> users = sql.getResultList();
            return !users.isEmpty();
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.Core.Usuarios.login(TblUsuario)" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }
}
