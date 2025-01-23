package com.hackaboss.persistencia;

import com.hackaboss.logica.Ciudadano;
import com.hackaboss.logica.Tramite;
import com.hackaboss.logica.Turno;
import com.hackaboss.logica.Usuario;
import com.hackaboss.persistencia.exceptions.NonexistentEntityException;

import java.util.List;

public class ControladoraPersistencia {

    CiudadanoJpaController ciudadanoJpa = new CiudadanoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    TurnoJpaController turnoJpa = new TurnoJpaController();
    TramiteJpaController tramiteJpa = new TramiteJpaController();

    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJpa.create(ciudadano);
    }

    public List<Ciudadano> traerCiudadanosCurp(String curp) {
        return ciudadanoJpa.getCiudadanosByCurp(curp);
    }
    public void eliminarCiudadano(Integer id) throws NonexistentEntityException {
        ciudadanoJpa.destroy(id);
    }

    public Ciudadano listarCiudadano(Integer id) {
        return ciudadanoJpa.findCiudadano(id);
    }

    public void actualizarCiudadano(Ciudadano ciudadano) {
        try {
            ciudadanoJpa.edit(ciudadano);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario buscarUsuario(String username) {
        return usuarioJpa.getUsuario(username);
    }

    public List<Turno> listaTurnos() {
        return turnoJpa.findAll();
    }

    public List<Turno> traerTurnoEstado(String estado) {
        return turnoJpa.findTurnoByEstado(estado);
    }

    public void crearTramite(Tramite tramite) {
        tramiteJpa.create(tramite);
    }

    public Tramite listarTramiteNombre(String nombreTramite) {
        return tramiteJpa.getTramiteByName(nombreTramite);
    }

    public void crearTurno(Turno turno) {
        turnoJpa.create(turno);
    }

    public Object traerCiudadanoCurp(String curp) {
        return ciudadanoJpa.getCiudadanoByCurp(curp);
    }
}
