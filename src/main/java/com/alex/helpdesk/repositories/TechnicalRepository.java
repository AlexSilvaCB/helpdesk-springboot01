package com.alex.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.helpdesk.domain.entities.Technical;

public interface TechnicalRepository extends JpaRepository<Technical, Long> {

}
