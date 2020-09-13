package com.nexos.demo.controllers;

import com.nexos.demo.facades.CamareroFacade;
import com.nexos.demo.models.builders.CamareroFacturaBuilder;
import com.nexos.demo.models.dto.CamareroDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@RequestMapping("/api/camareros")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CamareroController {

    private final CamareroFacade camareroFacade;

    public CamareroController(CamareroFacade camareroFacade) {
        this.camareroFacade = camareroFacade;
    }

    @GetMapping
    public List<CamareroDTO> obtenerCamareros() {
        return camareroFacade.obtenerCamareros();
    }

    @GetMapping("/obtener-reporte-camareros")
    public List<CamareroFacturaBuilder> obtenerReporteCamareroFacturas() {
        return camareroFacade.obtenerCamarerosFactura();
    }

}
