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

@WebServlet(name = "ActualizarCiudadanoSv", urlPatterns = {"/ActualizarCiudadanoSv"})
public class ActualizarCiudadanoSv extends HttpServlet {

    ControladoraLogica controladoraLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Ciudadano ciudadano = controladoraLogica.listarCiudadano(id);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("ciudadanoActualizar", ciudadano);
        response.sendRedirect("./pages/actualizarCiudadano.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String curp = request.getParameter("curp");

        Ciudadano ciudadano = (Ciudadano) request.getSession().getAttribute("ciudadanoActualizar");

        ciudadano.setNombre(nombre);
        ciudadano.setApellido(apellido);
        ciudadano.setEmail(email);
        ciudadano.setTelefono(telefono);
        ciudadano.setCurp(curp);

        controladoraLogica.actualizarCiudadano(ciudadano);

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
