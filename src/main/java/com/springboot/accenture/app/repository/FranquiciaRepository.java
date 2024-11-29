package com.springboot.accenture.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.accenture.app.models.Franquicia;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {

}
