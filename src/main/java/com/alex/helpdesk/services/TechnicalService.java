package com.alex.helpdesk.services;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.entities.Technical;
import com.alex.helpdesk.repositories.TechnicalRepository;

@Service
public class TechnicalService {
	
	@Autowired
	private TechnicalRepository repository;
	
	
	public Technical findById(Long id) {	
		Optional<Technical> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Technical> findAll() {
		return repository.findAll();
	}
	
}
