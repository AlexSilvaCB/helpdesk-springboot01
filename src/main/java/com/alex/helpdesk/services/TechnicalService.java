package com.alex.helpdesk.services;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.dto.TechnicalDTO;
import com.alex.helpdesk.domain.entities.Entities;
import com.alex.helpdesk.domain.entities.Technical;
import com.alex.helpdesk.repositories.EntitiesRepository;
import com.alex.helpdesk.repositories.TechnicalRepository;
import com.alex.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicalService {
	
	@Autowired
	private TechnicalRepository repository;
	
	@Autowired
	private EntitiesRepository enRepository;
	
	
	public Technical findById(Long id) {	
		Optional<Technical> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! id: " + id));
	}
	
	public List<Technical> findAll() {
		return repository.findAll();
	}

	
	public Technical create(TechnicalDTO objDTO) {
			objDTO.setId(null);
			validCpfEmail(objDTO);
			Technical newObj = new Technical(objDTO);
			return repository.save(newObj);
	}

	private void validCpfEmail(TechnicalDTO objDTO) {
		Optional<Entities> obj = enRepository.findByCpf(objDTO.getCpf());
			if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
				throw new DataIntegrityViolationException("CPF already registered in the system");
			}
			
			obj = enRepository.findByEmail(objDTO.getEmail());
			if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
				throw new DataIntegrityViolationException("Email already registered in the system");
			}
	}
	
	
	
}
