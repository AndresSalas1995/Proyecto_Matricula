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
import umca.proyectofinal.Modelos.TblDetalleMatricula;
import umca.proyectofinal.ViewModel.DetalleMatriculaVM;

/**
 *
 * @author Waly
 */
public class DetalleMatricula {

    public DetalleMatricula() {}

    public TblDetalleMatricula crearDetalleMatricula(TblDetalleMatricula detalleMatricula) {

        EntityManager entityManager = ConexionDB.createEntityManager();
        try {
            
            entityManager.getTransaction().begin();
            entityManager.persist(detalleMatricula);
            entityManager.flush();
            
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.DetalleMatricula.crearDetalleMatricula(TblDetalleMatricula)" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return detalleMatricula;
    }
    
    public List<DetalleMatriculaVM> consultaDetalleMatriculas() {

        EntityManager entityManager = ConexionDB.createEntityManager();
        List<TblDetalleMatricula> detalleMatriculas = new ArrayList<TblDetalleMatricula>();
        List vmDetalleMatriculas = new ArrayList<DetalleMatriculaVM>();
        try {
            Query sql = entityManager.createQuery("SELECT d FROM TblDetalleMatricula d");

            detalleMatriculas = sql.getResultList();
            
            for (TblDetalleMatricula fila : detalleMatriculas) {
                DetalleMatriculaVM detalleMatricula = new DetalleMatriculaVM();
                
                detalleMatricula.setIdDetalleMatricula(fila.getPkidDetalleMatricula());
                detalleMatricula.setCurso(fila.getFkCurso().getPkIdCurso());
                detalleMatricula.setMatricula(fila.getFkMatricula().getFkidmatricula());
                
                vmDetalleMatriculas.add(detalleMatricula);
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("umca.proyectofinal.Core.Matricula.consultaMatriculas()" + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return vmDetalleMatriculas;
    }
}
