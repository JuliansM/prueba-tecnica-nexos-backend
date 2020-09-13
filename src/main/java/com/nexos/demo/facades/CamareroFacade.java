package com.nexos.demo.facades;

import com.nexos.demo.models.Camarero;
import com.nexos.demo.models.DetalleFactura;
import com.nexos.demo.models.Factura;
import com.nexos.demo.models.builders.CamareroFacturaBuilder;
import com.nexos.demo.models.dto.CamareroDTO;
import com.nexos.demo.models.dto.DetalleFacturaDTO;
import com.nexos.demo.models.dto.FacturaDTO;
import com.nexos.demo.services.CamareroService;
import com.nexos.demo.services.DetalleFacturaService;
import com.nexos.demo.services.FacturaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CamareroFacade {

    private final CamareroService camareroService;
    private final FacturaService facturaService;
    private final DetalleFacturaService detalleFacturaService;
    private final ModelMapper modelMapper;

    public CamareroFacade(CamareroService camareroService, FacturaService facturaService,
                          ModelMapper modelMapper, DetalleFacturaService detalleFacturaService) {
        this.camareroService = camareroService;
        this.facturaService = facturaService;
        this.modelMapper = modelMapper;
        this.detalleFacturaService = detalleFacturaService;
    }

    public List<CamareroDTO> obtenerCamareros() {
        return camareroService.findAll().stream()
                .map(camarero -> modelMapper.map(camarero, CamareroDTO.class))
                .collect(Collectors.toList());
    }

    public List<CamareroFacturaBuilder> obtenerCamarerosFactura() {
        List<CamareroFacturaBuilder> camareroFacturaBuilders = new ArrayList<>();
        List<Camarero> camareros = camareroService.findAll();

        camareros.forEach(camarero -> {
            CamareroFacturaBuilder camareroFacturaBuilder = new CamareroFacturaBuilder();

            camareroFacturaBuilder.setIdCamarero(camarero.getIdCamarero());
            camareroFacturaBuilder.setNombreCamarero(camarero.getNombre());
            camareroFacturaBuilder.setApellido1Camarero(camarero.getApellido1());

            List<Factura> facturas = facturaService.findByIdCamarero(camarero.getIdCamarero());
            if (facturas != null) {
                camareroFacturaBuilder.setFacturaDTOS(facturas.stream()
                        .map(fac -> modelMapper.map(fac, FacturaDTO.class))
                        .collect(Collectors.toList()));
            }
            camareroFacturaBuilders.add(camareroFacturaBuilder);
        });

        camareroFacturaBuilders.forEach(camBuild -> camBuild.getFacturaDTOS().forEach(fac -> {
            camBuild.obtenerMes(fac.getFechaFactura());
            List<DetalleFactura> detalleFacturas = detalleFacturaService.findByIdFactura(fac.getIdFactura());
            if (detalleFacturas != null) {
                camBuild.setDetalleFacturaDTOS(detalleFacturas.stream()
                .map(det -> modelMapper.map(det, DetalleFacturaDTO.class))
                .collect(Collectors.toList()));
            }
        }));
        return camareroFacturaBuilders;
    }
}
