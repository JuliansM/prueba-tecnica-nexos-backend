package com.nexos.demo.controllers;

import com.nexos.demo.facades.MesaFacade;
import com.nexos.demo.models.dto.MesaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class MesaController {

    private final MesaFacade mesaFacade;

    public MesaController(MesaFacade mesaFacade) {
        this.mesaFacade = mesaFacade;
    }

    @GetMapping
    public List<MesaDTO> obtenerClientes() {
        return mesaFacade.obtenerMesas();
    }
}
