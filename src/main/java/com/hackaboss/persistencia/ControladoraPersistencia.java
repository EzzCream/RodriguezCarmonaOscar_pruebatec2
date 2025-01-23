package com.hackaboss.persistencia;

import com.hackaboss.logica.Ciudadano;
import com.hackaboss.logica.Usuario;
import com.hackaboss.persistencia.exceptions.NonexistentEntityException;

import java.util.List;

public class ControladoraPersistencia {

    CiudadanoJpaController ciudadanoJpa = new CiudadanoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();

    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJpa.create(ciudadano);
    }
    public List<Ciudadano> traerCiudadanosApellido(String curp) {
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
}
