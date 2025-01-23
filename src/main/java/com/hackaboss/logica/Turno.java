package com.hackaboss.logica;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turno", schema = "turnero")
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno", nullable = false)
    private Integer id;

    @Column(name = "numero_turno", nullable = false)
    private Integer numeroTurno;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ciudadano", nullable = false)
    private Ciudadano idCiudadano;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tramite", nullable = false)
    private Tramite idTramite;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    public Turno() {
    }

    public Turno(Integer numeroTurno, LocalDate fecha, String estado, Ciudadano idCiudadano, Tramite idTramite, Usuario idUsuario) {
        this.numeroTurno = numeroTurno;
        this.fecha = fecha;
        this.estado = estado;
        this.idCiudadano = idCiudadano;
        this.idTramite = idTramite;
        this.idUsuario = idUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(Integer numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciudadano getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(Ciudadano idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public Tramite getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Tramite idTramite) {
        this.idTramite = idTramite;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

}