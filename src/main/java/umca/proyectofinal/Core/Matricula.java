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
import umca.proyectofinal.Modelos.TblMatricula;
import umca.proyectofinal.ViewModel.MatriculaVM;

/**
 *
 * @author Waly
 */
public class Matricula {

    public Matricula() {}

    public TblMatricula crearMatricula(TblMatricula matricula) {

        EntityManager entityManager = ConexionDB.createEntityManager();
        try {
            
            entityManager.getTransaction().begin();
            entityManager.persist(matricula);
            entityManager.flush();
            
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Matricula.crearMatricula(TblMatricula)" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return matricula;
    }
    
    public List<MatriculaVM> consultaMatriculas() {

        EntityManager entityManager = ConexionDB.createEntityManager();
        List<TblMatricula> matriculas = new ArrayList<TblMatricula>();
        List vmMatriculas = new ArrayList<MatriculaVM>();
        try {
            Query sql = entityManager.createQuery("SELECT m FROM TblMatricula m");

            matriculas = sql.getResultList();
            
            for (TblMatricula fila : matriculas) {
                MatriculaVM matricula = new MatriculaVM();
                
                matricula.setIdMatricula(fila.getFkidmatricula());
                matricula.setSubtotal(fila.getSubtotal());
                matricula.setIva(fila.getIva());
                matricula.setTotal(fila.getTotal());
                matricula.setCarrera(fila.getFkCarrera().getPkIdCarrera());
                matricula.setEstudiante(fila.getFkEstudiante().getPkIdEstudiante());
                
                vmMatriculas.add(matricula);
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Matricula.consultaMatriculas()" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return vmMatriculas;
    }
}
