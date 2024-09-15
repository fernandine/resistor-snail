package com.api_challenge.resistor.repository;

import com.api_challenge.resistor.entities.Resistor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResistorRepository extends JpaRepository<Resistor, Long> {
}
