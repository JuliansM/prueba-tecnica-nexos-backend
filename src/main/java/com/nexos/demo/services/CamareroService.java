package com.nexos.demo.services;

import com.nexos.demo.models.Camarero;
import com.nexos.demo.repositories.CamareroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CamareroService {

    private final CamareroRepository camareroRepository;

    public CamareroService(CamareroRepository camareroRepository) {
        this.camareroRepository = camareroRepository;
    }

    public List<Camarero> findAll() {
        return camareroRepository.findAll();
    }

    public Camarero findById(String id) {
        return camareroRepository.findById(id)
                .orElseThrow(null);
    }

    public Camarero save(Camarero camarero) {
        return camareroRepository.save(camarero);
    }
}
