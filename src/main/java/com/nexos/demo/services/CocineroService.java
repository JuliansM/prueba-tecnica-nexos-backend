package com.nexos.demo.services;

import com.nexos.demo.models.Cocinero;
import com.nexos.demo.repositories.CocineroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CocineroService {

    private final CocineroRepository cocineroRepository;

    public CocineroService(CocineroRepository cocineroRepository) {
        this.cocineroRepository = cocineroRepository;
    }

    public List<Cocinero> findAll() {
        return cocineroRepository.findAll();
    }
}
