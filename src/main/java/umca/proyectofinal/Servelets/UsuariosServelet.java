/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package umca.proyectofinal.Servelets;

import com.google.gson.Gson;
import jakarta.persistence.Query;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.codehaus.jackson.map.ObjectMapper;
import umca.proyectofinal.Conexion.ConexionDB;
import umca.proyectofinal.Core.Usuarios;
import umca.proyectofinal.Modelos.TblUsuario;
import umca.proyectofinal.Modelos.TbltipoUsuario;
import umca.proyectofinal.ViewModel.TipoUsuario;
import umca.proyectofinal.ViewModel.UsuarioVM;

/**
 *
 * @author Waly
 */
@WebServlet(name = "UsuariosServelet", urlPatterns = {"/UsuariosServelet"}, asyncSupported = true)
public class UsuariosServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        Usuarios classUsuarios = new Usuarios();

        List<UsuarioVM> usuarios = classUsuarios.consultaUsuarios();

        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(usuarios);
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
            System.out.println("umca.proyectofinal.Servelets.UsuariosServelet.doPost()" + e.getMessage());
            out.write("{\"estado\": false}");
        }
    }

}
