package umca.proyectofinal.Conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Waly
 */
public class ConexionDB {
    private static EntityManagerFactory entityManager = null;

    public static EntityManager createEntityManager() {

        try {
            if (entityManager == null) {
                entityManager = Persistence.createEntityManagerFactory("umca_ProyectoFinal_war_v1.0PU");
            }
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.conexion.ConexionDB.<init>()" + e.getMessage());
        }

        return entityManager.createEntityManager();
    }
}
