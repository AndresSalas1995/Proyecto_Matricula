/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package umca.proyectofinal.Servelets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import umca.proyectofinal.Core.Usuarios;
import umca.proyectofinal.Modelos.TblUsuario;
import umca.proyectofinal.Modelos.TbltipoUsuario;
import umca.proyectofinal.ViewModel.TipoUsuario;
import umca.proyectofinal.ViewModel.UsuarioVM;

/**
 *
 * @author Waly
 */
@WebServlet(name = "AuthenticationServelet", urlPatterns = {"/AuthenticationServelet"}, asyncSupported = true)
public class AuthenticationServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        try {
            Cookie[] cookies = request.getCookies();
            String usuarioLoggedString = "";
            
            for (Cookie c : cookies) {
                if (c.getName().equals("usuario")) {
                    usuarioLoggedString = c.getValue();
                }
            }
            
            if (!usuarioLoggedString.equals("")) {
                Usuarios classUsuario = new Usuarios();

                List<UsuarioVM> usuarios = classUsuario.consultaUsuarios();
                UsuarioVM usuarioLogged = new UsuarioVM();
                for (UsuarioVM usuario : usuarios) { 
                    if (usuario.getNombreUsuario().equals(String.valueOf(usuarioLoggedString))) {
                        usuarioLogged = usuario;
                    }
                }
                
                out.write("{\"estado\": true, \"tipoUsuario\": " + usuarioLogged.getTipoUsuario() + "}");
            } else {
                out.write("{\"estado\": false}");
            }
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.Servelets.AuthenticationServelet.doGet()" + e.getMessage());
            out.write("{\"estado\": false}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        processRequest(request, response);

        response.setContentType("application/json; charset=utf-8");
        try {            
            boolean logged = request.authenticate(response);
            
            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");
            
            TblUsuario user = new TblUsuario();
            
            user.setNombreUsuario(usuario);
            user.setContrasena(contrasena);
            
            Usuarios classUsuarios = new Usuarios();
            
            boolean success = classUsuarios.login(user);
            
            if (success) {
                Cookie loginCookie = new Cookie("usuario",usuario);
                loginCookie.setMaxAge(30*60);
                response.addCookie(loginCookie);

                out.write("{\"estado\": true}");
            } else {
                out.write("{\"estado\": false}");
            }
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.Servelets.AuthenticationServelet.doPost()" + e.getMessage());
            out.write("{\"estado\": false}");
        }
    }
}
