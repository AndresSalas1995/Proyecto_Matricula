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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import umca.proyectofinal.Core.Carreras;
import umca.proyectofinal.Core.Cursos;
import umca.proyectofinal.Core.DetalleMatricula;
import umca.proyectofinal.Core.Estudiantes;
import umca.proyectofinal.Core.Matricula;
import umca.proyectofinal.Modelos.TblCarreras;
import umca.proyectofinal.Modelos.TblCursos;
import umca.proyectofinal.Modelos.TblDetalleMatricula;
import umca.proyectofinal.Modelos.TblEstudiantes;
import umca.proyectofinal.Modelos.TblMatricula;
import umca.proyectofinal.Modelos.TbltipoUsuario;
import umca.proyectofinal.ViewModel.CarrerasVM;
import umca.proyectofinal.ViewModel.CursosVM;
import umca.proyectofinal.ViewModel.EstudiantesVM;
import umca.proyectofinal.ViewModel.MatriculaVM;

/**
 *
 * @author Waly
 */
@WebServlet(name = "MatriculaServelet", urlPatterns = {"/MatriculaServelet"}, asyncSupported = true)
public class MatriculaServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        Matricula classMatriculas = new Matricula();

        List<MatriculaVM> matriculas = classMatriculas.consultaMatriculas();

        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(matriculas);
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
            
            TblMatricula tblMatricula = new TblMatricula();
            tblMatricula.setSubtotal(Integer.valueOf(request.getParameter("subtotal")));
            tblMatricula.setIva(Integer.valueOf(request.getParameter("iva")));
            tblMatricula.setTotal(Integer.valueOf(request.getParameter("total")));
            tblMatricula.setFechaRegistro(new Date());
            tblMatricula.setUsuarioRegistra(usuarioLogged);

            Carreras classCarreras = new Carreras();

            List<CarrerasVM> carreras = classCarreras.consultaCarreras();
            TblCarreras carrera = new TblCarreras();
            for (CarrerasVM c : carreras) { 
                if(c.getIdCarrera().equals(Integer.valueOf(request.getParameter("carrera")))) {
                    carrera.setPkIdCarrera(c.getIdCarrera());
                    carrera.setNombreCarrera(c.getNombre());
                }
            }
            tblMatricula.setFkCarrera(carrera);

            Estudiantes classEstudiantes = new Estudiantes();
            
            List<EstudiantesVM> estudiantes = classEstudiantes.consultaEstudiantes();
            TblEstudiantes estudiante = new TblEstudiantes();
            for (EstudiantesVM est : estudiantes) { 
                if(est.getIdEstudiante().equals(Integer.valueOf(request.getParameter("estudiante")))) {
                    estudiante.setPkIdEstudiante(est.getIdEstudiante());
                    estudiante.setNombre(est.getNombre());
                }
            }
            tblMatricula.setFkEstudiante(estudiante);
            
            Matricula classMatricula = new Matricula();
            
            tblMatricula = classMatricula.crearMatricula(tblMatricula);

            DetalleMatricula classDetalleMatricula = new DetalleMatricula();
            Cursos classCursos = new Cursos();
            
            List<CursosVM> cursos = classCursos.consultaCursos();
            String[] cursosIds = request.getParameter("cursos").split(",");
            
            for (String curso : cursosIds) {
                for (CursosVM cursoVM : cursos) {
                    if (Integer.valueOf(curso).equals(cursoVM.getIdCurso())) {
                        
                        TblCursos c = new TblCursos();
                        c.setPkIdCurso(cursoVM.getIdCurso());
                        
                        TblDetalleMatricula tblDetalleMatricula = new TblDetalleMatricula();
                        tblDetalleMatricula.setFkMatricula(tblMatricula);
                        tblDetalleMatricula.setFkCurso(c);
                        tblDetalleMatricula.setPrecio(cursoVM.getPrecio());
                        tblDetalleMatricula.setFecha(new Date());
                        tblDetalleMatricula.setUsuarioRegistra(usuarioLogged);
                        
                        classDetalleMatricula.crearDetalleMatricula(tblDetalleMatricula);
                    }
                }
            }
            
            out.write("{\"estado\": true}");
        } catch (Exception e) {
            System.out.println("umca.proyectofinal.Servelets.MatriculaServelet.doPost()" + e.getMessage());
            out.write("{\"estado\": false}");
        }
    }
}
