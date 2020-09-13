package com.nexos.demo.controllers;

import com.nexos.demo.facades.CocineroFacade;
import com.nexos.demo.models.dto.CocineroDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@RequestMapping("/api/cocineros")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CocineroController {

    private final CocineroFacade cocineroFacade;

    public CocineroController(CocineroFacade cocineroFacade) {
        this.cocineroFacade = cocineroFacade;
    }

    @GetMapping
    public List<CocineroDTO> obtenerCocineros() {
        return cocineroFacade.obtenerCocineros();
    }
}
