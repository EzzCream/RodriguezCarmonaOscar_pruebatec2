package com.hackaboss.servlets;

import com.hackaboss.logica.Ciudadano;
import com.hackaboss.logica.ControladoraLogica;
import com.hackaboss.logica.Tramite;
import com.hackaboss.logica.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TramiteSv", urlPatterns = {"/TramiteSv"})
public class TramiteSv extends HttpServlet {

    ControladoraLogica controladoraLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreTramite = request.getParameter("nombreTramite");
        String descripcion = request.getParameter("descripcion");
        controladoraLogica.createTramite(nombreTramite,descripcion);
        Tramite tramite = controladoraLogica.lsitarTramiteNombre(nombreTramite);

        String curp = request.getParameter("curp");
        Ciudadano ciudadano = (Ciudadano) controladoraLogica.listarCiudadano(curp);

        Usuario usuario = controladoraLogica.listarUsuario("admin1");

        String fecha = request.getParameter("fecha");
        LocalDate newFecha = utils.FechaUtil.fechaFormato(fecha);
        Integer numeroTurno = Integer.valueOf(request.getParameter("numeroTurno"));
        String estado = "En espera";
        controladoraLogica.createTurno(numeroTurno, newFecha,  estado, ciudadano, tramite, usuario);
        response.sendRedirect("pages/ciudadanoMenu.jsp");

    }

    public String getServletInfo() {
        return "Short description";
    }

}
