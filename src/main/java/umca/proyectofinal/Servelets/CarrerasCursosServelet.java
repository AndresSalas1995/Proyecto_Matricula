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
import umca.proyectofinal.Core.Carreras;
import umca.proyectofinal.Core.CarrerasCursos;
import umca.proyectofinal.Modelos.TblCarreras;
import umca.proyectofinal.ViewModel.CarrerasCursosVM;

/**
 *
 * @author Waly
 */
@WebServlet(name = "CarrerasCursosServelet", urlPatterns = {"/CarrerasCursosServelet"}, asyncSupported = true)
public class CarrerasCursosServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        CarrerasCursos classCarrerasCursos = new CarrerasCursos();

        List<CarrerasCursosVM> carrerasCursos = classCarrerasCursos.consultaCarrerasCursos();

        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(carrerasCursos);
        out.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        processRequest(request, response);

        response.setContentType("application/json; charset=utf-8");
        try {
            Map<String,String[]> params = request.getParameterMap();
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
}
