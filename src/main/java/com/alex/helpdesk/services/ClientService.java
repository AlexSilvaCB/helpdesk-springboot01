package com.alex.helpdesk.services;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.alex.helpdesk.domain.dto.ClientDTO;
import com.alex.helpdesk.domain.entities.Entities;
import com.alex.helpdesk.domain.entities.Client;
import com.alex.helpdesk.repositories.EntitiesRepository;
import com.alex.helpdesk.repositories.ClientRepository;
import com.alex.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private EntitiesRepository enRepository;
	
	
	public Client findById(Long id) {	
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! id: " + id));
	}
	
	public List<Client> findAll() {
		return repository.findAll();
	}

	
	public Client create(ClientDTO objDTO) {
		objDTO.setId(null);
		validCpfEmail(objDTO);
		Client newObj = new Client(objDTO);
		return repository.save(newObj);
	}
	
	public Client update(Long id, @Valid ClientDTO objDTO) {
		objDTO.setId(id);
		Client oldObj = findById(id);
		validCpfEmail(objDTO);
		oldObj = new Client(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Long id) {
			Client obj = findById(id);
			if(obj.getCalleds().size() > 0) {
				throw new DataIntegrityViolationException("Client has work orders and cannot be deleted!");
			}else {
				repository.deleteById(id);
			}
			
		}
	

	private void validCpfEmail(ClientDTO objDTO) {
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
