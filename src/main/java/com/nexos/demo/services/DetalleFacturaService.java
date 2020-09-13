package com.nexos.demo.services;

import com.nexos.demo.models.DetalleFactura;
import com.nexos.demo.repositories.DetalleFacturaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DetalleFacturaService {

    private final DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaService(DetalleFacturaRepository detalleFacturaRepository) {
        this.detalleFacturaRepository = detalleFacturaRepository;
    }

    public List<DetalleFactura> findAll() {
        return detalleFacturaRepository.findAll();
    }

    public DetalleFactura findById(Integer id) {
        return detalleFacturaRepository.findById(id)
                .orElseThrow(null);
    }

    public DetalleFactura save(DetalleFactura detalleFactura) {
        return detalleFacturaRepository.save(detalleFactura);
    }

    public List<DetalleFactura> findByIdFactura(Integer idFactura) {
        return detalleFacturaRepository.findByIdFactura(idFactura).stream()
                .map(detalleFact -> {
                    if (detalleFact.isPresent()) {
                        return detalleFact.get();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }
}
