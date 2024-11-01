package com.clase5.clase5.model;

import java.time.LocalDateTime;

public class HorarioAcceso {

    private Long id;
    private String cliente;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;

    public HorarioAcceso() {
    }

    public HorarioAcceso(Long id, String cliente, LocalDateTime horaInicio, LocalDateTime horaFin) {
        this.id = id;
        this.cliente = cliente;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "HorarioAcceso{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                '}';
    }
}
