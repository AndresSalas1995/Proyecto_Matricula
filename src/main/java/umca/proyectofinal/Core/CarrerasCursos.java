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
import umca.proyectofinal.Modelos.TblCarreraCurso;
import umca.proyectofinal.ViewModel.CarrerasCursosVM;

/**
 *
 * @author Waly
 */
public class CarrerasCursos {

    public CarrerasCursos() {}

    public TblCarreraCurso crearCarreraCurso(TblCarreraCurso carreraCurso) {

        EntityManager entityManager = ConexionDB.createEntityManager();
        try {
            
            entityManager.getTransaction().begin();
            entityManager.persist(carreraCurso);
            entityManager.flush();
            
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.CarrerasCursos.crearCarreraCurso(TblCarreraCurso)" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return carreraCurso;
    }
    
    public List<CarrerasCursosVM> consultaCarrerasCursos() {

        EntityManager entityManager = ConexionDB.createEntityManager();
        List<TblCarreraCurso> carreras = new ArrayList<TblCarreraCurso>();
        List vmCarrerasCursos = new ArrayList<CarrerasCursosVM>();
        try {
            Query sql = entityManager.createQuery("SELECT cc FROM TblCarreraCurso cc");

            carreras = sql.getResultList();
            
            for (TblCarreraCurso fila : carreras) {
                CarrerasCursosVM carreraCurso = new CarrerasCursosVM();
                
                carreraCurso.setIdCarreraCurso(fila.getPkIdCarreraCurso());
                carreraCurso.setCarrera(fila.getFkCarrera().getPkIdCarrera());
                carreraCurso.setCurso(fila.getFkCurso().getPkIdCurso());
                
                vmCarrerasCursos.add(carreraCurso);
            }

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.CarrerasCursos.consultaCarrerasCursos()" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return vmCarrerasCursos;
    }
}
