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
import umca.proyectofinal.Modelos.TblEstudiantes;
import umca.proyectofinal.Modelos.TblUsuario;
import umca.proyectofinal.Modelos.TbltipoUsuario;
import umca.proyectofinal.ViewModel.EstudiantesVM;
import umca.proyectofinal.ViewModel.TipoUsuario;
import umca.proyectofinal.ViewModel.UsuarioVM;

/**
 *
 * @author Waly
 */
public class Estudiantes {

    public Estudiantes() {}

    public TblEstudiantes crearEstudiante(TblEstudiantes estudiante) {

        EntityManager entityManager = ConexionDB.createEntityManager();
        try {
            
            entityManager.getTransaction().begin();
            entityManager.persist(estudiante);
            entityManager.flush();
            
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Estudiantes.crearEstudiante(TblEstudiantes)" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return estudiante;
    }
    
    public void actualizarEstudiante(TblEstudiantes estudiante) {
        EntityManager en = ConexionDB.createEntityManager();
        try {

            en.getTransaction().begin();
            en.merge(estudiante);

            en.getTransaction().commit();

        } catch (Exception e) {
            en.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Cursos.crearCurso(TblCursos)" + e.getMessage());
        } finally {
            if (en != null) {
                en.close();
            }
        }
    }

    public List<EstudiantesVM> consultaEstudiantes() {

        EntityManager entityManager = ConexionDB.createEntityManager();
        List<TblEstudiantes> estudiantes = new ArrayList<TblEstudiantes>();
        List vmEstudiantes = new ArrayList<EstudiantesVM>();
        try {
            Query sql = entityManager.createQuery("SELECT e FROM TblEstudiantes e");

            estudiantes = sql.getResultList();
            
            for (TblEstudiantes fila : estudiantes) {
                EstudiantesVM estudiante = new EstudiantesVM();
                
                estudiante.setIdEstudiante(fila.getPkIdEstudiante());
                estudiante.setNombre(fila.getNombre());
                estudiante.setPrimerApellido(fila.getPrimerApellido());
                estudiante.setSegundoApellido(fila.getSegundoApellido());
                estudiante.setEmail(fila.getEmail());
                
                vmEstudiantes.add(estudiante);
            }

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Estudiantes.consultaEstudiantes()" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return vmEstudiantes;
    }
}
