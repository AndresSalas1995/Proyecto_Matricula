/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package umca.proyectofinal.Servelets;

import com.google.gson.Gson;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import umca.proyectofinal.Core.DetalleMatricula;
import umca.proyectofinal.ViewModel.DetalleMatriculaVM;

/**
 *
 * @author Waly
 */
@WebServlet(name = "DetalleMatriculaServelet", urlPatterns = {"/DetalleMatriculaServelet"}, asyncSupported = true)
public class DetalleMatriculaServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        DetalleMatricula classDetalleMatricula = new DetalleMatricula();

        List<DetalleMatriculaVM> matriculas = classDetalleMatricula.consultaDetalleMatriculas();

        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(matriculas);
        out.write(json);
    }
}
