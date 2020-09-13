package com.nexos.demo.models.dto;

import javax.validation.constraints.NotNull;

public class MesaDTO {

    @NotNull
    private Integer idMesa;
    private Integer numMaxComensa;
    private String ubicacion;

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getNumMaxComensa() {
        return numMaxComensa;
    }

    public void setNumMaxComensa(Integer numMaxComensa) {
        this.numMaxComensa = numMaxComensa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
