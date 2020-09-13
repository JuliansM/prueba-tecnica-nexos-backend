package com.nexos.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mesas")
public class Mesa {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_mesa")
    private Integer idMesa;

    @Column(name = "num_max_comensa")
    private Integer numMaxComensa;

    @Column(name = "ubicacion")
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
