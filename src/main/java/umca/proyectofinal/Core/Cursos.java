/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umca.proyectofinal.Core;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import umca.proyectofinal.Conexion.ConexionDB;
import umca.proyectofinal.Modelos.TblCursos;
import umca.proyectofinal.ViewModel.CursosVM;

/**
 *
 * @author Waly
 */
public class Cursos {

    public Cursos() {
    }

    public TblCursos crearCurso(TblCursos curso) {

        EntityManager entityManager = ConexionDB.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(curso);
            entityManager.flush();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Cursos.crearCurso(TblCursos)" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return curso;
    }

    public void actualizarCurso(TblCursos curso) {
        EntityManager en = ConexionDB.createEntityManager();
        try {

            en.getTransaction().begin();
            en.merge(curso);

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

    public List<CursosVM> consultaCursos() {

        EntityManager entityManager = ConexionDB.createEntityManager();
        List<TblCursos> cursos = new ArrayList<TblCursos>();
        List<CursosVM> vmCursos = new ArrayList<CursosVM>();
        try {
            Query sql = entityManager.createQuery("SELECT c FROM TblCursos c");

            cursos = sql.getResultList();

            for (TblCursos fila : cursos) {
                CursosVM curso = new CursosVM();

                curso.setIdCurso(fila.getPkIdCurso());
                curso.setNombre(fila.getNombreCurso());
                curso.setCodigoCurso(fila.getCodigoCurso());
                curso.setPrecio(fila.getPrecioCurso());

                vmCursos.add(curso);
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Cursos.consultaCursos()" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return vmCursos;
    }
}
