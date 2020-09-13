package com.nexos.demo.facades;

import com.nexos.demo.models.DetalleFactura;
import com.nexos.demo.models.Factura;
import com.nexos.demo.models.dto.DetalleFacturaDTO;
import com.nexos.demo.models.dto.FacturaDTO;
import com.nexos.demo.services.DetalleFacturaService;
import com.nexos.demo.services.FacturaService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FacturaFacade {

    private Logger logger = LoggerFactory.getLogger(FacturaFacade.class);

    private final ModelMapper modelMapper;
    private final FacturaService facturaService;
    private final DetalleFacturaService detalleFacturaService;
    private final KieContainer kieContainer;

    public FacturaFacade(ModelMapper modelMapper, FacturaService facturaService,
                         DetalleFacturaService detalleFacturaService, KieContainer kieContainer) {
        this.modelMapper = modelMapper;
        this.facturaService = facturaService;
        this.detalleFacturaService = detalleFacturaService;
        this.kieContainer = kieContainer;
    }

    public void ejecutarReglasDrools(List<DetalleFacturaDTO> detalleFacturaDTOS) {
        try {
            detalleFacturaDTOS.forEach(detalle -> {
                KieSession kieSession = kieContainer.newKieSession();
                kieSession.insert(detalle);
                kieSession.setGlobal("logger", logger);
                kieSession.fireAllRules();
                kieSession.dispose();
            });
        } catch (NullPointerException exception) {
            logger.info("Error intentando ejecutar las reglas" + exception.getMessage());
        }
    }

    public FacturaDTO registrarFactura(@NotNull FacturaDTO facturaDTO) {
        facturaDTO.setFechaFactura(LocalDateTime.now());
        List<DetalleFacturaDTO> detallesFacturaDTO = facturaDTO.getDetalleFacturas();
        facturaDTO.setDetalleFacturas(null);

        ejecutarReglasDrools(detallesFacturaDTO);

        Factura factura = facturaService.save(modelMapper.map(facturaDTO, Factura.class));

        List<DetalleFactura> detallesFactura = detallesFacturaDTO.stream()
                .map(detalleDTO -> modelMapper.map(detalleDTO, DetalleFactura.class))
                .collect(Collectors.toList());

        detallesFactura.forEach(detalle -> {
            detalle.setIdFactura(factura.getIdFactura());
            detalleFacturaService.save(detalle);
        });

        List<DetalleFacturaDTO> detalleFacturaDTOS = detallesFactura.stream()
                .map(detalle -> modelMapper.map(detalle, DetalleFacturaDTO.class))
                .collect(Collectors.toList());

        FacturaDTO facturado = modelMapper.map(factura, FacturaDTO.class);
        facturado.setDetalleFacturas(detalleFacturaDTOS);
        return facturado;
    }
}
