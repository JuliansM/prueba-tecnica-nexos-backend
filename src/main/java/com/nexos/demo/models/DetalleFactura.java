package com.nexos.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "detalles_facturas")
public class DetalleFactura {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_detalle_factura")
    private Integer idDetalleFactura;

    @NotNull
    @Column(name = "fk_id_factura")
    private Integer idFactura;

    @NotNull
    @Column(name = "fk_id_cocinero")
    private String idCocinero;

    @NotNull
    @Column(name = "plato")
    private String plato;

    @NotNull
    @Column(name = "importe")
    private BigDecimal importe = BigDecimal.ZERO;

    public Integer getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(String idCocinero) {
        this.idCocinero = idCocinero;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

}
