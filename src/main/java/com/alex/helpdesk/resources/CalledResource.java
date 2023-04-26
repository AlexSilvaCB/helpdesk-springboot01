package com.alex.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.helpdesk.domain.dto.CalledDTO;
import com.alex.helpdesk.domain.entities.Called;
import com.alex.helpdesk.services.CalledService;

@RestController
@RequestMapping(value = "/called")
public class CalledResource {

	@Autowired
	private CalledService calledService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CalledDTO> findById(@PathVariable Long id) {
		Called obj = calledService.findById(id);
		return ResponseEntity.ok().body(new CalledDTO(obj));
	}
}
