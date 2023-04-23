package com.alex.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.helpdesk.domain.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
