package com.nexos.demo.repositories;

import com.nexos.demo.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    List<Optional<Factura>> findByIdCamarero(String idCamarero);

    List<Optional<Factura>> findByIdCliente(String idCliente);
}
