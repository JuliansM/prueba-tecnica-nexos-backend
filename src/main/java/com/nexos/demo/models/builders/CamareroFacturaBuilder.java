package com.nexos.demo.models.builders;

import com.nexos.demo.models.dto.DetalleFacturaDTO;
import com.nexos.demo.models.dto.FacturaDTO;

import java.time.LocalDateTime;
import java.util.List;

public class CamareroFacturaBuilder {

    private String idCamarero;
    private String nombreCamarero;
    private String apellido1Camarero;
    private List<FacturaDTO> facturaDTOS;
    private List<DetalleFacturaDTO> detalleFacturaDTOS;
    private String mes;

    public void obtenerMes(LocalDateTime fechaFactura) {
        setMes(fechaFactura.getMonth().toString());
    }

    public String getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(String idCamarero) {
        this.idCamarero = idCamarero;
    }

    public String getNombreCamarero() {
        return nombreCamarero;
    }

    public void setNombreCamarero(String nombreCamarero) {
        this.nombreCamarero = nombreCamarero;
    }

    public String getApellido1Camarero() {
        return apellido1Camarero;
    }

    public void setApellido1Camarero(String apellido1Camarero) {
        this.apellido1Camarero = apellido1Camarero;
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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
