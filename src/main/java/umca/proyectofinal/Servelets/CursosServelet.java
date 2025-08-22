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
import static java.lang.System.out;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import umca.proyectofinal.Core.Carreras;
import umca.proyectofinal.Core.CarrerasCursos;
import umca.proyectofinal.Core.Cursos;
import umca.proyectofinal.Core.Usuarios;
import umca.proyectofinal.Modelos.TblCarreraCurso;
import umca.proyectofinal.Modelos.TblCarreras;
import umca.proyectofinal.Modelos.TblCursos;
import umca.proyectofinal.ViewModel.CarrerasVM;
import umca.proyectofinal.ViewModel.CursosVM;

/**
 *
 * @author Waly
 */
@WebServlet(name = "CursosServelet", urlPatterns = {"/CursosServelet"}, asyncSupported = true)
public class CursosServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        Cursos classCursos = new Cursos();

        List<CursosVM> cursos = classCursos.consultaCursos();

        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(cursos);
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

            TblCursos tblCurso = new TblCursos();
            tblCurso.setNombreCurso(request.getParameter("nombre"));
            tblCurso.setCodigoCurso(request.getParameter("codigo"));
            tblCurso.setCreditosCurso(Integer.valueOf(request.getParameter("creditos")));
            tblCurso.setPrecioCurso(Integer.valueOf(request.getParameter("precio")));
            tblCurso.setNombreCurso(request.getParameter("nombre"));
            tblCurso.setFechaRegistro(new Date());
            tblCurso.setUsuarioRegistra(usuarioLogged);
            tblCurso.setUltimoUsuarioModifico(usuarioLogged);

            Cursos classCursos = new Cursos();

            tblCurso = classCursos.crearCurso(tblCurso);

            Carreras classCarrera = new Carreras();

            List<CarrerasVM> carreras = classCarrera.consultaCarreras();
            TblCarreras tblCarrera = new TblCarreras();
            for (CarrerasVM carrera : carreras) {
                if (carrera.getIdCarrera().equals(Integer.valueOf(request.getParameter("carrera")))) {
                    tblCarrera.setPkIdCarrera(carrera.getIdCarrera());
                    tblCarrera.setNombreCarrera(carrera.getNombre());
                }
            }
            TblCarreraCurso tblCarreraCurso = new TblCarreraCurso();
            tblCarreraCurso.setFechaRegistro(new Date());
            tblCarreraCurso.setUsuarioRegistra(usuarioLogged);
            tblCarreraCurso.setFkCarrera(tblCarrera);
            tblCarreraCurso.setFkCurso(tblCurso);

            CarrerasCursos classCarreraCurso = new CarrerasCursos();

            tblCarreraCurso = classCarreraCurso.crearCarreraCurso(tblCarreraCurso);

            out.write("{\"estado\": true}");
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.Servelets.CursosServelet.doPost()" + e.getMessage());
            out.write("{\"estado\": false}");
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        try {
            Cursos cursosCore = new Cursos();
            TblCursos instanciaCursos = new TblCursos();
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

            instanciaCursos.setPkIdCurso(Integer.valueOf(request.getParameter("id")));
            instanciaCursos.setNombreCurso(request.getParameter("nombre"));
            instanciaCursos.setCodigoCurso(request.getParameter("codigo"));
            instanciaCursos.setCreditosCurso(Integer.valueOf(request.getParameter("creditos")));
            instanciaCursos.setPrecioCurso(Integer.valueOf(request.getParameter("precio")));
            instanciaCursos.setNombreCurso(request.getParameter("nombre"));
            instanciaCursos.setFechaRegistro(new Date());
            instanciaCursos.setUsuarioRegistra(usuarioLogged);
            instanciaCursos.setUltimoUsuarioModifico(usuarioLogged);

            cursosCore.actualizarCurso(instanciaCursos);

            ObjectMapper ow = new ObjectMapper();
            String json = ow.writeValueAsString("Curso Actualizado exitosamente");

            out.write("{\"estado\": true}");
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.Servelets.CursosServelet.doPost()" + e.getMessage());
            out.write("{\"estado\": false}");
        }
    }
}
