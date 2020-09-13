package com.nexos.demo.facades;

import com.nexos.demo.models.dto.MesaDTO;
import com.nexos.demo.services.MesaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MesaFacade {

    private final MesaService mesaService;
    private final ModelMapper modelMapper;

    public MesaFacade(MesaService mesaService, ModelMapper modelMapper) {
        this.mesaService = mesaService;
        this.modelMapper = modelMapper;
    }

    public List<MesaDTO> obtenerMesas() {
        return mesaService.findAll().stream()
                .map(mesa -> modelMapper.map(mesa, MesaDTO.class))
                .collect(Collectors.toList());
    }
}
