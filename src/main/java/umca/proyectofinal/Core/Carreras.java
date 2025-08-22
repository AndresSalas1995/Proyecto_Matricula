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
import umca.proyectofinal.Modelos.TblCarreras;
import umca.proyectofinal.Modelos.TblCursos;
import umca.proyectofinal.ViewModel.CarrerasVM;
import umca.proyectofinal.ViewModel.TipoUsuario;

/**
 *
 * @author Waly
 */
public class Carreras {

    public Carreras() {}

    public TblCarreras crearCarrera(TblCarreras carrera) {

        EntityManager entityManager = ConexionDB.createEntityManager();
        try {
            
            entityManager.getTransaction().begin();
            entityManager.persist(carrera);
            entityManager.flush();
            
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Carreras.crearCarrera(TblCarreras)" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return carrera;
    }
    
    public void actualizarCarrera(TblCarreras carrera) {
        EntityManager en = ConexionDB.createEntityManager();
        try {

            en.getTransaction().begin();
            en.merge(carrera);

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
    
    public List<CarrerasVM> consultaCarreras() {

        EntityManager entityManager = ConexionDB.createEntityManager();
        List<TblCarreras> carreras = new ArrayList<TblCarreras>();
        List vmCarreras = new ArrayList<CarrerasVM>();
        try {
            Query sql = entityManager.createQuery("SELECT c FROM TblCarreras c");

            carreras = sql.getResultList();
            
            for (TblCarreras fila : carreras) {
                CarrerasVM carrera = new CarrerasVM();
                
                carrera.setIdCarrera(fila.getPkIdCarrera());
                carrera.setNombre(fila.getNombreCarrera());
                
                vmCarreras.add(carrera);
            }

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Carreras.consultaCarreras()" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return vmCarreras;
    }
}
