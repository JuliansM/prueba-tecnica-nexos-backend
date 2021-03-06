package com.nexos.demo.models.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class DetalleFacturaDTO {

    private Integer idDetalleFactura;

    private Integer idFactura;

    @NotNull
    private String idCocinero;

    @NotNull
    private String plato;

    @NotNull
    private BigDecimal importe;

    private BigDecimal descuento = BigDecimal.ZERO;

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

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = new BigDecimal(descuento);
    }

    public void aplicarDescuento() {
        if (descuento.compareTo(BigDecimal.ZERO) == 1) {
            setImporte(importe.subtract(importe.multiply(descuento)));
        }
    }
}
