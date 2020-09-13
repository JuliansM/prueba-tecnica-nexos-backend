package com.nexos.demo.models.builders;

import com.nexos.demo.models.dto.DetalleFacturaDTO;
import com.nexos.demo.models.dto.FacturaDTO;

import java.math.BigDecimal;
import java.util.List;

public class ClienteFacturaBuilder {

    private String idCliente;
    private String nombreCliente;
    private String apellido1Cliente;
    private String apellido2Cliente;
    private List<FacturaDTO> facturaDTOS;
    private List<DetalleFacturaDTO> detalleFacturaDTOS;
    private BigDecimal valorTotalGastado = BigDecimal.ZERO;

    public void calcularValorTotalGastado(BigDecimal valor) {
        setValorTotalGastado(getValorTotalGastado().add(valor));
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellido1Cliente() {
        return apellido1Cliente;
    }

    public void setApellido1Cliente(String apellido1Cliente) {
        this.apellido1Cliente = apellido1Cliente;
    }

    public String getApellido2Cliente() {
        return apellido2Cliente;
    }

    public void setApellido2Cliente(String apellido2Cliente) {
        this.apellido2Cliente = apellido2Cliente;
    }

    public List<FacturaDTO> getFacturaDTOS() {
        return facturaDTOS;
    }

    public void setFacturaDTOS(List<FacturaDTO> facturaDTOS) {
        this.facturaDTOS = facturaDTOS;
    }

    public List<DetalleFacturaDTO> getDetalleFacturaDTOS() {
        return detalleFacturaDTOS;
    }

    public void setDetalleFacturaDTOS(List<DetalleFacturaDTO> detalleFacturaDTOS) {
        this.detalleFacturaDTOS = detalleFacturaDTOS;
    }

    public BigDecimal getValorTotalGastado() {
        return valorTotalGastado;
    }

    public void setValorTotalGastado(BigDecimal valorTotalGastado) {
        this.valorTotalGastado = valorTotalGastado;
    }
}
