package com.alex.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.helpdesk.domain.entities.Entities;

public interface EntitiesRepository extends JpaRepository<Entities, Long> {

}
