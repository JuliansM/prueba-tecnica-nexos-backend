package com.nexos.demo.repositories;

import com.nexos.demo.models.Cocinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocineroRepository extends JpaRepository<Cocinero, String> {
}
