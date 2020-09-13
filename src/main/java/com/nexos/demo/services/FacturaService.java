package com.nexos.demo.services;

import com.nexos.demo.models.Factura;
import com.nexos.demo.repositories.FacturaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    public List<Factura> findByIdCamarero(String idCamarero) {
        return facturaRepository.findByIdCamarero(idCamarero).stream()
                .map(factura -> {
                    if (factura.isPresent()) {
                        return factura.get();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }

    public List<Factura> findByIdCliente(String idCliente) {
        return facturaRepository.findByIdCliente(idCliente).stream()
                .map(factura -> {
                    if (factura.isPresent()) {
                        return factura.get();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }
}
