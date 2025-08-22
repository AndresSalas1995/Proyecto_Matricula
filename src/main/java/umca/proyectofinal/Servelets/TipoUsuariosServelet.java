/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package umca.proyectofinal.Servelets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import umca.proyectofinal.Core.Usuarios;
import umca.proyectofinal.ViewModel.TipoUsuario;

/**
 *
 * @author Waly
 */
@WebServlet(name = "TipoUsuariosServelet", urlPatterns = {"/TipoUsuariosServelet"}, asyncSupported = true)
public class TipoUsuariosServelet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        Usuarios classUsuario = new Usuarios();

        List<TipoUsuario> tipos = classUsuario.consultaTiposUsuario();

        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(tipos);
        out.write(json);
    }
}
