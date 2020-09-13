package com.nexos.demo.facades;

import com.nexos.demo.models.dto.CocineroDTO;
import com.nexos.demo.services.CocineroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CocineroFacade {

    private final CocineroService cocineroService;
    private final ModelMapper modelMapper;

    public CocineroFacade(CocineroService cocineroService, ModelMapper modelMapper) {
        this.cocineroService = cocineroService;
        this.modelMapper = modelMapper;
    }

    public List<CocineroDTO> obtenerCocineros() {
        return cocineroService.findAll().stream()
                .map(cocinero -> modelMapper.map(cocinero, CocineroDTO.class))
                .collect(Collectors.toList());
    }
}
