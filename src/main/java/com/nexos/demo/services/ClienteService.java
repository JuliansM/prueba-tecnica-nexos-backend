package com.nexos.demo.services;

import com.nexos.demo.models.Cliente;
import com.nexos.demo.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(String id) {
        return clienteRepository.findById(id)
                .orElseThrow(null);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
