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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import umca.proyectofinal.Core.Cursos;
import umca.proyectofinal.Core.Estudiantes;
import umca.proyectofinal.Core.Usuarios;
import umca.proyectofinal.Modelos.TblCursos;
import umca.proyectofinal.Modelos.TblEstudiantes;
import umca.proyectofinal.Modelos.TblUsuario;
import umca.proyectofinal.Modelos.TbltipoUsuario;
import umca.proyectofinal.ViewModel.EstudiantesVM;
import umca.proyectofinal.ViewModel.TipoUsuario;

/**
 *
 * @author Waly
 */
@WebServlet(name = "EstudiantesServelet", urlPatterns = {"/EstudiantesServelet"}, asyncSupported = true)
public class EstudiantesServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        Estudiantes classEstudiante = new Estudiantes();

        List<EstudiantesVM> estudiantes = classEstudiante.consultaEstudiantes();

        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(estudiantes);
        out.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        processRequest(request, response);

        response.setContentType("application/json; charset=utf-8");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

            TblEstudiantes tblEstudiante = new TblEstudiantes();
            tblEstudiante.setNombre(request.getParameter("nombre"));
            tblEstudiante.setPrimerApellido(request.getParameter("apellidoUno"));
            tblEstudiante.setSegundoApellido(request.getParameter("apellidoDos"));
            tblEstudiante.setNumeroCedula(request.getParameter("numeroCedula"));
            LocalDate localDate = LocalDate.parse(request.getParameter("fechaNacimiento"), formatter);
            Date date = java.sql.Date.valueOf(localDate);
            tblEstudiante.setFechaNacimiento(date);
            tblEstudiante.setDireccionResidencia(request.getParameter("direccionResidencia"));
            tblEstudiante.setEmail(request.getParameter("email"));
            tblEstudiante.setNumeroTelefono(request.getParameter("numeroTelefono"));
            tblEstudiante.setFechaRegistro(new Date());
            tblEstudiante.setUsuarioRegistra(usuarioLogged);

            Estudiantes classEstudiante = new Estudiantes();

            classEstudiante.crearEstudiante(tblEstudiante);

            TblUsuario tblUsuario = new TblUsuario();
            tblUsuario.setNombre(request.getParameter("nombre"));
            tblUsuario.setPrimerApellido(request.getParameter("apellidoUno"));
            tblUsuario.setSegundoApellido(request.getParameter("apellidoDos"));
            tblUsuario.setNombreUsuario(request.getParameter("nombreUsuario"));
            tblUsuario.setEmail(request.getParameter("email"));
            tblUsuario.setContrasena(request.getParameter("contrasena"));
            tblUsuario.setFechaRegistro(new Date());
            tblUsuario.setUsuarioRegistro(usuarioLogged);
            tblUsuario.setUltimoUsuarioModifico(usuarioLogged);

            Usuarios classUsuario = new Usuarios();

            List<TipoUsuario> tipos = classUsuario.consultaTiposUsuario();
            TbltipoUsuario tipo = new TbltipoUsuario();
            for (TipoUsuario tipoUsuario : tipos) {
                if (tipoUsuario.getIdTipo().equals(Integer.valueOf(request.getParameter("tipoUsuario")))) {
                    tipo.setPkIdTipo(tipoUsuario.getIdTipo());
                    tipo.setTipoUsuario(tipoUsuario.getNombre());
                }
            }
            tblUsuario.setFkTipoUsuario(tipo);

            classUsuario.crearUsuario(tblUsuario);

            out.write("{\"estado\": true}");
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.Servelets.CursosServelet.doPost()" + e.getMessage());
            out.write("{\"estado\": false}");
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            Estudiantes estudianteCore = new Estudiantes();
            TblEstudiantes instanciaEstudiantes = new TblEstudiantes();
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
            instanciaEstudiantes.setPkIdEstudiante(Integer.valueOf(request.getParameter("id")));
            instanciaEstudiantes.setNombre(request.getParameter("nombre"));
            instanciaEstudiantes.setPrimerApellido(request.getParameter("apellidoUno"));
            instanciaEstudiantes.setSegundoApellido(request.getParameter("apellidoDos"));
            instanciaEstudiantes.setNumeroCedula(request.getParameter("numeroCedula"));
            LocalDate localDate = LocalDate.parse(request.getParameter("fechaNacimiento"), formatter);
            Date date = java.sql.Date.valueOf(localDate);
            instanciaEstudiantes.setFechaNacimiento(date);
            instanciaEstudiantes.setDireccionResidencia(request.getParameter("direccionResidencia"));
            instanciaEstudiantes.setNumeroTelefono(request.getParameter("numeroTelefono"));
            instanciaEstudiantes.setFechaRegistro(new Date());
            instanciaEstudiantes.setUsuarioRegistra(usuarioLogged);

            estudianteCore.actualizarEstudiante(instanciaEstudiantes);

            ObjectMapper ow = new ObjectMapper();
            String json = ow.writeValueAsString("Estudiante Actualizado exitosamente");

            out.write("{\"estado\": true}");
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.Servelets.CursosServelet.doPost()" + e.getMessage());
            out.write("{\"estado\": false}");
        }
    }
}
