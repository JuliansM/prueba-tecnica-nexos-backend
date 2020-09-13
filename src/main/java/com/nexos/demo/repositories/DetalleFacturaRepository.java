package com.nexos.demo.repositories;

import com.nexos.demo.models.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {

    List<Optional<DetalleFactura>> findByIdFactura(Integer idFactura);
}
