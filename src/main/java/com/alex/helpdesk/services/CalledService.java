package com.alex.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.entities.Called;
import com.alex.helpdesk.repositories.CalledRepository;
import com.alex.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class CalledService {

	@Autowired
	private CalledRepository calledRepository;
	
	public Called findById(Long id) {	
		Optional<Called> obj = calledRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! id: " + id));
	}
	
	public List<Called> findAll() {
		return calledRepository.findAll();
	}
	
}
