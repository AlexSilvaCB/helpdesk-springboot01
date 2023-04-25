package com.alex.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Long;

import com.alex.helpdesk.domain.entities.Technical;
import com.alex.helpdesk.services.TechnicalService;

@RestController
@RequestMapping(value = "/technical")
public class TechnicalResource {
	
	@Autowired
	private TechnicalService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Technical> findById(@PathVariable Long id) {
		Technical obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
