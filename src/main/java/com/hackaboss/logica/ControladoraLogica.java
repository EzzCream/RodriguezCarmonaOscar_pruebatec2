
package com.hackaboss.logica;

import com.hackaboss.persistencia.ControladoraPersistencia;
import com.hackaboss.persistencia.exceptions.NonexistentEntityException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ControladoraLogica {

    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    public void crearCiudadano(String nombre, String apellido, String email, String telefono, String curp) {
        Ciudadano ciudadano = new Ciudadano(nombre, apellido, telefono, email, curp);
        controladoraPersistencia.crearCiudadano(ciudadano);
    }
    public List<Ciudadano> listarCiudadanos(String curp) {
        return controladoraPersistencia.traerCiudadanosCurp(curp);
    }
    public void eliminarCiudadano(Integer id) {
        try {
            controladoraPersistencia.eliminarCiudadano(id);
        } catch (NonexistentEntityException e) {
            throw new RuntimeException(e);
        }
    }

    public Ciudadano listarCiudadano(Integer id) {
        return controladoraPersistencia.listarCiudadano(id);
    }

    public void actualizarCiudadano(Ciudadano ciudadano) {
        controladoraPersistencia.actualizarCiudadano(ciudadano);
    }

    //Funcion Lamda
    public boolean validar(String username, String password) {
        return Optional.ofNullable(controladoraPersistencia.buscarUsuario(username))
            .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
            .isPresent();
    }

    public List<Turno> listaTurnos() {
        return controladoraPersistencia.listaTurnos();
    }

    public List<Turno> listaTurnosEstado(String estado) {
        return controladoraPersistencia.traerTurnoEstado(estado);
    }

    public void createTramite(String nombreTramite, String descripcion) {
        Tramite tramite = new Tramite(nombreTramite, descripcion);
        controladoraPersistencia.crearTramite(tramite);
    }

    public Tramite lsitarTramiteNombre(String nombreTramite) {
        return controladoraPersistencia.listarTramiteNombre(nombreTramite);
    }

    public void createTurno(Integer numeroTurno, LocalDate fecha, String estado, Ciudadano ciudadano, Tramite tramite, Usuario usuario) {
        Turno turno = new Turno(numeroTurno, fecha, estado, ciudadano, tramite, usuario);
        controladoraPersistencia.crearTurno(turno);
    }

    public Usuario listarUsuario(String admin1) {
        return controladoraPersistencia.buscarUsuario(admin1);
    }

    public Object listarCiudadano(String curp) {
        return controladoraPersistencia.traerCiudadanoCurp(curp);
    }
}
