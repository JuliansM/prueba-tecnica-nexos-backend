package com.nexos.demo.repositories;

import com.nexos.demo.models.Camarero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamareroRepository extends JpaRepository<Camarero, String> {
}
