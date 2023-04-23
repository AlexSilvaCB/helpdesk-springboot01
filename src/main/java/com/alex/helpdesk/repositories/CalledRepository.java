package com.alex.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.helpdesk.domain.entities.Called;

public interface CalledRepository extends JpaRepository<Called, Long> {

}
