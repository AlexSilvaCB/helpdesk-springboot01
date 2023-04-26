package com.alex.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.dto.CalledDTO;
import com.alex.helpdesk.domain.entities.Called;
import com.alex.helpdesk.domain.entities.Client;
import com.alex.helpdesk.domain.entities.Technical;
import com.alex.helpdesk.domain.enums.Priority;
import com.alex.helpdesk.domain.enums.Status;
import com.alex.helpdesk.repositories.CalledRepository;
import com.alex.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class CalledService {

	@Autowired
	private CalledRepository calledRepository;
	
	@Autowired
	private TechnicalService technicalService;
	
	@Autowired
	private ClientService clientService;
	
	
	public Called findById(Long id) {	
		Optional<Called> obj = calledRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! id: " + id));
	}
	
	public List<Called> findAll() {
		return calledRepository.findAll();
	}
	
	public Called create(@Valid CalledDTO objDTO) {
		return calledRepository.save(newCalled(objDTO));
	}

	
	private Called newCalled(CalledDTO obj) {
		Technical technical = technicalService.findById(obj.getTechnical());
		Client client = clientService.findById(obj.getClient());
		
		Called called = new Called();
		if(obj.getId() != null) {
			called.setId(obj.getId());
		}
		
		called.setTechnical(technical);
		called.setClient(client);
		called.setPriority(Priority.toEnum(obj.getPriority()));
		called.setStatus(Status.toEnum(obj.getStatus()));
		called.setTitle(obj.getTitle());
		called.setComments(obj.getComments());
		return called;
		
	}
	
	
	
	
	
	
	
}
