package com.nexos.demo.controllers;

import com.nexos.demo.facades.FacturaFacade;
import com.nexos.demo.models.dto.FacturaDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class FacturaController {

    private final FacturaFacade facturaFacade;

    public FacturaController(FacturaFacade facturaFacade) {
        this.facturaFacade = facturaFacade;
    }

    @PostMapping("/registrar-factura")
    public FacturaDTO registrarFactura(@RequestBody FacturaDTO facturaDTO) {
        FacturaDTO factura = facturaFacade.registrarFactura(facturaDTO);
        return factura;
    }
}
