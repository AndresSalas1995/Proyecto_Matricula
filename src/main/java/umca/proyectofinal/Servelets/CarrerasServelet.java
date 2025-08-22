/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package umca.proyectofinal.Servelets;

import com.google.gson.Gson;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import umca.proyectofinal.Core.Carreras;
import umca.proyectofinal.Core.Cursos;
import umca.proyectofinal.Modelos.TblCarreras;
import umca.proyectofinal.Modelos.TblCursos;
import umca.proyectofinal.ViewModel.CarrerasVM;

/**
 *
 * @author Waly
 */
@WebServlet(name = "CarrerasServelet", urlPatterns = {"/CarrerasServelet"}, asyncSupported = true)
public class CarrerasServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        Carreras classCarreras = new Carreras();

        List<CarrerasVM> carreras = classCarreras.consultaCarreras();

        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(carreras);
        out.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        processRequest(request, response);

        response.setContentType("application/json; charset=utf-8");
        try {
            Map<String, String[]> params = request.getParameterMap();
            System.out.println(params);

            Cookie[] cookies = request.getCookies();
            String usuarioLogged = "Admin";

            for (Cookie c : cookies) {
                if (c.getName().equals("usuario")) {
                    usuarioLogged = c.getValue();
                }
            }

            TblCarreras tblCarrera = new TblCarreras();
            tblCarrera.setNombreCarrera(request.getParameter("nombre"));
            tblCarrera.setFechaRegistro(new Date());
            tblCarrera.setUsuarioRegistra(usuarioLogged);

            Carreras classCarreras = new Carreras();

            classCarreras.crearCarrera(tblCarrera);

            out.write("{\"estado\": true}");
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.Servelets.CarrerasServelet.doPost()" + e.getMessage());
            out.write("{\"estado\": false}");
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            Carreras carreraCore = new Carreras();
            TblCarreras instanciaCarreras = new TblCarreras();
            response.setContentType("application/json; charset=utf-8");

            Map<String, String[]> params = request.getParameterMap();
            System.out.println(params);

            Cookie[] cookies = request.getCookies();
            String usuarioLogged = "Admin";

            for (Cookie c : cookies) {
                if (c.getName().equals("usuario")) {
                    usuarioLogged = c.getValue();
                }
            }

            instanciaCarreras.setPkIdCarrera(Integer.valueOf(request.getParameter("id")));
            instanciaCarreras.setNombreCarrera(request.getParameter("carrera"));
            instanciaCarreras.setUsuarioRegistra(usuarioLogged);
            instanciaCarreras.setFechaRegistro(new Date());

            carreraCore.actualizarCarrera(instanciaCarreras);

            ObjectMapper ow = new ObjectMapper();
            String json = ow.writeValueAsString("Curso Actualizado exitosamente");

            out.write("{\"estado\": true}");
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.Servelets.CursosServelet.doPost()" + e.getMessage());
            out.write("{\"estado\": false}");
        }
    }
}
