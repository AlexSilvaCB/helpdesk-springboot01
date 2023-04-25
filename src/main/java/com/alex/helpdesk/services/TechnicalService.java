package com.alex.helpdesk.services;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.dto.TechnicalDTO;
import com.alex.helpdesk.domain.entities.Technical;
import com.alex.helpdesk.repositories.TechnicalRepository;
import com.alex.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicalService {
	
	@Autowired
	private TechnicalRepository repository;
	
	
	public Technical findById(Long id) {	
		Optional<Technical> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! id: " + id));
	}
	
	public List<Technical> findAll() {
		return repository.findAll();
	}

	
	public Technical create(TechnicalDTO objDTO) {
			objDTO.setId(null);
			Technical newObj = new Technical(objDTO);
			return repository.save(newObj);
	}
	
	
	
}
