package com.alex.helpdesk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.helpdesk.domain.entities.Entities;

public interface EntitiesRepository extends JpaRepository<Entities, Long> {
	
	Optional<Entities> findByCpf(String cpf);
	Optional<Entities> findByEmail(String email);
	
}
