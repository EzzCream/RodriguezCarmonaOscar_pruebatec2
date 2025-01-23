package com.hackaboss.servlets;

import com.hackaboss.logica.Ciudadano;
import com.hackaboss.logica.ControladoraLogica;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CiudadanoSv", urlPatterns = {"/CiudadanoSv"})
public class CiudadanoSv extends HttpServlet {
    
    ControladoraLogica controladoraLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String curp = request.getParameter("curp");
        List<Ciudadano> listaCiudadanos = controladoraLogica.listarCiudadanos(curp);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaCiudadanos", listaCiudadanos);
        response.sendRedirect("pages/ciudadanoMenu.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            Integer id = 0;
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            String curp = request.getParameter("curp");
        System.out.println(curp);
            controladoraLogica.crearCiudadano(nombre, apellido, email, telefono, curp);
            List<Ciudadano> listaCiudadanos = controladoraLogica.listarCiudadanos(curp);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("listaCiudadanos", listaCiudadanos);
            response.sendRedirect("pages/ciudadanoMenu.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
