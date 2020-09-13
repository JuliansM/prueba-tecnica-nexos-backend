package com.nexos.demo.controllers;

import com.nexos.demo.facades.ClienteFacade;
import com.nexos.demo.models.builders.ClienteFacturaBuilder;
import com.nexos.demo.models.dto.ClienteDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ClienteController {

    private final ClienteFacade clienteFacade;

    public ClienteController(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    @GetMapping
    public List<ClienteDTO> obtenerClientes() {
        return clienteFacade.obtenerClientes();
    }

    @GetMapping("/obtener-reporte-clientes")
    public List<ClienteFacturaBuilder> obtenerReporteClientesFacturas() {
        return clienteFacade.obtenerClientesFactura();
    }
}
