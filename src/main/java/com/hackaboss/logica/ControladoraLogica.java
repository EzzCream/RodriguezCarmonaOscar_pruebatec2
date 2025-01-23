
package com.hackaboss.logica;

import com.hackaboss.persistencia.ControladoraPersistencia;
import com.hackaboss.persistencia.exceptions.NonexistentEntityException;

import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    public void crearCiudadano(String nombre, String apellido, String email, String telefono, String curp) {
        Ciudadano ciudadano = new Ciudadano(nombre, apellido, telefono, email, curp);
        controladoraPersistencia.crearCiudadano(ciudadano);
    }
    public List<Ciudadano> listarCiudadanos(String curp) {
        return controladoraPersistencia.traerCiudadanosApellido(curp);
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

    public boolean validar(String username, String password) {
        Usuario user = controladoraPersistencia.buscarUsuario(username);
        if(user!= null){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
