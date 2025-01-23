package com.hackaboss.logica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tramite", schema = "turnero")
public class Tramite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite", nullable = false)
    private Integer id;

    @Column(name = "nombre_tramite", nullable = false, length = 100)
    private String nombreTramite;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTramite() {
        return nombreTramite;
    }

    public void setNombreTramite(String nombreTramite) {
        this.nombreTramite = nombreTramite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}