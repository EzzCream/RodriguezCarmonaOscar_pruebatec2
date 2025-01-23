package com.hackaboss.servlets;

import com.hackaboss.logica.ControladoraLogica;
import com.hackaboss.logica.Turno;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "TurnoSv", urlPatterns = {"/TurnoSv"})
public class TurnoSv extends HttpServlet {

    ControladoraLogica controladoraLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Turno> listaTurnos = controladoraLogica.listaTurnos();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaTurnos", listaTurnos);
        response.sendRedirect("pages/turnos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        List<Turno> listaTurnos = controladoraLogica.listaTurnosEstado(estado);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaTurnos", listaTurnos);
        response.sendRedirect("pages/turnos.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
