package com.springboot.accenture.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.accenture.app.models.Sucursal;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

}
